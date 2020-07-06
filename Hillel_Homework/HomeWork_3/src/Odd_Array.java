public class Odd_Array {
    public static void main(String[] args) {

        int[] array = new int[10];
        int k = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = k;
            k += 2;
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ",");
            }
        }

    }
}
