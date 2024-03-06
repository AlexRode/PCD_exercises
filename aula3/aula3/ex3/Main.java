package aula3.ex3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Cliente[] clientes = new Cliente[10];

        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(account);
            clientes[i].start();
        }

        Thread.sleep(10000); // Dorme 10 segundos

        double totalDepositedByClients = 0;
        for (Cliente cliente : clientes) {
            cliente.interrupt();
        }

        for (Cliente cliente : clientes) {
            cliente.join(); // Espera os clientes terminarem
            totalDepositedByClients += cliente.getTotalDeposited();
        }

        System.out.println("Saldo da conta: " + account.getBalance());
        System.out.println("Total depositado pelos clientes: " + totalDepositedByClients);
    }
}
