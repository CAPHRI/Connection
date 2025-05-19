package bayes.util;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static bayes.util.PrintingPress.sortArrf;
import static org.junit.jupiter.api.Assertions.*;

class PrintingPressTest {
    @Test
    public void testSortArff() throws FileNotFoundException {
        sortArrf("resources/results/data.arff");
    }
}