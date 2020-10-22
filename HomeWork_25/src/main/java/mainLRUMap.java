public class mainLRUMap {
    public static void main(String[] args) throws InterruptedException {
        User vlad = new User("Vlad", "Safari");
        User dima = new User("Dima", "Chrome");
        User kostya = new User("Kostya", "FireFox");
        User andrew = new User("Andrew", "Opera");
        User ilya = new User("Ilya", "Explore");
        User katy = new User("Katy","Tor");
        Cache cache = new Cache(5,5);

        cache.put(vlad);
        cache.put(dima);
        cache.put(kostya);
        cache.put(andrew);
        cache.put(katy);

        System.out.println(cache.getAll());

        System.out.println(cache.get(vlad));
        System.out.println(cache.get(kostya));

        cache.put(ilya);

        Thread.sleep(4000);
        System.out.println(cache.getAll());

        Thread.sleep(1000);

        System.out.println(cache.getAll());

    }
}
