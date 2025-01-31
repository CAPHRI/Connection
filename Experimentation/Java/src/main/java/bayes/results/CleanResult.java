package bayes.results;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanResult {
    private String details;
    private String confusionMatrix;

    private double auc;

    public double getAuc() {
        return auc;
    }

    public void setAuc(double auc) {
        this.auc = auc;
    }

    private Map<String, Validation> validations = new HashedMap();

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getConfusionMatrix() {
        return confusionMatrix;
    }

    public void setConfusionMatrix(String confusionMatrix) {
        this.confusionMatrix = confusionMatrix;
    }

    @Override
    public String toString() {
        String s = "";
        s += "\n" + details;
        s += "\n";
        s += confusionMatrix;
        s += "\n\n";

        return s;
    }

    public String toCSV() {
        String s = "";

        s = replaceSingleSpaces(details);
        while (s.contains("  ")) {
            s = s.replace("  ", " ");
        }
        s = s.replace(" ", ";");
        s = s.replace("%", " ");

        s += "\n";
        String b = replaceSingleSpaces(confusionMatrix);
        while (b.contains("  ")) {
            b = b.replace("  ", " ");
        }
        b = b.replace(" ", ";");
        b = b.replace("%", " ");
        s += b;
        s += "\n\n";

        return s;
    }

    private String replaceSingleSpaces(String s) {
        boolean done = false;
        while (!done) {
            Pattern p = Pattern.compile("\\S\s\\S");
            Matcher m = p.matcher(s);
            if (m.find()) {
                int index = m.start() + 1;
                s = s.substring(0, index) + "%" + s.substring(index + 1, s.length() - 1);
            } else {
                done = true;
            }
        }
        return s;
    }
}
