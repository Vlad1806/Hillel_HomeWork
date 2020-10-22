import java.util.Scanner;

public class AnyAverage {
    public static void main(String[] args) {

        Scanner var = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int max = var.nextInt();
        float sum = 0;
        float values[] = new float[max];
        int k = 0;
        for (int i = 0; i < max; i++) {
            k = i  + 1;
            System.out.print("Enter value " + k + ": ");
            values[i] = var.nextFloat();
            sum = sum + values[i];
        }
        sum = sum / max;
        System.out.println("Average: " + sum);
    }
}
