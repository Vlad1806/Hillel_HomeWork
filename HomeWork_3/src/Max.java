import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Max {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input number of array: ");
        int x = in.nextInt();

        int[] array = new int[x];
        Random r = new Random();

        for (int i = 0; i < x; i++) {
            array[i] = r.nextInt(100);
            System.out.print(array[i] + " ");
        }

        System.out.println(" ");

        Arrays.sort(array);
        int max = array[x - 1];
        for (int i = x - 1; i > 0; i--) {
            if (array[i] == max) {
                max = array[i];
                System.out.println(max);
            }
        }
    }
}