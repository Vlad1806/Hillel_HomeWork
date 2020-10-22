public class ATM {
    private long balance;


    public  long getBalance() {
        return balance;
    }
    public void refill(double var){
        synchronized (this) {
            if (var < 0) {
                System.out.println("You entered the wrong number!!!");
                return;

            }
            while (balance >= 30) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            balance += var;
            System.out.format("You have funded your account to %4.2f .Your balance : %d", var, balance);
            System.out.println(" ");
            notify();
        }
    }

    public void withdrawal(double var){
        synchronized(this) {
            if (balance < var) {
                System.out.println("There is not enough money in the account");
                return;
            }
            if (var < 0) {
                System.out.println("You entered the wrong number!!!");
                return;
            }
            while (balance < 30) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            balance -= var;
            System.out.format("You have withdrawn from the account %4.2f .Your balance : %d", var, balance);
            System.out.println(" ");
            notify();
        }
    }
}

