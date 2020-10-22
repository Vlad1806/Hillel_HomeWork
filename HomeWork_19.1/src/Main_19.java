
public class Main_19 {
    public synchronized static void main(String[] args) throws InterruptedException {
        ATM atm = new ATM();
        Producer producer = new Producer(atm);
        Consumer consumer = new Consumer(atm);
        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
