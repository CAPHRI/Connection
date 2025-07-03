package weka.classifiers;

import weka.WekaClassifier;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.functions.Logistic;


public class LogRegClassifier extends WekaClassifier {
    private Logistic classifier;

    public LogRegClassifier() {
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

    private static Logistic createLogistic() {
        Logistic l = new Logistic();
        return l;
    }
}
