public class ATM {
    private long balance;

//    public ATM(long balance) {
//        this.balance = balance;
//    }

    public synchronized long getBalance() {
        return balance;
    }
    public synchronized void refill(double var){
        if (var < 0) {
            System.out.println("You entered the wrong number!!!");
            return;
        }
        balance += var;
        System.out.format("You have funded your account to %4.2f .Your balance : %d",var,balance);
        System.out.println(" ");
    }

    public synchronized void withdrawal(double var){
        if (balance < var) {
            System.out.println("There is not enough money in the account");
            return;
        }
        if (var < 0) {
            System.out.println("You entered the wrong number!!!");
            return;
        }
        balance -= var;
        System.out.format("You have withdrawn from the account %4.2f .Your balance : %d",var,balance);
        System.out.println(" ");
    }
}
