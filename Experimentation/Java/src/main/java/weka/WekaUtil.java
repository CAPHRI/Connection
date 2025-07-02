package weka;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class WekaUtil {
    private static int TEN = 10;

    public static FilteredClassifier createFilteredClassifier(AbstractClassifier classifier, Instances data, List<String> toBeKept) throws Exception {
        FilteredClassifier filtered = new FilteredClassifier();
        if (toBeKept != null) {
            Remove filter = (Remove) createFilter(data, toBeKept);
            filtered.setFilter(filter);
            Instances filteredData = Filter.useFilter(data, filter);
            ArffSaver s = new ArffSaver();
            s.setInstances(filteredData);
            s.setFile(new File("resources/results/data.arff"));
            s.writeBatch();
        }
        filtered.setClassifier(classifier);
        return filtered;
    }

    public static Evaluation crossValidate(Instances data, AbstractClassifier classifier) throws Exception {
        Evaluation eval = new Evaluation(data);
        classifier.buildClassifier(data);
        eval.crossValidateModel(classifier, data, TEN, new Random(1));
        eval.predictions();

        return eval;
    }

    public static Instances filterData(Instances data, List<String> toBeKept) throws Exception {
        if (toBeKept == null || toBeKept.size() == 0) {
            //empty list implies keep everything
            return data;
        }

        Remove removeFilter = new Remove();
        int[] indices = new int[toBeKept.size()];
        for (int i = 0; i < toBeKept.size(); i++) {
            indices[i] = data.attribute(toBeKept.get(i)).index();
        }
        removeFilter.setAttributeIndicesArray(indices);
        removeFilter.setInvertSelection(true);
        removeFilter.setInputFormat(data);
        return Filter.useFilter(data, removeFilter);
    }

    public static Filter createFilter(Instances data, List<String> toBeKept) throws Exception {
        Remove removeFilter = new Remove();
        int[] indices = new int[toBeKept.size()];
        for (int i = 0; i < toBeKept.size(); i++) {
            try{
            indices[i] = data.attribute(toBeKept.get(i)).index();}
            catch(Exception e){
                System.out.println(toBeKept.get(i));
                throw e;
            }
        }
        removeFilter.setAttributeIndicesArray(indices);
        removeFilter.setInvertSelection(true);
        removeFilter.setInputFormat(data);
        return removeFilter;
    }

    public static Instances readData(String target, String arff) throws IOException {
        Instances data;
        if (arff.contains(".csv")) {
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(arff));
            data = loader.getDataSet();
        } else {
            data = new Instances(
                    new BufferedReader(new FileReader(arff)));
        }
        for (int i = 0; i < data.numAttributes(); i++) {
            if (data.attribute(i).name().equals(target)) {
                data.setClassIndex(i);
                break;
            }
        }
        return data;
    }
}
