public class Replace {
    public static void main(String[] args) {

        int[] array = {4, -5, 0, 6, 8};
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }
        int min = array[0];
        int max = array[0];
        int index_min = 0;
        int index_max = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
                index_min = i;
            }
            if (array[i] > max) {
                max = array[i];
                index_max = i;
            }
        }
        array[index_min] = max;
        array[index_max] = min;
        System.out.println(" ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


    }
}
