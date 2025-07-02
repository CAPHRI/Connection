import bayes.Node;
import bayes.results.CleanResult;
import bayes.results.CombinedResult;
import bayes.util.BifMapper;
import weka.WekaClassifier;
import weka.classifiers.BNClassifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.net.search.fixed.FromFile;
import weka.classifiers.bayes.net.search.local.K2;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static bayes.util.BifMapper.fromWekaBif;
import static bayes.util.PrintingPress.printBIF;
import static bayes.util.PrintingPress.sortArrf;
import static bayes.util.SelectPopulation.testSubPopulation;
import static weka.WekaUtil.*;

public class TrainModel {
    private WekaClassifier classifier;

    public TrainModel(WekaClassifier classifier){
        this.classifier = classifier;
    }

    public static CombinedResult trainModel(String arff, String target, List<String> attributesOfInterest,
                                            List<Node> nodes, List<String> toBeKept,
                                            boolean initNaive, int parents)
            throws Exception {
        Instances data = getInstances(arff, target);

        BNClassifier bn = new BNClassifier(initNaive, parents, nodes);
        bn.setFiltered(createFilteredClassifier(bn.getClassifier(), data, toBeKept));

        try {
            bn.getFiltered().buildClassifier(data);
        } catch (Exception e) {
            throw e;
        }

        CombinedResult res = validate(attributesOfInterest, bn.getFiltered(), data);

        res.setGraph(bn.getFiltered().graph());
        res.setDiggity(fromWekaBif(bn.getFiltered().graph()));
        return res;
    }

    public static Map<Double, CombinedResult> trainModelWithFeatureSelection(String arff, String target, List<String> attributesOfInterest,
                                                                             List<Node> nodes, List<String> toBeKept,
                                                                             boolean initNaive, int parents)
            throws Exception {
        List<List<String>> featureSelection = makeCombinations(toBeKept, attributesOfInterest);
        Map<Double, CombinedResult> all = new HashMap<>();
        for (List<String> list : featureSelection) {
            CombinedResult res = trainModel(arff, target, attributesOfInterest, nodes, list, initNaive, parents);
            double score = 0;
            for (CleanResult x : res.getResults().values()) {
                score += x.getAuc();
            }
            score /= res.getResults().values().size();
            all.put(score, res);
        }
        return all;

    }

    private static List<List<String>> makeCombinations(List<String> attributes, List<String> attributesOfInterest) {

        List<List<String>> lists = new ArrayList<>();
        attributes.removeAll(attributesOfInterest);
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
        return lists;

    }

    private static Instances getInstances(String arff, String target) throws IOException {
        Instances data = readData(target, arff);
        ArffSaver s = new ArffSaver();

        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/results/temp.arff"));
        writer.write(data.toString());
        writer.flush();
        writer.close();

        sortArrf("resources/results/temp.arff");
        data = readData(target, "resources/results/temp.arff");
        return data;
    }

    private static CombinedResult validate(List<String> attributesOfInterest, FilteredClassifier filtered, Instances data)
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

            testSubPopulation(data, filtered);

            res.getResults().put(att, r);


        }

        return res;
    }
}
