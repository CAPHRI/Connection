package bayes.weka;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.knowledgeflow.steps.SubstringLabelerStepEditorDialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class WekaUtil {
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

    public static Instances load200Clean() throws IOException {
        String path = "CSV-files/clean_200.csv";
        return readData("lc", path);
    }

    public static Instances load200Discrete() throws IOException {
        String path = "CSV-files/discretized_200.csv";
        return readData("lc", path);
    }
}
