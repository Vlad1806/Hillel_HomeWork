class RunHome_work_14 {
    public static void main(String[] args) {
        Home_work_14 homework14 = new Home_work_14(10);
        System.out.println("First array: ");
        homework14.insert(22);
        homework14.insert(101);
        homework14.insert(65);
        homework14.insert(34);
        homework14.insert(12);
        homework14.insert(99);
        homework14.insert(55);
        homework14.insert(47);
        homework14.insert(29);
        homework14.insert(81);
        homework14.show();
        homework14.sort();
        homework14.show();
        System.out.println("Index started with one (First array): ");
        System.out.println("Index of value 55: " + homework14.binarySearch(55) + " binary");
        System.out.println("Index of value 99: " + homework14.binarySearch(99) + " binary");
        System.out.println("Index of value 34: " + homework14.interpolationSearch(34) + " inter");
        Home_work_14 homework14_2 = new Home_work_14(10);
        System.out.println("");
        System.out.println("Second array: ");
        homework14_2.insert(31);
        homework14_2.insert(111);
        homework14_2.insert(43);
        homework14_2.insert(98);
        homework14_2.insert(46);
        homework14_2.insert(32);
        homework14_2.insert(78);
        homework14_2.insert(65);
        homework14_2.insert(80);
        homework14_2.insert(123);
        homework14_2.show();
        homework14_2.insertSort();
        homework14_2.show();
        System.out.println("Index started with one (Second array): ");
        System.out.println("Index of value 98: " + homework14_2.binarySearch(98) + " binary");
        System.out.println("Index of value 78: " + homework14_2.binarySearch(78) + " binary");
        System.out.println("Index of value 65: " + homework14_2.interpolationSearch(65) + " inter");
    }
}