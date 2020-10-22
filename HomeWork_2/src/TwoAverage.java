import java.util.Scanner;

public class TwoAverage {
    public static void main(String[] args) {

        Scanner var = new Scanner(System.in);
        System.out.print("Input first number: ");
        float first = var.nextFloat();
        System.out.print("Input second number: ");
        float second = var.nextFloat();

        float result = (first + second) / 2;
        System.out.println("Result = " + result);
    }
}
