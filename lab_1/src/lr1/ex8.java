package lr1;

import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int number2 = scanner.nextInt();

        int sum = number1 + number2;

        System.out.println("Сумма чисел: " + sum);

        scanner.close();
    }
}