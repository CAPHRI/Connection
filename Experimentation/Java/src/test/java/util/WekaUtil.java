package util;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.MultiFilter;
import weka.filters.unsupervised.attribute.*;

import java.util.Arrays;
import java.util.List;

public class WekaUtil {

    public static Instances convertToNominal(Instances data, List<String> toBeConverted) throws Exception {
        NumericToNominal converter = new NumericToNominal();
        int[] indices = new int[toBeConverted.size()];
        for (int i = 0; i < toBeConverted.size(); i++) {
            indices[i] = data.attribute(toBeConverted.get(i)).index();
        }
        converter.setAttributeIndicesArray(indices);
        converter.setInputFormat(data);

        return Filter.useFilter(data, converter);
    }

    public static Instances discretizeAutomatic(Instances data, List<String> toBeDiscretized) throws Exception {
        Discretize disc = new Discretize();

        int[] indices = new int[toBeDiscretized.size()];
        for (int i = 0; i < toBeDiscretized.size(); i++) {
            indices[i] = data.attribute(toBeDiscretized.get(i)).index();
        }
        disc.setAttributeIndicesArray(indices);
        disc.setInputFormat(data);
        disc.setFindNumBins(true);

        return Filter.useFilter(data, disc);
    }
}

