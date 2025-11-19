import bayes.results.CleanResult;
import bayes.results.CombinedResult;
import org.junit.jupiter.api.Test;
import weka.classifiers.BNClassifier;
import weka.classifiers.LinRegClassifier;
import weka.classifiers.LogRegClassifier;

import java.util.*;

import static bayes.util.BifMapper.fromWekaBif;
import static bayes.util.PrintingPress.*;
import static util.FilterAttributes.*;

class TrainModelTest {

    @Test
    public void trainBNManuscriptTest() throws Exception {
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("GEZONDHEID_NU_CBS");

        Map<String, List<String>> selectedNodes = new HashMap<>();
        selectedNodes.put("Baseline", generateManuscriptModelBaseline());
//        List<String> withDensity = generateManuscriptModelBaseline();
//        withDensity.add("density");
//        selectedNodes.put("BaselineWithDensity", withDensity);
//        selectedNodes.put("BeperktNetwerk", generateManuscriptModelBeperktNetwerk());
//        selectedNodes.put("GeenAandoeningen", generateManuscriptModelGeenAandoeningen());
//        selectedNodes.put("NoCaregivers", generateManuscriptModelNoCaregivers());
//        selectedNodes.put("NoDemographics", generateManuscriptModelNoDemographics());
//        selectedNodes.put("NoLBM", generateManuscriptModelNoLBM());
//        List<String> noDemoNoLBM = generateManuscriptModelNoDemographics();
//        noDemoNoLBM.remove("lbm");
//        selectedNodes.put("NoDemoNoLBM", noDemoNoLBM);

        boolean applyfeatureselection = false;
        for (String k : selectedNodes.keySet()) {
            BNClassifier classifier = new BNClassifier(false, 5, null);
            TrainModel trainer = new TrainModel("resources/Data/BL1_FU1_cleaned.csv", "GEZONDHEID_NU_CBS", attributesOfInterest,
                    selectedNodes.get(k), classifier, applyfeatureselection);
            Map<Double, CombinedResult> res = trainBNModelWithFeatureSelection(trainer);

            List<Double> keys = new ArrayList<Double>(res.keySet());
            Collections.sort(keys);

            for (int i = 0; i < keys.size(); i++) {
                String path = "resources/modellingResults/Manuscript/BN/";
                if (applyfeatureselection) {
                    path += "featureselection/";
                }
                path += k + "/";

                System.out.println(keys.get(i));
                printString(res.get(keys.get(i)).getModel()+ "\n\n" + res.get(keys.get(i)), path + "bestModel" + ((keys.size() - i)) + "_score_" + res.get(keys.get(i)).getAverageAUC() + ".txt");
                printString(res.get(keys.get(i)).printGraph(), path + "bestFeature" + ((keys.size() - i)) + "_score_" + res.get(keys.get(i)).getAverageAUC() + ".pgmx");
                printString(res.get(keys.get(i)).getDiggity(), path + "bestDiggity" + ((keys.size() - i)) + "_score_" + res.get(keys.get(i)).getAverageAUC() + ".txt");
                System.out.println(k + "\n");
                System.out.println(res.get(keys.get(i)));
            }
        }
    }

    @Test
    public void trainTranslatedModel() throws Exception {
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("GEZONDHEID_NU_CBS");

        Map<String, List<String>> selectedNodes = new HashMap<>();
        selectedNodes.put("Baseline", generateManuscriptModelBaselineTranslated());selectedNodes.put("NoCaregivers", generateManuscriptModelNoCaregivers());
        selectedNodes.put("NoDemographics", generateManuscriptModelNoDemographicsTranslated());

        boolean applyfeatureselection = false;
        for (String k : selectedNodes.keySet()) {
            BNClassifier classifier = new BNClassifier(false, 5, null);
            TrainModel trainer = new TrainModel("resources/Data/translated.arff", "GEZONDHEID_NU_CBS", attributesOfInterest,
                    selectedNodes.get(k), classifier, applyfeatureselection);
            Map<Double, CombinedResult> res = trainBNModelWithFeatureSelection(trainer);

            List<Double> keys = new ArrayList<Double>(res.keySet());
            Collections.sort(keys);

            for (int i = 0; i < keys.size(); i++) {
                String path = "resources/modellingResults/Manuscript/BN/";
                if (applyfeatureselection) {
                    path += "featureselection/";
                }
                path += k + "/";

                System.out.println(keys.get(i));
                printString(res.get(keys.get(i)).getModel()+ "\n\n" + res.get(keys.get(i)), path + "bestModel" + ((keys.size() - i)) + "_score_" + res.get(keys.get(i)).getAverageAUC() + ".txt");
                printString(res.get(keys.get(i)).printGraph(), path + "bestFeature" + ((keys.size() - i)) + "_score_" + res.get(keys.get(i)).getAverageAUC() + ".pgmx");
                printString(res.get(keys.get(i)).getDiggity(), path + "bestDiggity" + ((keys.size() - i)) + "_score_" + res.get(keys.get(i)).getAverageAUC() + ".txt");
                System.out.println(k + "\n");
                System.out.println(res.get(keys.get(i)));
            }
        }
    }

    private Map<Double, CombinedResult> trainBNModelWithFeatureSelection(TrainModel trainer)
            throws Exception {
        List<List<String>> featureSelection = trainer.makeCombinations();
        Map<Double, CombinedResult> all = new HashMap<>();
        for (List<String> list : featureSelection) {
            CombinedResult res = trainer.trainModel(list);
            double score = 0;
            for (CleanResult x : res.getResults().values()) {
                score += x.getAuc();
            }
            score /= res.getResults().values().size();
            all.put(score, res);

            res.setGraph(trainer.getClassifier().getFiltered().graph());
            res.setDiggity(fromWekaBif(trainer.getClassifier().getFiltered().graph()));
            res.setModel(trainer.getClassifier().getFiltered().toString());
        }
        return all;
    }

    @Test
    public void trainLogRegFeautureSelectionAndWorstTest() throws Exception {
        boolean withoutSize = false;
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("GEZONDHEID_NU_CBS");

        Map<String, List<String>> selectedNodes = new HashMap<>();
        selectedNodes.put("Baseline", generateManuscriptModelBaseline());
        List<String> withDensity = generateManuscriptModelBaseline();
        withDensity.add("density");
        selectedNodes.put("BaselineWithDensity", withDensity);
        selectedNodes.put("BeperktNetwerk", generateManuscriptModelBeperktNetwerk());
        selectedNodes.put("GeenAandoeningen", generateManuscriptModelGeenAandoeningen());
        selectedNodes.put("NoCaregivers", generateManuscriptModelNoCaregivers());
        selectedNodes.put("NoDemographics", generateManuscriptModelNoDemographics());
        selectedNodes.put("NoLBM", generateManuscriptModelNoLBM());
        List<String> noDemoNoLBM = generateManuscriptModelNoDemographics();
        noDemoNoLBM.remove("lbm");
        selectedNodes.put("NoDemoNoLBM", noDemoNoLBM);

        boolean applyfeatureselection = false;
            for (String k : selectedNodes.keySet()) {
                LogRegClassifier classifier = new LogRegClassifier(1000);
                TrainModel trainer = new TrainModel("resources/Data/BL1_FU1_cleaned.csv", "lonelinessBinary", attributesOfInterest,
                        selectedNodes.get(k), classifier, applyfeatureselection);
                Map<Double, CombinedResult> res = trainLogRegModelWithFeatureSelection(trainer);

                List<Double> keys = new ArrayList<Double>(res.keySet());
                Collections.sort(keys);

                for (int i = 0; i < keys.size(); i++) {
                    String path = "resources/modellingResults/Manuscript/LogReg/";

                    path += k + "/";
                    System.out.println(keys.get(i));
                    printString(res.get(keys.get(i)).getModel() + "\n\n" + res.get(keys.get(i)), path +
                             "logreg" + "_score_" + res.get(keys.get(i)).getAverageAUC() + ".txt");
                    System.out.println(k + "\n");
                    System.out.println(res.get(keys.get(i)));
                }

        }
    }

    private Map<Double, CombinedResult> trainLogRegModelWithFeatureSelection(TrainModel trainer)
            throws Exception {
        List<List<String>> featureSelection = trainer.makeCombinations();
        Map<Double, CombinedResult> all = new HashMap<>();
        for (List<String> list : featureSelection) {
            CombinedResult res = trainer.trainModel(list);
            double score = 0;
            for (CleanResult x : res.getResults().values()) {
                score += x.getAuc();
            }
            score /= res.getResults().values().size();
            all.put(score, res);

            res.setModel(trainer.getClassifier().getFiltered().toString());
        }
        return all;
    }
}