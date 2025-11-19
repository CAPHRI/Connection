package weka.classifiers;

import weka.WekaClassifier;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.functions.Logistic;


public class LogRegClassifier extends WekaClassifier {
    private Logistic classifier;
    private int iterations =-1;

    public LogRegClassifier() {
        createClassifier();
    }
    public LogRegClassifier(int it) {
        this.iterations = it;
        createClassifier();
    }

    @Override
    protected void createClassifier() {
        this.classifier = createLogistic();
    }

    @Override
    public Logistic getClassifier() {
        return classifier;
    }

    private Logistic createLogistic() {
        Logistic l = new Logistic();
        if(iterations >0) {
            l.setMaxIts(this.iterations);
        }
        return l;
    }
}
