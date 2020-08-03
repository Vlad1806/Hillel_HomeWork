import java.util.ArrayList;

public class RunList {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> comparaList = new LinkedList<>();
        LinkedList<String> comparaList2 = new LinkedList<>();
        list.add("sdr1");
        list.displayList();
        System.out.println(list.size());
        String[] str = new String[5];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(i);
        }
        list.addAll(str);
        list.displayList();
        System.out.println(list.size());

        ArrayList<String> str1 = new ArrayList<>();
        str1.add("a");
        str1.add("b");
        str1.add("c");

        list.addAll(str1);
        list.displayList();
        System.out.println(list.size());

        list.delete(2);
        list.displayList();
        System.out.println(list.size());

        System.out.print("get element by index 5: ");
        System.out.println(list.get(5));


        list.delete("b");
        list.displayList();
        System.out.println(list.size());

        comparaList.add("sdr1");
        comparaList.add("0");
        comparaList.add("2");
        comparaList.add("3");
        comparaList.add("4");
        comparaList.add("a");
        comparaList.add("c");

        comparaList2.add("sdr1");
        comparaList2.add("0");
        comparaList2.add("2");
        comparaList2.add("3");
        comparaList2.add("4");
        comparaList2.add("a");
        comparaList2.add("q");

        System.out.println("Compare list_1: ");
        System.out.println(list.compare(comparaList));

        System.out.println("Compare list_2: ");
        System.out.println(list.compare(comparaList2));


        System.out.println("List contains (gg) : " + list.contains("gg"));
        System.out.println("List contains (b) : " + list.contains("c"));


        System.out.println("Trim: " + list.trim());
        list.displayList();
        System.out.println("Clear:");
        list.clear();
        list.displayList();
        System.out.println(list.size());



    }
}
