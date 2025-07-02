package weka.classifiers;


import bayes.Node;
import bayes.util.BifMapper;
import weka.WekaClassifier;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.net.search.fixed.FromFile;
import weka.classifiers.bayes.net.search.local.K2;
import weka.classifiers.meta.FilteredClassifier;

import java.util.List;

import static bayes.util.PrintingPress.printBIF;
import static weka.WekaUtil.createFilteredClassifier;

public class BNClassifier extends WekaClassifier {
    private int parents;
    private boolean initNaive;
    private List<Node> nodes;

    private BayesNet classifier;

    public BNClassifier(boolean initNaive, int parents, List<Node> nodes) {
        this.initNaive = initNaive;
        this.parents = parents;
        this.nodes = nodes;
        createClassifier();
    }

    @Override
    protected void createClassifier() {
        this.classifier = createBayesNet(initNaive, parents, nodes);
    }

    @Override
    public BayesNet getClassifier() {
        return classifier;
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
