package bayes.util;

import bayes.Node;
import bayes.Theta;
import bayes.Value;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static bayes.util.PrintingPress.printCSV;

public final class Util {

    private Util() {
    }

    public static Theta createTheta(String localValue) {
        Value v = new Value();
        v.setRange(false);
        v.setLocalValue(localValue);
        Theta t = new Theta();
        t.setLocalValue(v);
        return t;
    }

    public static Theta createTheta(String lowerLimit, String upperLimit) {
        Value v = new Value();
        v.setRange(true);
        v.setLowerLimit(lowerLimit);
        v.setUpperLimit(upperLimit);
        Theta t = new Theta();
        t.setLocalValue(v);
        return t;
    }

    public static Node createNode(String name, Node.AttributeType type, List<String> parents) {
        Node n = new Node();
        n.setType(type);
        n.setName(name);
        n.setParents(parents);
        return n;
    }

    public static Node createNode(String name, Node.AttributeType type) {
        Node n = new Node();
        n.setType(type);
        n.setName(name);
        return n;
    }

    public static void generateMissingData(String path, double threshold, String target) {
        List<List<String>> records = readCsv(path);
        Random r = new Random();
        List<String> printed = new ArrayList<>();
        for (int j = 0; j < records.size(); j++) {
            String s = "";

            for (int i = 0; i < records.get(j).size(); i++) {
                if (j != 0 && r.nextDouble() < threshold && ignoreableColumns(records, i)) {
                    records.get(j).set(i, "?");
                }
                if (s.length() > 0) {
                    s += ",";
                }
                s += records.get(j).get(i);
            }
            printed.add(s);
        }
        printCSV(printed, target);
    }

    private static boolean ignoreableColumns(List<List<String>> records, int i) {
        // ignore lc cpr_hash and stage
        return !records.get(0).get(i).equals("lc") &&
                !records.get(0).get(i).equals("cpr_hash") && !records.get(0).get(i).equals("stage");
    }

    private static List<List<String>> readCsv(String path) {
        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
