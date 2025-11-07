package weka.classifiers;

import weka.WekaClassifier;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.ClassificationViaRegression;


public class LinRegClassifier extends WekaClassifier {
    private ClassificationViaRegression classifier;

    public LinRegClassifier() {
        createClassifier();
    }

    @Override
    protected void createClassifier() {
        this.classifier = createLinear();
    }

    @Override
    public ClassificationViaRegression getClassifier() {
        return classifier;
    }

    private static ClassificationViaRegression createLinear() {
        ClassificationViaRegression c = new
                ClassificationViaRegression();

        c.setClassifier(new LinearRegression());
        return c;
    }
}
