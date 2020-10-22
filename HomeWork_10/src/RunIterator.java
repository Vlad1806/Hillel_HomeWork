public class RunIterator {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{3, 6, 5, 7, 4, 5};
        iterator<Integer> set = new iterator<Integer>(integers);
        while (set.hasNext()){
            Integer a = set.next();
            System.out.println(a);
        }
    }
}
