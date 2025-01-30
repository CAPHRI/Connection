import bayes.Node;
import bayes.results.CleanResult;
import bayes.util.BifMapper;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.net.search.fixed.FromFile;
import weka.classifiers.bayes.net.search.local.K2;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Remove;

import java.util.List;
import java.util.Random;

import static bayes.util.PrintingPress.printBIF;
import static bayes.weka.WekaUtil.createFilter;
import static bayes.weka.WekaUtil.readData;

public class TrainModel {

    public static CleanResult trainModel(String arff, String target, List<Node> nodes, List<String> toBeKept,
                                         boolean initNaive, int parents)
            throws Exception {
        Instances data = readData(target, arff);


        BayesNet network = createBayesNet(initNaive, parents, nodes);

        FilteredClassifier fNet = new FilteredClassifier();
        if (toBeKept != null) {
            Remove filter = (Remove) createFilter(data, toBeKept);
            fNet.setFilter(filter);
        }

        fNet.setClassifier(network);

        fNet.buildClassifier(data);

        CleanResult res = new CleanResult();
        Evaluation eval = new Evaluation(data);

        eval.crossValidateModel(fNet, data, 10, new Random(1));
        res.setConfusionMatrix(eval.toMatrixString());
        res.setGraph(fNet.graph());
        res.setDetails(eval.toClassDetailsString());
        res.setAuc(eval.weightedAreaUnderROC());

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
