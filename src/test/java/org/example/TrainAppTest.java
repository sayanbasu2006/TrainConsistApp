import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainAppTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainApp.GoodsBogie> bogies = List.of(
                new TrainApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainApp.GoodsBogie("Open", "Coal")
        );

        assertTrue(TrainApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainApp.GoodsBogie> bogies = List.of(
                new TrainApp.GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainApp.GoodsBogie> bogies = List.of(
                new TrainApp.GoodsBogie("Open", "Coal"),
                new TrainApp.GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainApp.GoodsBogie> bogies = List.of(
                new TrainApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainApp.GoodsBogie("Cylindrical", "Coal") // ❌ violation
        );

        assertFalse(TrainApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainApp.GoodsBogie> bogies = new ArrayList<>();

        assertTrue(TrainApp.isTrainSafe(bogies));
    }
}