package bayes.results;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    private List<DatasetPredictions> predictions = new ArrayList<>();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DatasetPredictions> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<DatasetPredictions> predictions) {
        this.predictions = predictions;
    }

    public String toString() {
        String s = name + "\n";
        s += "Dataset;prob;label;stage\n";
        for (DatasetPredictions p : predictions) {
            s += p.getDataset() + ";" + p.getProb() + ";" + p.getLabel() + ";" + p.getStage() + "\n";
        }
        return s;
    }
}
