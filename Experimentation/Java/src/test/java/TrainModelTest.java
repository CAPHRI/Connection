import bayes.results.CombinedResult;
import org.junit.jupiter.api.Test;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;

import static bayes.util.PrintingPress.prettyPrintResultCSV;
import static bayes.util.PrintingPress.printBIF;
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
}