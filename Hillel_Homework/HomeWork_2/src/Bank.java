import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {

        Scanner var = new Scanner(System.in);
        System.out.print("Enter the amount of cash deposit in (Uah): ");
        float deposit = var.nextFloat();

        System.out.print("Enter the percent (%)  per year: ");
        float percent = var.nextFloat();

        System.out.print("Enter the Duration of contribution (years): ");
        int years = var.nextInt();

        float accum = 0;
        for (int i = 0; i < years; i++) {
            accum = (((deposit - accum) * percent) / 100);
            deposit += accum;
            System.out.println("Per year: " + accum + " Uah" +" (%)" + "  " + "Deposit: " + deposit + " Uah");
        }
        System.out.println("If you count that (%) accrued at the end");
    }
}
