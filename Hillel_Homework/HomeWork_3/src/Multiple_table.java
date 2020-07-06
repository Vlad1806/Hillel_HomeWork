import java.util.Scanner;

public class Multiple_table {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a value: ");
        int x = in.nextInt();
        int k = 1;
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] += k ;
                k++;
                System.out.print(array[i][j] + " = " + (array[i][j] * x) + "   ");
            }
            System.out.println();
        }
    }

}
