/**
 * Created by Саша on 25.06.2017.
 */
public class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }
    public void withDraw(int amount) {
        balance = balance - amount;
    }
}
