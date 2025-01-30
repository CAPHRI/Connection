package bayes.weka;

import bayes.Node;
import bayes.results.PredictedDistribution;
import bayes.results.Prediction;
import bayes.util.BifMapper;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.net.search.fixed.FromFile;
import weka.classifiers.bayes.net.search.local.K2;
import weka.classifiers.misc.InputMappedClassifier;
import weka.core.Instances;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static bayes.util.PrintingPress.printBIF;

public class WekaClassifier {
    private static final int TEN = 10;

    public static BayesNet trainWekaK2(Instances data, boolean initNaive, int parents)
            throws Exception {
        BayesNet network = new BayesNet();
        K2 k2 = new K2();
        k2.setInitAsNaiveBayes(initNaive);
        k2.setMaxNrOfParents(parents);

        network.setSearchAlgorithm(k2);
        network.buildClassifier(data);
        return network;
    }

    public static BayesNet trainWekaPredefinedStructure(Instances data, List<Node> nodes)
            throws Exception {
        String temp = "temp.xml";
        printBIF(BifMapper.toBIF(nodes), temp);

        BayesNet network = trainWekaDAG(data, temp);

        return network;
    }

    public static void cleanUpTemp() {
        String temp = "temp.xml";
        File f = new File(temp);
        f.delete();
    }

    private static BayesNet trainWekaDAG(Instances data, String dag) throws Exception {
        BayesNet network = new BayesNet();

        FromFile search = new FromFile();
        search.setBIFFile(dag);

        network.setSearchAlgorithm(search);
        network.buildClassifier(data);

        return network;
    }

    public static Evaluation crossValidate(Instances data, BayesNet network) throws Exception {
        Evaluation eval = new Evaluation(data);
        network.buildClassifier(data);
        eval.crossValidateModel(network, data, TEN, new Random(1));
        eval.predictions();

        return eval;
    }

    public static Evaluation validate(Instances data, BayesNet network, Instances original) throws Exception {
        Evaluation eval = new Evaluation(data);
        InputMappedClassifier input = new InputMappedClassifier();
        input.setModelHeader(original);
        input.setClassifier(network);
        eval.evaluateModel(input, data);

        return eval;
    }

    public static List<PredictedDistribution> createPredictedMapped(Instances data, BayesNet network,
                                                                    Instances original) throws Exception {
        InputMappedClassifier input = new InputMappedClassifier();
        input.setModelHeader(original);
        input.setClassifier(network);
        input.setIgnoreCaseForNames(true);

        Evaluation eval = new Evaluation(data);
        eval.evaluateModel(input, data);
        return createPredicted(eval, data);
    }

    public static List<PredictedDistribution> createPredictedStage2(Evaluation eval, Instances training,
                                                                    double stage)
            throws Exception {

        List<Prediction> predictions = new ArrayList<>();
        for (int i = 0; i < training.numInstances(); i++) {
            if (training.get(i).value(training.attribute("stage")) != stage) {
                //wrong stage continue
                continue;
            }
            for (int j = 0; j < training.numAttributes(); j++) {
                String attName = training.attribute(j).name();
                training.get(i).setValue(j, training.get(i).value(training.attribute(attName)));
            }

            ;
            //get the value in eval.predictions.get(i).toString.split. This corresponds to the probability for the true class


            double prob = Double.valueOf(eval.predictions().get(i).toString().split(" ")[4]);
            String label = training.classAttribute().value((int) training.get(i).value(training.attribute("lc")));

            predictions.add(new Prediction(prob, label));


        }

        List<PredictedDistribution> dist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dist.add(new PredictedDistribution(1 - 0.1 * i));
        }
        for (Prediction p : predictions) {
            PredictedDistribution d = findBin(dist, p.getProb());
            d.setCount(d.getCount() + 1);
            d.setCountTrueLabel(d.getCountTrueLabel() + (p.getLabel().equals("true") ? 1 : 0));
        }
        return dist;
    }

    public static List<PredictedDistribution> createPredictedStage(BayesNet network, Instances training,
                                                                   Instances unfiltered, double stage)
            throws Exception {

        List<Prediction> predictions = new ArrayList<>();
        for (int i = 0; i < unfiltered.numInstances(); i++) {
            if (unfiltered.get(i).value(unfiltered.attribute("stage")) != stage) {
                //wrong stage continue
                continue;
            }
            for (int j = 0; j < training.numAttributes(); j++) {
                String attName = training.attribute(j).name();
                training.get(i).setValue(j, unfiltered.get(i).value(unfiltered.attribute(attName)));
            }

            double prob = network.distributionForInstance(training.get(i))[1];
            String label = training.classAttribute().value((int) training.get(i).value(training.attribute("lc")));

            predictions.add(new Prediction(prob, label));
        }

        List<PredictedDistribution> dist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dist.add(new PredictedDistribution(1 - 0.1 * i));
        }
        for (Prediction p : predictions) {
            PredictedDistribution d = findBin(dist, p.getProb());
            d.setCount(d.getCount() + 1);
            d.setCountTrueLabel(d.getCountTrueLabel() + (p.getLabel().equals("true") ? 1 : 0));
        }
        return dist;
    }

    public static List<PredictedDistribution> createPredicted(Evaluation eval, Instances data) throws Exception {

        List<Prediction> predictions = createPredictions(eval, data);

        List<PredictedDistribution> dist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dist.add(new PredictedDistribution(1 - 0.1 * i));
        }
        for (Prediction p : predictions) {
            PredictedDistribution d = findBin(dist, p.getProb());
            d.setCount(d.getCount() + 1);
            d.setCountTrueLabel(d.getCountTrueLabel() + (p.getLabel().equals("true") ? 1 : 0));
        }
        return dist;
    }

    public static List<Prediction> createPredictions(Evaluation eval, Instances data) throws Exception {

        List<Prediction> predictions = new ArrayList<>();
        for (int i = 0; i < eval.numInstances(); i++) {
            //get the value in eval.predictions.get(i).toString.split. This corresponds to the probability for the true class
            double prob = Double.valueOf(eval.predictions().get(i).toString().split(" ")[
                    eval.predictions().get(i).toString().split(" ").length - 1]);
            String label = data.classAttribute().value((int) eval.predictions().get(i).actual());

            predictions.add(new Prediction(prob, label));
        }
        return predictions;
    }

    private static PredictedDistribution findBin(List<PredictedDistribution> dist, double prob) {
        PredictedDistribution c = null;
        for (PredictedDistribution d : dist) {
            if (c == null) {
                c = d;
            } else if (d.getProb() < c.getProb() && prob <= d.getProb()) {
                c = d;
            }
        }
        return c;
    }


}
