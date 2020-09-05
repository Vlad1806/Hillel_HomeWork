
public class RunCollect {
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
        System.out.println("Size : " + ex.size());
        System.out.print("Add index 10 (100): ");
        ex.add(10, "100");
        ex.print();
        System.out.println("Size : " + ex.size());

        System.out.print("Delete index 10 : ");
        ex.delete(10);
        ex.print();
        System.out.println("Size : " + ex.size());
        System.out.print("Delete 5 : ");
        ex.delete("5");
        ex.print();
        System.out.println("Size : " + ex.size());

        System.out.println("Index 5 : " + ex.get(5));

        System.out.println("Contain 6 : " + ex.contain("6"));
        System.out.println("Contain 99 : " + ex.contain("99"));
        System.out.println("");
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

        System.out.print("ex : ");
        ex.print();
        System.out.print("ex2 : ");
        ex2.print();
        System.out.println("ex == ex2 : " + ex.equals(ex2));
        ex2.delete("5");

        System.out.print("ex2 : ");
        ex2.print();
        System.out.println("ex == ex2 : " + ex.equals(ex2));
        ex.equals(ex2);


        System.out.println("Clear : " + ex.clear());
        ex.print();
        System.out.println("Size : " + ex.size());
    }
}
