
public class RunCollection {
    public static void main(String[] args) {
        Collection list = new Collection();

        System.out.println(" ");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.print();
        System.out.println(" ");
        list.add(3,"qwerty");
        list.print();
        System.out.println(" ");
        list.add(10,"qwerty2");
        list.print();
        System.out.println(" ");
        list.delete("6");
        list.print();

        System.out.println(" ");
        list.delete(1);
        list.print();

    }
}
