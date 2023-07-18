import java.util.Scanner;

class Carbon14DatingUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //How to test your CD values
        //https://www.omnicalculator.com/chemistry/carbon-dating
        //Video intro
        //https://www.youtube.com/watch?v=phZeE7Att_s
        System.out.print("Enter the remaining amount of carbon-14 (enter as a whole number): ");
        double remainingAmount = scanner.nextDouble();

        Carbon14Dating cd = new Carbon14Dating(remainingAmount);

        System.out.println(cd.toString());
    }
}