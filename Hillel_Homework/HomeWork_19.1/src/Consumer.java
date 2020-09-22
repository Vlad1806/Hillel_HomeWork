public class Consumer implements Runnable {
    public static ATM atm;

    public Consumer(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {

        for (int i = 10; i < 50; i += 10) {
            atm.withdrawal(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
