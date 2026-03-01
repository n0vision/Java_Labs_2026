package lr1;

import java.util.Scanner;
import java.time.Year;

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите год рождения: ");
        int birthYear = scanner.nextInt();

        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;

        System.out.println("Ваш возраст: " + age);

        scanner.close();
    }
}