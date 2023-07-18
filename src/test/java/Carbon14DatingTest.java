import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Carbon14DatingTest {

    @Test
    public void testCalculateAge() {
        double remainingAmount = 50.0;
        Carbon14Dating carbon14Dating = new Carbon14Dating(remainingAmount);

        double expectedAge = 5730.0; // Expected age for 50% remaining amount
        double actualAge = carbon14Dating.calculateAge();

        Assertions.assertEquals(expectedAge, actualAge, 0.01); // Allow a tolerance of 0.01
    }

    @Test
    @DisplayName("Test Remaining Amount <= 1")
    public void testSetRemainingAmount_LessThanOne() {
        Carbon14Dating carbon14Dating = new Carbon14Dating(0.5);

        double expectedRemainingAmount = 1.0; // Default remaining amount when less than 1
        double actualRemainingAmount = carbon14Dating.getRemainingAmount();

        Assertions.assertEquals(expectedRemainingAmount, actualRemainingAmount);
    }

    @Test
    @DisplayName("Test Remaining Amount >= 1")
    public void testSetRemainingAmount_GreaterThanOrEqualToOne() {
        //test 75.0
        Carbon14Dating cd1 = new Carbon14Dating(75.0);
        Assertions.assertEquals(75.0, cd1.getRemainingAmount(), 0.01);

        //test 1
        Carbon14Dating cd2 = new Carbon14Dating(1);
        Assertions.assertEquals(1, cd2.getRemainingAmount(), 0.01);

    }

    @Test
    public void testToString() {
        double remainingAmount = 25.0;
        Carbon14Dating carbon14Dating = new Carbon14Dating(remainingAmount);

        String expectedString = "The age of the sample is: 11,460 years";
        String actualString = carbon14Dating.toString();

        Assertions.assertEquals(expectedString, actualString);
    }
}
