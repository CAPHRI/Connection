package bayes;

public class ROCPoint {
    private double tpr;
    private double fpr;
    private double threshold;

    public ROCPoint(double tpr, double fpr, double threshold) {
        this.tpr = tpr;
        this.fpr = fpr;
        this.threshold = threshold;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getTpr() {
        return tpr;
    }

    public void setTpr(double tpr) {
        this.tpr = tpr;
    }

    public double getFpr() {
        return fpr;
    }

    public void setFpr(double fpr) {
        this.fpr = fpr;
    }
}
