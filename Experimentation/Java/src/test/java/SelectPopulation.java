import bayes.results.CleanResult;
import bayes.results.CombinedResult;
import org.junit.jupiter.api.Test;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static bayes.util.PrintingPress.printBIF;
import static bayes.weka.WekaUtil.readData;

public class SelectPopulation {

    @Test
    public void trainmodelTest() throws Exception {
        Instances data = readData("social_loneliness", "resources/results/temp.arff");

        Instances filtered = new Instances(data, 0);

        for (int i = 0; i < data.numInstances(); i++) {
            Instance inst = data.instance(i);
            String acquaintances = data.attribute(data.attribute("acquaintances").index()).
                    value((int) inst.value(data.attribute("acquaintances").index()));
            String networksize = data.attribute(data.attribute("network_size_care").index()).
                    value((int) inst.value(data.attribute("network_size_care").index()));
            String friends = data.attribute(data.attribute("friends").index()).
                    value((int) inst.value(data.attribute("friends").index()));
            String emotional_support_decisions_incl_care = data.attribute(data.attribute("emotional_support_decisions_incl_care").index()).
                    value((int) inst.value(data.attribute("emotional_support_decisions_incl_care").index()));

            if (acquaintances.equals("0") && networksize.equals("1-2") && friends.equals("0") && emotional_support_decisions_incl_care.equals("0")) {
                filtered.add(inst);
            }
        }


        System.out.println(filtered.size());
    }


}
