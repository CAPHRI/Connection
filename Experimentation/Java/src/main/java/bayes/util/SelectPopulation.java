package bayes.util;

import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instance;
import weka.core.Instances;

import java.util.Random;

public class SelectPopulation {

    public static Instances selectTestPopulation(Instances data) {
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
        return filtered;
    }

    public static void testSubPopulation(Instances data, FilteredClassifier fNet) throws Exception {
        Evaluation eval = new Evaluation(selectTestPopulation(data));
        eval.crossValidateModel(fNet, data, 10, new Random(1));
        System.out.println("TESTING");
        System.out.println(eval.weightedAreaUnderROC());
    }


}
