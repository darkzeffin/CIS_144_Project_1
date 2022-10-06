import java.text.DecimalFormat;
import java.util.Scanner;

public class payCalculator {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main (String[] args) {

        //Declare variables
        double grossBiweekly;
        double grossMonthly;
        double grossYearly;
        final double PAYRATE = 20.50;
        final double TAXRATE = .30;
        double netBiweekly;
        double netMonthly;
        double netYearly;
        String firstName;
        String lastName;

        // Gather name
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        firstName = scan.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = scan.nextLine();

        // Gather social & validate it is 9 digits with a boolean, do-while statement, and a nested if statement
        Scanner scanSocial = new Scanner(System.in);
        System.out.println("Please enter your social security number: ");
        boolean validSocial;
        long social;
        do {
            social = scanSocial.nextLong();
           int length = String.valueOf(social).length();
            validSocial = length == 9;      //set expected length

            if (!validSocial) {
                System.out.println("That is not a valid social security number. Please reenter.");
            }
        } while (!validSocial);
        System.out.println("Thank you for your social security number.");

        //Gather hours worked
        Scanner scanHrs = new Scanner(System.in);
        System.out.println("Please enter hours worked for the week: ");
        double hrsWorked = scanHrs.nextDouble();

        //Calculate gross and net pay
        grossBiweekly = hrsWorked * 2 * PAYRATE;
        grossMonthly = 2 * grossBiweekly;
        grossYearly = 12 * grossMonthly;
        netBiweekly = grossBiweekly - (grossBiweekly * TAXRATE);
        netMonthly = grossMonthly - (grossMonthly * TAXRATE);
        netYearly = grossYearly - (grossYearly * TAXRATE);


        // print statements & rounded numbers
        System.out.println(lastName + ", " + firstName);
        System.out.println("-----------------------");
        System.out.println("Gross Biweekly Pay: " + df.format(grossBiweekly));
        System.out.println("Gross Monthly Pay: " + df.format(grossMonthly));
        System.out.println("Gross Yearly Pay: " + df.format(grossYearly));
        System.out.println("-----------------------");
        System.out.println("Net Biweekly Pay: " + df.format(netBiweekly));
        System.out.println("Net Monthly Pay: " + df.format(netMonthly));
        System.out.println("Net Yearly Pay: " + df.format(netYearly));
        System.out.println("DONE");
    }
}