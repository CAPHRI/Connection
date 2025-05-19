import bayes.results.CombinedResult;
import org.junit.jupiter.api.Test;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bayes.util.PrintingPress.*;
import static util.FilterAttributes.generateFirstModel;
import static util.FilterAttributes.generateSmallSet;

class TrainModelTest {

    @Test
    public void trainmodelTest() throws Exception {
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("network_size_care");

        CombinedResult res =
                TrainModel.trainModel("resources/Data/BL1_FU1_cleaned.csv", "network_size_care", attributesOfInterest,
                        null, null, true, 5);

        printBIF(res.printGraph(), "resources/results/test.pgmx");

        System.out.println(res);
    }

    @Test
    public void trainSmallModelTest() throws Exception {
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("network_size_care");
        attributesOfInterest.add("emotional_support_decisions_incl_care");
        attributesOfInterest.add("emotional_support_talk_about_my_health_incl_care");
        attributesOfInterest.add("no_support_incl_care");
        attributesOfInterest.add("practical_support_incl_care");
        attributesOfInterest.add("support_do_fun_things_incl_care");
        attributesOfInterest.add("support_receive_care_incl_care");

        CombinedResult res =
                TrainModel.trainModel("resources/Data/Prime_2_test.arff", "network_size_care", attributesOfInterest,
                        null, generateSmallSet(), true, 5);

        printBIF(res.printGraph(), "resources/results/small_test.pgmx");
        prettyPrintResultCSV(res.toCSV(), "resources/results/small_test_pretty.csv");
        System.out.println(res);
    }

    @Test
    public void trainBigModelTest() throws Exception {
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("network_size_care");
        attributesOfInterest.add("emotional_support_decisions_incl_care");
        attributesOfInterest.add("emotional_support_talk_about_my_health_incl_care");
        attributesOfInterest.add("no_support_incl_care");
        attributesOfInterest.add("practical_support_incl_care");
        attributesOfInterest.add("support_do_fun_things_incl_care");
        attributesOfInterest.add("support_receive_care_incl_care");

        CombinedResult res =
                TrainModel.trainModel("resources/Data/Prime_2_test.arff", "network_size_care", attributesOfInterest,
                        null, null, true, 5);

        printBIF(res.printGraph(), "resources/results/big_test.pgmx");
        System.out.println(res);
    }

    @Test
    public void trainFirstModelTest() throws Exception {
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("network_size_care");
        attributesOfInterest.add("nearness_less_than_15_min");
        attributesOfInterest.add("acquaintances");
        attributesOfInterest.add("caregivers");
        attributesOfInterest.add("diversity_type_N");
        attributesOfInterest.add("emotional_support_decisions_incl_care");
        attributesOfInterest.add("emotional_support_talk_about_my_health_incl_care");
        attributesOfInterest.add("good_plus_relationship_total_incl_care");
        attributesOfInterest.add("informational_support_incl_care");
        attributesOfInterest.add("physical_contact");
        attributesOfInterest.add("support_do_fun_things_incl_care");
        attributesOfInterest.add("support_give_care_incl_care");
        attributesOfInterest.add("support_receive_care_incl_care");
        attributesOfInterest.add("social_loneliness");
        attributesOfInterest.add("emotional_loneliness");
        attributesOfInterest.add("lonelinessBinary");
        attributesOfInterest.add("friends");
        CombinedResult res =
                TrainModel.trainModel("resources/Data/BL1_FU1_cleaned.csv", "network_size_care", attributesOfInterest,
                        null, generateFirstModel(), false, 5);

        printBIF(res.printGraph(), "resources/results/first_test.pgmx");
        printDiggity(res.getDiggity(), "resources/results/first_test_diggity.txt");
        System.out.println(res);
    }

    @Test
    public void playgroundTest() throws Exception {
        List<String> attributesOfInterest = new ArrayList<>();
        attributesOfInterest.add("lonelinessBinary");

        List<List<String>> lists = makeLists(generateFirstModel(), "lonelinessBinary");

        double best = 0;
        CombinedResult bestRes = null;
        double worst = 1.1;
        CombinedResult worstRes = null;
        for(List<String> list: lists) {
            CombinedResult res =
                    TrainModel.trainModel("resources/Data/BL1_FU1_cleaned.csv", "lonelinessBinary", attributesOfInterest,
                            null, list, false, 5);
            System.out.println("List size " + list.size() + " Score: " +res.getResults().get("lonelinessBinary").getAuc());
            if(res.getResults().get("lonelinessBinary").getAuc() > best){
                System.out.println("Previous best: " + best + " new best: " +res.getResults().get("lonelinessBinary").getAuc());
                bestRes = res;
                best = res.getResults().get("lonelinessBinary").getAuc();
            } if(res.getResults().get("lonelinessBinary").getAuc() < worst){
                System.out.println("Previous worst: " + worst + " new worst: " +res.getResults().get("lonelinessBinary").getAuc());
                worstRes = res;
                worst = res.getResults().get("lonelinessBinary").getAuc();
            }
        }

        printBIF(bestRes.printGraph(), "resources/results/playgroundBest.pgmx");
        printDiggity(bestRes.getDiggity(), "resources/results/playgroundBest.txt");
        System.out.println("Best");
        System.out.println(bestRes);
        printBIF(worstRes.printGraph(), "resources/results/playgroundWorst.pgmx");
        printDiggity(worstRes.getDiggity(), "resources/results/playgroundWorst.txt");
        System.out.println("Worst");
        System.out.println(worstRes);
    }

    public  List<List<String>> makeLists(List<String> attributes, String target) {
        List<List<String>> lists = new ArrayList<>();
        attributes.remove(target);
        for (int i = 0; i < attributes.size(); i++) {
            for (List<String> temp : lists) {
                temp.add(attributes.get(i));
            }
            List<String> list = new ArrayList<>();
            list.add(target);
            list.add(attributes.get(i));
            lists.add(list);
        }

        return lists;
    }

}