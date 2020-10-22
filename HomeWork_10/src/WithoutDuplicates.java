import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class WithoutDuplicates {
    public static <T>Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<T>(collection);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        list.add(22);
        list.add(12);
        list.add(3);
        list.add(22);
        list.add(39);
        list.add(42);
        list.add(76);
        list.add(44);
        list.add(44);
        list.add(44);
        for (Integer item: list) {
            System.out.print(item + " ");
        }
        WithoutDuplicates withoutDuplicates = new WithoutDuplicates();
        System.out.println(" ");
        Collection<Integer> cz =  withoutDuplicates.removeDuplicates(list);
        for (Integer item: cz) {
            System.out.print(item + " ");
        }


    }
}
