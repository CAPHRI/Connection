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
    public void trainBNFeautureSelectionAndWorstTest() throws Exception {
        boolean withoutSize = true;
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("acquaintances");
        attributesOfInterest.add("caregivers");
        attributesOfInterest.add("emotional_support_decisions_incl_care");
        attributesOfInterest.add("emotional_support_talk_about_my_health_incl_care");
        attributesOfInterest.add("good_plus_relationship_total_incl_care");
        attributesOfInterest.add("informational_support_incl_care");
        attributesOfInterest.add("physical_contact");
        attributesOfInterest.add("support_do_fun_things_incl_care");
        attributesOfInterest.add("social_loneliness");
        attributesOfInterest.add("emotional_loneliness");
        attributesOfInterest.add("lonelinessBinary");

        List<String> selectedNodes =  generateSunbeltModel();
        if(withoutSize) {
            selectedNodes.remove("network_size_care");
        }

        BNClassifier classifier = new BNClassifier(false, 5, null);
        TrainModel trainer = new TrainModel("resources/Data/BL1_FU1_cleaned.csv", "lonelinessBinary", attributesOfInterest,
                generateSunbeltModel(), classifier);
        Map<Double, CombinedResult> res = trainBNModelWithFeatureSelection(trainer);

        List<Double> keys = new ArrayList<Double>(res.keySet());
        Collections.sort(keys);

        for(int i =0; i < keys.size(); i++) {
            String path = "resources/results/Sunbelt/";
            if(withoutSize){
                path+="/noSize/";
            }
            System.out.println(keys.get(i));
            printString(res.get(keys.get(i)).printGraph(), path+"bestFeature" + ((keys.size()-i)) + "_score_"+ res.get(keys.get(i)).getAverageAUC()+ ".pgmx");
            printString(res.get(keys.get(i)).getDiggity(), path+"bestDiggity" + ((keys.size()-i)) + "_score_"+ res.get(keys.get(i)).getAverageAUC()+".txt");
            System.out.println("Best \n");
            System.out.println(res.get(keys.get(i)));
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
        }
        return all;
    }

    @Test
    public void trainLogRegFeautureSelectionAndWorstTest() throws Exception {
        boolean withoutSize = true;
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("lonelinessBinary");

        List<String> selectedNodes =  generateSunbeltModel();
        if(withoutSize) {
            selectedNodes.remove("network_size_care");
        }

        LogRegClassifier classifier = new LogRegClassifier();
        TrainModel trainer = new TrainModel("resources/Data/BL1_FU1_cleaned.csv", "lonelinessBinary", attributesOfInterest,
                generateSunbeltModel(), classifier);
        Map<Double, CombinedResult> res = trainLogRegModelWithFeatureSelection(trainer);

        List<Double> keys = new ArrayList<Double>(res.keySet());
        Collections.sort(keys);

        for(int i =0; i < keys.size(); i++) {
            String path = "resources/results/Sunbelt/";
            if(withoutSize){
                path+="/noSize/";
            }
            System.out.println(keys.get(i));
            printString(res.get(keys.get(i)).getModel(), path+"bestModel" + ((keys.size()-i)) + "_score_"+ res.get(keys.get(i)).getAverageAUC()+".txt");
            System.out.println("Best \n");
            System.out.println(res.get(keys.get(i)));
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

    @Test
    public void trainLinRegFeautureSelectionAndWorstTest() throws Exception {
        boolean withoutSize = true;
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("lonelinessBinary");

        List<String> selectedNodes =  generateSunbeltModel();
        if(withoutSize) {
            selectedNodes.remove("network_size_care");
        }

        LinRegClassifier classifier = new LinRegClassifier();
        TrainModel trainer = new TrainModel("resources/Data/BL1_FU1_cleaned.csv", "lonelinessBinary", attributesOfInterest,
                generateSunbeltModel(), classifier);
        Map<Double, CombinedResult> res = trainLogRegModelWithFeatureSelection(trainer);

        List<Double> keys = new ArrayList<Double>(res.keySet());
        Collections.sort(keys);

        for(int i =0; i < keys.size(); i++) {
            String path = "resources/results/Sunbelt/";
            if(withoutSize){
                path+="/noSize/";
            }
            System.out.println(keys.get(i));
            printString(res.get(keys.get(i)).getModel(), path+"bestModel" + ((keys.size()-i)) + "_score_"+ res.get(keys.get(i)).getAverageAUC()+".txt");
            System.out.println("Best \n");
            System.out.println(res.get(keys.get(i)));
        }
    }

    private Map<Double, CombinedResult> trainLinRegModelWithFeatureSelection(TrainModel trainer)
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