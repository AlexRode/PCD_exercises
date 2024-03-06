package aula3.ex3;

public class Account {
    private double balance;

    // Synchronized para garantir acesso atômico ao saldo
    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized double getBalance() {
        return balance;
    }

}
