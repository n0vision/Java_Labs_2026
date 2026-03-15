package task7;

public class BankAccount implements BankAccountInterface {

    private double balance;

    // конструктор
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // пополнение счёта
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнение: " + amount);
    }

    // снятие денег
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Снятие: " + amount);
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    // получение текущего баланса
    public double getBalance() {
        return balance;
    }
}
