package bayes.results;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

import static bayes.util.BifMapper.fromWekaBif;
import static bayes.util.BifMapper.toOpenMarkovBif;

public class CombinedResult {
    Map<String, CleanResult> results = new HashedMap();
    private String graph;
    private boolean naiveBayes;
    private boolean dag;
    private int maxParents;

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

    public Map<String, CleanResult> getResults() {
        return results;
    }

    public void setResults(Map<String, CleanResult> results) {
        this.results = results;
    }

    public int getMaxParents() {
        return maxParents;
    }

    public void setMaxParents(int maxParents) {
        this.maxParents = maxParents;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }


    public String printGraph() {
        return toOpenMarkovBif(fromWekaBif(graph));
    }

    @Override
    public String toString() {
        String s = "Max parents: " + maxParents + " initNaive: " + naiveBayes + " DAG: " + dag;
        s += "\n";
        for (String key : results.keySet()) {
            s += key + "\n";
            s += results.get(key);
        }

        return s;
    }

    public String toCSV() {
        String s = "Max parents: " + maxParents + " initNaive: " + naiveBayes + " DAG: " + dag;
        s += "\n";
        for (String key : results.keySet()) {
            s += key + "\n";
            s += results.get(key).toCSV();
        }

        return s;
    }

}
