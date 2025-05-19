package bayes.results;

public class BestWorstResult {
    private CombinedResult worst;
    private CombinedResult best;

    public BestWorstResult(CombinedResult best, CombinedResult worst) {
        this.best = best;
        this.worst = worst;
    }

    public CombinedResult getBest() {
        return best;
    }

    public void setBest(CombinedResult best) {
        this.best = best;
    }

    public CombinedResult getWorst() {
        return worst;
    }

    public void setWorst(CombinedResult worst) {
        this.worst = worst;
    }
}
