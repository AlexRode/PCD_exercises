package aula3.ex3;
import java.util.Random;

public class Cliente extends Thread {
    private final Account account;
    private double totalDeposited = 0;
    private final Random random = new Random();

    public Cliente(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            double amount = random.nextDouble() * 100;
            account.deposit(amount);
            totalDeposited += amount;
        }
    }

    public double getTotalDeposited() {
        return totalDeposited;
    }
}

