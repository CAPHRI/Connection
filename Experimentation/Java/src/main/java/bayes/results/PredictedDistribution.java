package bayes.results;

public class PredictedDistribution {
    private double prob;
    private int countTrueLabel;
    private int count;

    public PredictedDistribution(double prob) {
        this.prob = prob;
    }

    public double getProb() {
        return prob;
    }

    public int getCountTrueLabel() {
        return countTrueLabel;
    }

    public void setCountTrueLabel(int countTrueLabel) {
        this.countTrueLabel = countTrueLabel;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
