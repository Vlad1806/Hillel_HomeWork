public class Average {
    public static void main(String[] args) {
        int[] array = {4, -5, 0, 6, 8};
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            sum += array[i];
        }
        System.out.println(" ");
        System.out.println("Average = " + sum / array.length);

    }
}
