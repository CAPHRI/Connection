import org.junit.jupiter.api.Test;

class TrainModelTest {


    @Test
    public void trainmodelTest() throws Exception {
        System.out.println(
                TrainModel.trainModel("resources/Data/Prime_2_test.arff", "network_size_care", null, null, true, 5));
    }

}