public class First_10 {
    public static void main(String[] args) {

        int[] array = new int[20];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = k;
            k-=5;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("array[" + i + "]= " + array[i]);
        }
    }

}
