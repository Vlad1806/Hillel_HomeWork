import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;

public class RunCollection {

    public static void main(String[] args) {

        ExecuteCollection ex = new ExecuteCollection();
        ex.add("1");
        ex.add("2");
        ex.add("3");
        ex.add("4");
        ex.add("5");
        ex.add("6");
        ex.add("7");
        ex.add("8");
        ex.add("9");
        ex.add("10");

        ex.print();
        System.out.println("");
        System.out.print("Insert in position 9 value 22: ");
        ex.add(9, "22");
        System.out.println("");
        ex.print();
        System.out.println("");
        System.out.print("Delete value 22: ");
        ex.delete("22");
        ex.print();
        System.out.println("");
        ex.delete(1);
        ex.print();
        System.out.println("");
        System.out.print("Size: ");
        System.out.println(ex.size());

        ExecuteCollection ex2 = new ExecuteCollection();
        ex2.add("1");
        ex2.add("2");
        ex2.add("3");
        ex2.add("4");
        ex2.add("5");
        ex2.add("6");
        ex2.add("7");
        ex2.add("8");
        ex2.add("9");
        ex2.add("10");

        ExecuteCollection ex3= new ExecuteCollection();
        ex3.add("1");
        ex3.add("2");
        ex3.add("3");
        ex3.add("4");
        ex3.add("5");
        ex3.add("6");
        ex3.add("7");
        ex3.add("8");
        ex3.add("9");
        ex3.add("10");
        System.out.println("");
        ex2.print();
        System.out.println("");
        ex3.print();
        System.out.println("");
        System.out.println(ex2.equals(ex3));
        System.out.println(ex2.contain("11"));
        System.out.println(ex2.contain("9"));
        ex3.clear();
        ex3.print();
    }
}
