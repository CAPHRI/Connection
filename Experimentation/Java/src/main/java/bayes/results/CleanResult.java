package bayes.results;

import org.apache.commons.collections.map.HashedMap;

import java.util.List;
import java.util.Map;

import static bayes.util.BifMapper.fromWekaBif;
import static bayes.util.BifMapper.toOpenMarkovBif;

public class CleanResult {
    private List<DatasetPredictions> predictions;
    private int maxParents;
    private boolean naiveBayes;
    private boolean dag;

    private String graph;
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

    public int getMaxParents() {
        return maxParents;
    }

    public void setMaxParents(int maxParents) {
        this.maxParents = maxParents;
    }

    public boolean isNaiveBayes() {
        return naiveBayes;
    }

    public void setNaiveBayes(boolean naiveBayes) {
        this.naiveBayes = naiveBayes;
    }

    public boolean isDag() {
        return dag;
    }

    public void setDag(boolean dag) {
        this.dag = dag;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

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
        String s = "Max parents: " + maxParents + " initNaive: " + naiveBayes + " DAG: " + dag;
        s += "\n" + details;
        s += "ConfusionMatrix \n";
        s += confusionMatrix;
        s += "\n\n";

        if (graph != null && graph.length() > 0) {
            s += "\n\n\n\n\n";
            s += toOpenMarkovBif(fromWekaBif(graph));
        }
        return s;
    }
}
