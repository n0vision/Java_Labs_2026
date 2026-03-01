package lr1;

import java.util.Scanner; //31 231
public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.println("Введите второе число: "); //31 231
        int number2 = scanner.nextInt();

        int sum = number1 + number2;
        int difference = number1 - number2;

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);

        scanner.close();
    }
}
