package task7;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(67000);

        account.deposit(6000);
        account.withdraw(7000);

        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
