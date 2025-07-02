package weka;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;
import java.util.List;
import java.util.Random;

import static weka.WekaUtil.createFilter;
import static weka.WekaUtil.createFilteredClassifier;

public abstract class WekaClassifier {
    private AbstractClassifier classifier;
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
