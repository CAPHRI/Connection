package weka;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.meta.FilteredClassifier;

public abstract class WekaClassifier {
    protected AbstractClassifier classifier;
    protected FilteredClassifier filtered;

    protected abstract void createClassifier();

    public AbstractClassifier getClassifier() {
        return classifier;
    }

    public FilteredClassifier getFiltered() {
        return filtered;
    }

    public void setFiltered(FilteredClassifier filtered){
        this.filtered = filtered;
    }
}
