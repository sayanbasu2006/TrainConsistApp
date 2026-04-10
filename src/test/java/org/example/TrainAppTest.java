import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainAppTest {

    // ✅ Valid Train ID
    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainApp.isValidTrainId("TRN-1234"));
    }

    // ❌ Invalid Train ID formats
    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainApp.isValidTrainId("TRAIN12"));
        assertFalse(TrainApp.isValidTrainId("TRN12A"));
        assertFalse(TrainApp.isValidTrainId("1234-TRN"));
    }

    // ❌ Wrong digit length
    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainApp.isValidTrainId("TRN-123"));
        assertFalse(TrainApp.isValidTrainId("TRN-12345"));
    }

    // ✅ Valid Cargo Code
    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainApp.isValidCargoCode("PET-AB"));
    }

    // ❌ Invalid Cargo Code formats
    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainApp.isValidCargoCode("PET-ab"));
        assertFalse(TrainApp.isValidCargoCode("PET123"));
        assertFalse(TrainApp.isValidCargoCode("AB-PET"));
    }

    // ❌ Lowercase should fail
    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainApp.isValidCargoCode("PET-Ab"));
        assertFalse(TrainApp.isValidCargoCode("PET-aB"));
    }

    // ❌ Empty input
    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainApp.isValidTrainId(""));
        assertFalse(TrainApp.isValidCargoCode(""));
    }

    // ❌ Null input
    @Test
    void testRegex_NullInputHandling() {
        assertFalse(TrainApp.isValidTrainId(null));
        assertFalse(TrainApp.isValidCargoCode(null));
    }

    // ❌ Exact match only (no extra characters)
    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainApp.isValidTrainId("TRN-1234-EXTRA"));
        assertFalse(TrainApp.isValidCargoCode("PET-AB123"));
    }
}