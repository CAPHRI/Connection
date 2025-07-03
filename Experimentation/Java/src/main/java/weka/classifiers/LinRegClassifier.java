package weka.classifiers;

import weka.WekaClassifier;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;


public class LinRegClassifier extends WekaClassifier {
    private LinearRegression classifier;

    public LinRegClassifier() {
        createClassifier();
    }

    @Override
    protected void createClassifier() {
        this.classifier = createLinear();
    }

    @Override
    public LinearRegression getClassifier() {
        return classifier;
    }

    private static LinearRegression createLinear() {
        LinearRegression l = new LinearRegression();
        return l;
    }
}
