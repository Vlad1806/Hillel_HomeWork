import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        System.out.print("Input a number from 1 till 3 " +
                " 1 - for use (for loop)  or 2 - for use (while loop) or 3 - for use (do while loop) : ");
        int s = in.nextInt();
        int i = 1;
        switch (s) {
            case 1:
                double f = 1;
                for (i = 1; i < num + 1; i++) {
                    f *= i;
                }
                System.out.println(f);
                break;
            case 2:
                double w = 1;
                while (i < num + 1) {
                    w *= i;
                    i++;
                }
                System.out.println(w);
                break;
            case 3:
                double dw = 1;
                do {
                    dw *= i;
                    i++;
                } while (i < num + 1);
                System.out.println(dw);
                break;
        }
    }
}
