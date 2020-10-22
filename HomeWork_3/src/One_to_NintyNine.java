import java.util.Scanner;

public class One_to_NintyNine {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number from 1 till 3 " +
                " 1 - for use (for loop)  or 2 - for use (while loop) or 3 - for use (do while loop) : ");
        int s = in.nextInt();
        int i = 1;
        switch (s) {
            case 1:
                for (i = 1; i < 100; i += 2) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                break;
            case 2:
                while (i < 100) {
                    System.out.print(i);
                    System.out.print(" ");
                    i += 2;
                }
                break;
            case 3:
                do {
                    System.out.print(i);
                    System.out.print(" ");
                    i += 2;
                } while (i < 100);
                break;
        }
    }
}

