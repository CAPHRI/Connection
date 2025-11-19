import bayes.results.CleanResult;
import bayes.results.CombinedResult;
import weka.WekaClassifier;
import weka.classifiers.Evaluation;
import weka.classifiers.LinRegClassifier;
import weka.classifiers.LogRegClassifier;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;
import weka.filters.unsupervised.attribute.StringToNominal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static bayes.util.BifMapper.fromWekaBif;
import static bayes.util.PrintingPress.sortArrf;
import static bayes.util.SelectPopulation.testSubPopulation;
import static weka.WekaUtil.*;

public class TrainModel {
    private String arff;
    private List<String> attributesOfInterest;
    private String target;
    private List<String> toBeKept;
    private WekaClassifier classifier;
    private boolean applyFeatureSelection;

    public TrainModel(String arff, String target, List<String> attributesOfInterest, List<String> toBeKept, WekaClassifier classifier, boolean applyFeatureSelection) {
        this.arff = arff;
        this.attributesOfInterest = attributesOfInterest;
        this.target = target;
        this.toBeKept = toBeKept;
        this.classifier = classifier;
        this.applyFeatureSelection = applyFeatureSelection;
    }

    public CombinedResult trainModel(List<String> toBeKept)
            throws Exception {
        Instances data = getInstances(arff, target);
        if(classifier instanceof LogRegClassifier || classifier instanceof LinRegClassifier){

            for(int i = 0; i < data.numAttributes(); i++){
                double missing = 0;
                for(int j = 0; j < data.numInstances(); j++){
                    if(data.get(j).isMissing(i)){
                        missing++;
                    }
                }
                if(missing / data.numInstances() > 0.1){
                    //remove records with more than 10% missing values
                    toBeKept.remove(data.attribute(i).name());
                }
            }


            ReplaceMissingValues filter = new ReplaceMissingValues();
            filter.setInputFormat(data);
            data = Filter.useFilter(data, filter);
        }

        classifier.setFiltered(createFilteredClassifier(classifier.getClassifier(), data, toBeKept));
        for (int i = 0; i < data.numAttributes(); i++) {
            if (data.attribute(i).name().equals(target)) {
                data.setClassIndex(i);
                break;
            }
        }
        try {
            classifier.getFiltered().buildClassifier(data);
        } catch (Exception e) {
            throw e;
        }

        CombinedResult res = validate(attributesOfInterest, classifier.getFiltered(), data);
        return res;
    }

    public List<List<String>> makeCombinations() {

        List<List<String>> lists = new ArrayList<>();
        List<String> attributes = new ArrayList<>();
        attributes.addAll(toBeKept);
        attributes.removeAll(attributesOfInterest);
        if(applyFeatureSelection) {
            for (int i = 0; i < attributes.size(); i++) {
                for (List<String> temp : lists) {
                    temp.add(attributes.get(i));
                }
                List<String> list = new ArrayList<>();
                list.add(attributes.get(i));
                list.addAll(attributesOfInterest);
                lists.add(list);
            }
            lists.add(attributesOfInterest);
        }else{
            List<String> list = new ArrayList<>();
            list.addAll(toBeKept);
            lists.add(list);
        }
        return lists;

    }

    private Instances getInstances(String arff, String target) throws Exception {
        Instances data = readData(target, arff);
        StringToNominal filter = new StringToNominal();

        // Apply to all string attributes (e.g., 1-last)
        filter.setAttributeRange("first-last");
        filter.setInputFormat(data);

        // Apply filter
        data = Filter.useFilter(data, filter);

        ArffSaver s = new ArffSaver();

        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/results/temp.arff"));
        writer.write(data.toString());
        writer.flush();
        writer.close();

        sortArrf("resources/results/temp.arff");
        data = readData(target, "resources/results/temp.arff");
        return data;
    }

    private CombinedResult validate(List<String> attributesOfInterest, FilteredClassifier filtered, Instances data)
            throws Exception {

        CombinedResult res = new CombinedResult();

        for (String att : attributesOfInterest) {
            try {
                data.setClassIndex(data.attribute(att).index());
            } catch (Exception e) {
                System.out.println(att);
                throw e;
            }
            Evaluation eval = crossValidate(data, filtered);
            CleanResult r = new CleanResult();
            r.setAuc(eval.weightedAreaUnderROC());
            r.setConfusionMatrix(eval.toMatrixString());
            r.setDetails(eval.toClassDetailsString());
            res.getResults().put(att, r);


        }

        return res;
    }

    public WekaClassifier getClassifier() {
        return classifier;
    }
}
