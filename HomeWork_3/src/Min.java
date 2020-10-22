import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Min {

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
        int min = array[0];
        for (int i = 0; i < x; i++) {
            if (array[i] == min) {
                min = array[i];
                System.out.println(min);
            }
        }
    }

}



