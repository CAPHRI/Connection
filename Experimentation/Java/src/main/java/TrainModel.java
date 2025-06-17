import bayes.Node;
import bayes.results.BestWorstResult;
import bayes.results.CleanResult;
import bayes.results.CombinedResult;
import bayes.util.BifMapper;
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
import static bayes.weka.WekaUtil.createFilter;
import static bayes.weka.WekaUtil.readData;

public class TrainModel {

    public static CombinedResult trainModel(String arff, String target, List<String> attributesOfInterest,
                                            List<Node> nodes, List<String> toBeKept,
                                            boolean initNaive, int parents)
            throws Exception {
        Instances data = getInstances(arff, target);


        BayesNet network = createBayesNet(initNaive, parents, nodes);

        FilteredClassifier fNet = new FilteredClassifier();
        if (toBeKept != null) {
            Remove filter = (Remove) createFilter(data, toBeKept);
            fNet.setFilter(filter);
            Instances filteredData = Filter.useFilter(data, filter);
            ArffSaver s = new ArffSaver();
            s.setInstances(filteredData);
            s.setFile(new File("resources/results/data.arff"));
            s.writeBatch();
        }
        fNet.setClassifier(network);
        try {
            fNet.buildClassifier(data);
        } catch (Exception e) {
            throw e;
        }


        return validate(attributesOfInterest, fNet, data);
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
//        s.setInstances(data);
//        s.setFile(new File("resources/results/temp.arff"));
//        s.writeBatch();

        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/results/temp.arff"));
        writer.write(data.toString());
        writer.flush();
        writer.close();

        sortArrf("resources/results/temp.arff");
        data = readData(target, "resources/results/temp.arff");
        return data;
    }

    private static CombinedResult validate(List<String> attributesOfInterest, FilteredClassifier fNet, Instances data)
            throws Exception {

        CombinedResult res = new CombinedResult();

        for (String att : attributesOfInterest) {
            try {
                data.setClassIndex(data.attribute(att).index());
            } catch (Exception e) {
                System.out.println(att);
                throw e;
            }
            Evaluation eval = new Evaluation(data);
            fNet.buildClassifier(data);
            eval.crossValidateModel(fNet, data, 10, new Random(1));
            CleanResult r = new CleanResult();
            r.setAuc(eval.weightedAreaUnderROC());
            r.setConfusionMatrix(eval.toMatrixString());
            r.setDetails(eval.toClassDetailsString());

            testSubPopulation(data, fNet);

            res.getResults().put(att, r);


        }
        res.setGraph(fNet.graph());
        res.setDiggity(fromWekaBif(fNet.graph()));

        return res;
    }


    private static BayesNet createBayesNet(boolean initNaive, int parents, List<Node> nodes) {
        BayesNet network = null;

        if (nodes == null) {
            network = new BayesNet();
            K2 k2 = new K2();
            k2.setInitAsNaiveBayes(initNaive);
            k2.setMaxNrOfParents(parents);

            network.setSearchAlgorithm(k2);
        } else {
            String temp = "temp.xml";
            printBIF(BifMapper.toBIF(nodes), temp);
            network = new BayesNet();
            FromFile search = new FromFile();
            search.setBIFFile(temp);
            network.setSearchAlgorithm(search);

        }
        return network;
    }


}
