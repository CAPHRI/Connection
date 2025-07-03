package bayes.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class PrintingPress {

    private PrintingPress() {
    }

    public static void printString(String string, String path){
        File bifFile = new File(path);
        List<String> data = Arrays.stream(string.split("\n")).collect(Collectors.toList());
        try (PrintWriter pw = new PrintWriter(bifFile)) {
            data.stream()
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printCSV(List<String> data, String path) {
        File csvOutputFile = new File(path);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            data.stream()
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String prettyPrintByTransformer(String xmlString) {
        boolean ignoreDeclaration = false;
        int indent = 2;
        try {
            InputSource src = new InputSource(new StringReader(xmlString));
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src);

            TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, ignoreDeclaration ? "yes" : "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            Writer out = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(out));
            return out.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error occurs when pretty-printing xml:\n" + xmlString, e);
        }
    }

    public static void prettyPrintResultCSV(String s, String path) {
        File csvOutputFile = new File(path);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.print(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sortArrf(String path) throws FileNotFoundException {
        // sort attribute values alphabeticly. Makes them slightly easier to read
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        String text = "";
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if(data.contains("@attribute") && ! data.contains("numeric")){
                String[] t = data.split("\\{");
                if(t.length != 2){
                    throw new RuntimeException("Attribute "+ data + " contains {");
                }else{
                    String string = t[0] + "{";
                    String secondHalf = t[1].replace("}", "");
                    String[] second = secondHalf.split(",");
                    if(secondHalf.contains("'")){
                        secondHalf.replace("','", "';'");
                        second = secondHalf.split(";");
                    }
                    Arrays.sort(second);
                    for (int i = 0; i < second.length; i++){
                        if(i > 0) {
                            string += ",";
                        }
                        string+=second[i];
                    }
                    text += string + "}\n";
                }
            }else {
                text += data +"\n";
            }
        }
        prettyPrintResultCSV(text, path);
    }

}
