import java.lang.management.RuntimeMXBean;

public class MainATM {
    public static void main(String[] args) {
        ATM atm = new ATM();
        runMainATM runMainATM = new runMainATM(atm);
        runMainATM.setName("Plus - 0");
        minus runMainATM2 = new minus(atm);
        runMainATM2.setName("Minus - 1");
        runMainATM.start();
        runMainATM2.start();

    }
}

class runMainATM extends Thread {
   private ATM atm;
   public runMainATM(ATM atm){
       this.atm = atm;
   }
    @Override
    public void run() {
       for (int i = 0; i < 5; i++) {

           System.out.print(getName() + " ");
           atm.refill(30 + i);
           System.out.println("");
           try {
               Thread.sleep(1500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}

class minus extends Thread{
    private ATM atm;
    public minus(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print(getName() + " ");
            atm.withdrawal(50 + i);
            System.out.println("");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}