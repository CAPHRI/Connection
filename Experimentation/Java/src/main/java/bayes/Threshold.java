package bayes;

public class Threshold {

    private double TPR;
    private double TNR;
    private double threshold;

    public double getTPR() {
        return TPR;
    }

    public void setTPR(double TPR) {
        this.TPR = TPR;
    }

    public double getTNR() {
        return TNR;
    }

    public void setTNR(double TNR) {
        this.TNR = TNR;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        String s = "TPR: " + TPR + " TNR: " + TNR + " Threshold: " + threshold + "\n";
        return s;
    }
}
