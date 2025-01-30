package bayes;

public class Theta {
    private Value localValue;
    private double p;

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public Value getLocalValue() {
        return localValue;
    }

    public void setLocalValue(Value localValue) {
        this.localValue = localValue;
    }
}
