public class Producer implements Runnable{
    public static ATM atm;

    public Producer(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        for (int i = 10; i < 50; i += 10) {
            atm.refill(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
