import java.text.DecimalFormat;

public class Carbon14Dating {
    private double remainingAmount;
    private double age;

    public static final double HALF_LIFE = 5730;

    public Carbon14Dating(double remainingAmount) {
        setRemainingAmount(remainingAmount);
        this.age = calculateAge();
    }


    /**
     * This setter only allows numbers => 1. If it is not >=1 the setter defaults the value to 1.
     * @param remainingAmount the amount of c14 in the sample as a percentage (whole number)
     */
    public void setRemainingAmount(double remainingAmount) {
        if (remainingAmount >= 1){
            this.remainingAmount = remainingAmount;
        }else{
            this.remainingAmount = 1;
        }
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    /**
     * @author Luke Matheis
     * @return the age of the sample in years
     */
    public double calculateAge() {
        // Transforms whole % into decimal
        double fractionRemaining = remainingAmount / 100.0;

        // Calculate the number of half-lives
        double halfLives = Math.log(fractionRemaining) / Math.log(0.5);

        // using the amount of half lives and the time it takes for carbon 14 to have a half live
        double age = halfLives * HALF_LIFE;

        return age;
    }

    /**
     * This method makes the Carbon14Date Class be able to be printed out correctly.
     * @return the number of years in a user-friendly format.
     */
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return "The age of the sample is: " + decimalFormat.format(age) + " years";
    }
}
