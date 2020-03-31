import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CreditCard {


    private final long serialNumber;
    private final int pinCode;
    private final int cvc;

    private int balance;

    public  CreditCard(){
        this.serialNumber  = ThreadLocalRandom
                .current()
                .nextLong((long)Math.pow(10, 15), (long)Math.pow(10,16)-1);
        this.pinCode = ThreadLocalRandom
                .current()
                .nextInt((int)Math.pow(10,3), (int)Math.pow(10, 4) - 1);
        this.cvc = ThreadLocalRandom
                .current()
                .nextInt((int)Math.pow(10,2), (int)Math.pow(10, 3) - 1);
        this.balance = 0;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public int getCvc() {
        return cvc;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
