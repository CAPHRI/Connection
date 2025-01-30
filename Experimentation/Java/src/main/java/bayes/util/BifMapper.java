package bayes.util;

import bayes.Bin;
import bayes.Node;
import bayes.Theta;
import bayes.Value;

import java.util.*;
import java.util.stream.Collectors;

public final class BifMapper {
    // Utility class that can turn a WEKA bif into our network structure and vice-versa

    public static final int THREE = 3;

    private BifMapper() {
    }

    public static List<Node> fromOpenMarkovBifSimplified(String bif) {
        bif = bif.replace("\r", "");
        bif = bif.replace(MARKOVHEADER, "");
        bif = bif.replace(MARKOVFOOTER, "");
        bif = bif.replace("\n", "").replace("\"", "").replace("/>", "");
        List<Node> nodes = new ArrayList<>();


        Map<String, List<String>> states = new HashMap<>();
        Map<String, List<Bin>> bins = new HashMap<>();
        if (bif.contains("</Links>")) {
            String[] split1 = bif.split("<Links>");
            String[] variables = split1[0].replace("<Variables>", "").replace("</Variables>", "").split("</Variable>");
            nodes.addAll(createNodes(variables, states, bins));
            String[] split2 = split1[1].split("</Links>");
            String[] links = split2[0].replace("<Link directed=true>", "").split("</Link>");
            linkParents(nodes, links);
        } else {
            String[] split1 = bif.split("<Links");
            String[] variables = split1[0].replace("<Variables>", "").replace("</Variables>", "").split("</Variable>");
            nodes.addAll(createNodes(variables, states, bins));
        }

        return nodes;
    }

    private static Node findNode(String name, List<Node> nodes) {
        for (Node n : nodes) {
            if (n.getName().equals(name)) {
                return n;
            }
        }
        return null;
    }

    private static void linkParents(List<Node> nodes, String[] links) {
        for (String l : links) {
            //take substring to skip the first symbol
            l = l.replace(" ", "").replace("<Variablename=", " ");
            if (l.isEmpty()) {
                continue;
            } else {
                l = l.substring(1);
            }
            String[] pairs = l.split(" ");
            Node parent = findNode(pairs[0], nodes);
            Node child = findNode(pairs[1], nodes);
            try {
                child.getParents().add(parent.getName());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static List<Node> createNodes(String[] variables, Map<String, List<String>> uniqueValues,
                                          Map<String, List<Bin>> bins) {
        List<Node> nodes = new ArrayList<>();
        for (String v : variables) {
            v = v.replace(" ", "").split("<Thresholds>")[0];
            if (v.isEmpty()) {
                continue;
            }
            v.replace(" />", "");
            String name = v.replace("<Variablename=", "").split("type=")[0];
            Node n = new Node();
            n.setName(name);
            nodes.add(n);
        }
        return nodes;

    }

    public static String toBIF(List<Node> nodes) {
        String bif = "";
        bif += WEKAHEADER;
        bif += NAME;
        String variables = "";
        String tables = "";

        for (Node node : nodes) {
            variables += createWekaVariable(node);
            tables += createWekaTables(node);
        }
        bif += variables;
        bif += tables;
        bif += WEKAFOOTER;
        return bif;
    }

    private static String createWekaTables(Node node) {
        String s = "";
        s += "<DEFINITION>\n";
        s += "<FOR>" + node.getName() + "</FOR>\n";
        for (String parent : node.getParents()) {
            s += "<GIVEN>" + parent + "</GIVEN>\n";
        }
        s += "<TABLE>\n";
        Set<String> unique = countUnique(node.getProbabilities());
        int count = 0;
        for (int i = 0; i < node.getProbabilities().size(); i++) {
            if (count > 0) {
                s += " ";
            }
            s += node.getProbabilities().get(i).getP();
            count++;
            if ((i + 1) % unique.size() == 0) {
                s += " \n";
                count = 0;
            }
        }
        s += "</TABLE>\n" + "</DEFINITION>\n";
        return s;

    }

    private static String createWekaVariable(Node node) {
        String s = "";
        s += "<VARIABLE TYPE=\"nature\">\n";
        s += "<NAME>" + node.getName() + "</NAME>\n";
        Set<String> unique = countUnique(node.getProbabilities());

        for (int i = 0; i < unique.size(); i++) {
            Theta t = node.getProbabilities().get(i);

            if (!t.getLocalValue().isRange()) {
                s += "<OUTCOME>" + t.getLocalValue().getLocalValue() + "</OUTCOME>\n";
            } else {
                if (t.getLocalValue().getLowerLimit().equals("All")) {
                    s += "<OUTCOME>&apos;All&apos;</OUTCOME>\n";
                } else {
                    s += "<OUTCOME>&apos;(";

                    s += t.getLocalValue().getLowerLimit() + "-" + t.getLocalValue().getUpperLimit();
                    if (i < unique.size() - 1) {
                        s += "]&apos;</OUTCOME>\n";
                    } else {
                        s += ")&apos;</OUTCOME>\n";
                    }
                }
            }
        }

        s += "</VARIABLE>\n";
        return s;
    }


    private static Set<String> countUnique(List<Theta> probabilites) {
        Set<String> unique = new HashSet<>();
        for (Theta t : probabilites) {
            if (!t.getLocalValue().isRange()) {
                unique.add(t.getLocalValue().getLocalValue());
            } else {
                unique.add(t.getLocalValue().getLowerLimit());
            }
        }
        return unique;
    }

    public static List<Node> fromWekaBif(String bif) {
        bif = bif.replace(WEKAHEADER, "").replace(WEKAFOOTER, "");

        String[] split = bif.split("</NAME>", 2)[1].split("</VARIABLE>");
        String tableString = split[split.length - 1];
        String[] tables = tableString.split("</DEFINITION>");

        String[] variables = new String[split.length - 1];
        for (int i = 0; i < split.length - 1; i++) {
            variables[i] = split[i];
        }
        List<Node> nodes = new ArrayList<>();
        for (String v : variables) {
            nodes.add(mapVariable(v));
        }

        for (int i = 0; i < tables.length - 1; i++) {
            mapTable(tables[i], nodes);
        }

        return nodes;
    }

    private static void mapTable(String table, List<Node> nodes) {
        table = table.replace("<DEFINITION>", "");
        String[] split = table.split("</FOR>");
        String name = split[0].replace("<FOR>", "").replace("\n", "");

        Node n = findWebNode(name, nodes);
        boolean hasParents = false;

        if (split[1].contains("</GIVEN>")) {
            hasParents = true;
            split = split[1].split("<TABLE>");
            String[] parents = split[0].split("</GIVEN>");

            for (int i = 0; i < parents.length - 1; i++) {
                String parentName = parents[i].replace("<GIVEN>", "").replace("\n", "");
                n.getParents().add(parentName);
                Node parent = findWebNode(parentName, nodes);
                List<Theta> copies = new ArrayList<>();
                Set<String> count = countUnique(parent.getProbabilities());
                for (int j = 0; j < count.size(); j++) {
                    Theta t = parent.getProbabilities().get(j);
                    for (Theta child : n.getProbabilities()) {
                        //Copy each current child, add the extra new parent
                        Theta copy = new Theta();
                        copy.setLocalValue(child.getLocalValue());
                        copies.add(copy);
                    }
                }
                n.setProbabilities(copies);
            }
        }

        String prob = "";
        if (hasParents) {
            prob = split[1].replace("\n", "").replace("<TABLE>", "").replace("</TABLE>", "");
        } else {
            prob = split[1].replace("\n", "").replace("<TABLE>", "").replace("</TABLE>", "");
        }
        String[] probabilities = prob.split(" ");

        for (int i = 0; i < probabilities.length; i++) {
            try {
                n.getProbabilities().get(i).setP(Double.parseDouble(probabilities[i]));
            } catch (Exception e) {
                System.out.println("");
            }

        }
    }

    private static Node findWebNode(String name, List<Node> nodes) {
        for (Node n : nodes) {
            if (n.getName().equals(name)) {
                return n;
            }
        }
        return null;
    }

    private static Node mapVariable(String variable) {
        variable = variable.replace("<VARIABLE TYPE=\"nature\">", "");
        variable = variable.replace("<NAME>", "");
        String[] split = variable.split("</NAME>");
        Node n = new Node();
        n.setName(split[0].replace("\n", ""));

        for (int i = 1; i < split.length; i++) {
            String[] outcomes = split[i].split("</OUTCOME>");
            for (int j = 0; j < outcomes.length - 1; j++) {
                String outcome = outcomes[j].replace("<OUTCOME>", "");
                if (outcome.contains("&apos;")) {
                    // attribute is a range
                    Bin bin = new Bin();
                    if (outcome.contains(".")) {
                        //attribute is a double
                        n.setType(Node.AttributeType.real);
                    } else {
                        //attribute is an int
                        n.setType(Node.AttributeType.numeric);
                    }
                    String[] limits = outcome.replace("&apos;", "").replace("(", "").replace(")", "").replace("]", "")
                            .split("-");
                    String lower = "";
                    if (limits[0].equals("\n")) {
                        //first limit is empty, indicates the lowr limit was negative
                        lower += "-" + limits[1];
                    } else {
                        lower = limits[0].replace("\n", "");
                    }
                    bin.setLowerLimit(lower);
                    String upper = "";

                    if (limits.length == 1) {
                        //this only happens if it's concluded that all values fall within range
                        upper = lower;
                    } else if (limits.length == 2) {
                        upper = limits[1];
                    } else if (limits[2].equals("\n")) {
                        upper += "-" + limits[THREE];
                    } else {
                        upper = limits[2];
                    }
                    bin.setUpperLimit(upper);
                    n.getBins().add(bin);
                    Value v = new Value();
                    v.setRange(true);
                    v.setLowerLimit(lower);
                    v.setUpperLimit(upper);
                    Theta t = new Theta();
                    t.setLocalValue(v);
                    n.getProbabilities().add(t);
                } else {
                    //Attribute is a string
                    n.setType(Node.AttributeType.string);
                    Value v = new Value();
                    v.setLocalValue(outcome.replace("\n", ""));
                    v.setRange(false);
                    Theta t = new Theta();
                    t.setLocalValue(v);
                    n.getProbabilities().add(t);
                }
            }
        }
        return n;
    }

    public static String toOpenMarkovBif(List<Node> nodes) {
        String bif = "";
        bif = bif +
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<ProbModelXML formatVersion=\"0.2.0\">\n<ProbNet type=\"BayesianNetwork\">\n<DecisionCriteria>\n<Criterion name=\"---\" unit=\"---\"/>\n</DecisionCriteria>\n<Properties/>\n";
        String variables = "";
        String potentials = "";
        String links = "";

        Node node;
        for (Iterator var5 = nodes.iterator(); var5.hasNext(); potentials = potentials + createMarkovPotential(node)) {
            node = (Node) var5.next();
            variables = variables + createMarkovVariable(node);
            links = links + createMarkovLink(node);
        }

        bif = bif + "<Variables>\n";
        bif = bif + variables;
        bif = bif + "</Variables>\n";
        bif = bif + "<Links>\n";
        bif = bif + links;
        bif = bif + "</Links>\n";
        bif = bif + "<Potentials>\n";
        bif = bif + potentials;
        bif = bif + "</Potentials>\n";
        bif = bif +
                "</ProbNet>\n<InferenceOptions>\n<MulticriteriaOptions>\n<SelectedAnalysisType>UNICRITERION</SelectedAnalysisType>\n<Unicriterion>\n<Scales>\n<Scale Criterion=\"---\" Value=\"1.0\"/>\n</Scales>\n</Unicriterion>\n<CostEffectiveness>\n<Scales>\n<Scale Criterion=\"---\" Value=\"1.0\"/>\n</Scales>\n<CE_Criteria>\n<CE_Criterion Criterion=\"---\" Value=\"Cost\"/>\n</CE_Criteria>\n</CostEffectiveness>\n</MulticriteriaOptions>\n</InferenceOptions>\n</ProbModelXML>\n";
        return PrintingPress.prettyPrintByTransformer(bif.replace("\n", ""));
    }

    private static String createMarkovPotential(Node node) {
        String s = "<Potential type=\"Table\" role=\"conditionalProbability\">\n";
        s = s + "<Variables>\n";
        s = s + "<Variable name=\"" + node.getName() + "\"/>\n";

        String parent;
        for (Iterator var2 = node.getParents().iterator(); var2.hasNext();
             s = s + "<Variable name=\"" + parent + "\"/>\n") {
            parent = (String) var2.next();
        }

        s = s + "</Variables>\n";
        s = s + "<Values>";

        for (int i = 0; i < node.getProbabilities().size(); ++i) {
            s = s + node.getProbabilities().get(i).getP();
            if (i != node.getProbabilities().size() - 1) {
                s = s + " ";
            }
        }

        s = s + "</Values>\n";
        s = s + "</Potential>\n";
        return s;
    }

    private static String createMarkovLink(Node node) {

        if (node.getParents().size() == 0) {
            return "";
        }
        String s = "";
        for (String parent : node.getParents()) {
            s += "<Link directed=\"true\">\n";
            s += "<Variable name=\"" + parent + "\"/>\n";
            s += "<Variable name=\"" + node.getName() + "\"/>\n";
            s += "</Link>\n";
        }
        return s;
    }

    private static String createMarkovVariable(Node node) {
        String s = "";
        String treshholds = "";
        String type = "";
        boolean isNumeric = false;
        if (node.getType() != Node.AttributeType.string && node.getType() != Node.AttributeType.bool) {
            type = "\" type=\"discretized\"";
            treshholds = createTreshHolds(node);
            isNumeric = true;
        } else {
            type = "\" type=\"finiteStates\"";
        }

        s = s + "<Variable name=\"" + node.getName() + type + " role=\"chance\">\n";
        if (isNumeric) {
            s = s + "<Unit/>\n";
            s = s + "<Precision>0.01</Precision>\n";
        }

        s = s + "<States>\n";
        s = s + addMarkovStates(node);
        s = s + "</States>\n";
        s = s + treshholds;
        s = s + "</Variable>\n";
        return s;
    }

    private static String createTreshHolds(Node node) {
        String header = "<Thresholds>\n";
        String footer = "</Thresholds>\n";
        Set<String> tresholds = new LinkedHashSet<>();
        Set<String> unique = countUnique(node.getProbabilities());
        node.getProbabilities();
        for (int i = 0; i < unique.size(); i++) {
            Theta t = node.getProbabilities().get(i);
            if (t.getLocalValue().getLowerLimit().equals("-inf")) {
                tresholds.add("-Infinity");
            }
            if (t.getLocalValue().getUpperLimit().equals("inf")) {
                tresholds.add("Infinity");
            }
            if (t.getLocalValue().getLowerLimit().equals("All")) {
                tresholds.add("-Infinity");
            } else if (!t.getLocalValue().getLowerLimit().equals("-inf")) {
                tresholds.add(t.getLocalValue().getLowerLimit());
            }
            if (t.getLocalValue().getUpperLimit().equals("All")) {
                tresholds.add("Infinity");
            } else if (!t.getLocalValue().getUpperLimit().equals("inf")) {
                tresholds.add(t.getLocalValue().getUpperLimit());
            }
        }
        String s = "";
        for (String d : tresholds) {
            if (s.length() == 0) {
                s += header;
                s += "<Threshold value=\"" + d + "\" belongsTo=\"left\"/>\n";
            } else {
                s += "<Threshold value=\"" + d + "\" belongsTo=\"right\"/>\n";
            }
        }
        s += footer;
        return s;
    }

    private static String addMarkovStates(Node node) {
        String s = "";
        List<String> unique = countUnique(node.getProbabilities()).stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < unique.size(); i++) {
            Theta t = node.getProbabilities().get(i);
            if (!t.getLocalValue().isRange()) {
                s += "<State name=\"" + t.getLocalValue().getLocalValue() + "\"/>\n";
            } else {
                s += "<State name=\"" + t.getLocalValue().getLowerLimit() + ";" + t.getLocalValue()
                        .getUpperLimit() + "\"/>\n";
            }
        }
        return s;
    }

    private static final String NAME = "<NAME>clean_1000_english-weka.filters.supervised.attribute" +
            ".Discretize-Rfirst-last-precision6-weka.filters.unsupervised.attribute.ReplaceMissingValues</NAME>\n";

    private static final String WEKAHEADER = "<?xml version=\"1.0\"?>\n" +
            "<!-- DTD for the XMLBIF 0.3 format -->\n" +
            "<!DOCTYPE BIF [\n" +
            "\t<!ELEMENT BIF ( NETWORK )*>\n" +
            "\t      <!ATTLIST BIF VERSION CDATA #REQUIRED>\n" +
            "\t<!ELEMENT NETWORK ( NAME, ( PROPERTY | VARIABLE | DEFINITION )* )>\n" +
            "\t<!ELEMENT NAME (#PCDATA)>\n" +
            "\t<!ELEMENT VARIABLE ( NAME, ( OUTCOME |  PROPERTY )* ) >\n" +
            "\t      <!ATTLIST VARIABLE TYPE (nature|decision|utility) \"nature\">\n" +
            "\t<!ELEMENT OUTCOME (#PCDATA)>\n" +
            "\t<!ELEMENT DEFINITION ( FOR | GIVEN | TABLE | PROPERTY )* >\n" +
            "\t<!ELEMENT FOR (#PCDATA)>\n" +
            "\t<!ELEMENT GIVEN (#PCDATA)>\n" +
            "\t<!ELEMENT TABLE (#PCDATA)>\n" +
            "\t<!ELEMENT PROPERTY (#PCDATA)>\n" +
            "]>\n" +
            "\n" +
            "\n" +
            "<BIF VERSION=\"0.3\">\n" +
            "<NETWORK>\n";

    private static final String WEKAFOOTER = "</NETWORK>\n" + "</BIF>\n";

    private static final String MARKOVHEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<ProbModelXML formatVersion=\"0.2.0\">\n" +
            "  <ProbNet type=\"BayesianNetwork\">\n" +
            "    <DecisionCriteria>\n" +
            "      <Criterion name=\"---\" unit=\"---\" />\n" +
            "    </DecisionCriteria>";

    private static final String MARKOVFOOTER = "  </ProbNet>\n" +
            "  <InferenceOptions>\n" +
            "    <MulticriteriaOptions>\n" +
            "      <SelectedAnalysisType>UNICRITERION</SelectedAnalysisType>\n" +
            "      <Unicriterion>\n" +
            "        <Scales>\n" +
            "          <Scale Criterion=\"---\" Value=\"1.0\"/>\n" +
            "        </Scales>\n" +
            "      </Unicriterion>\n" +
            "      <CostEffectiveness>\n" +
            "        <Scales>\n" +
            "          <Scale Criterion=\"---\" Value=\"1.0\"/>\n" +
            "        </Scales>\n" +
            "        <CE_Criteria>\n" +
            "          <CE_Criterion Criterion=\"---\" Value=\"Cost\"/>\n" +
            "        </CE_Criteria>\n" +
            "      </CostEffectiveness>\n" +
            "    </MulticriteriaOptions>\n" +
            "  </InferenceOptions>\n" +
            "</ProbModelXML>\n";
}
