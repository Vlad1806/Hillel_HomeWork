import java.util.Scanner;

public class N_power {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a value: ");
        int x = in.nextInt();
        System.out.print("Input a power: ");
        int n = in.nextInt();
        System.out.println("Result: " + Math.pow(x,n));
    }
}
