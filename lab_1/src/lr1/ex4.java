package lr1;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите месяц: ");
        String month = scanner.nextLine();
        System.out.println("Введите кол-во дней: ");
        int days = scanner.nextInt();

        System.out.println("Месяц " + month + " содержит " + days + " дней.");

        scanner.close();
    }
}