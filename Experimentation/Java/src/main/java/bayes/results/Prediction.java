package bayes.results;

public class Prediction {
    private double prob;
    private String label;
    private String predicted;

    public void setPredicted(String predicted) {
        this.predicted = predicted;
    }

    public Prediction(double prob, String label) {
        this.prob = prob;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }
}
