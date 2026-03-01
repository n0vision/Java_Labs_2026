package lr1;

import java.util.Scanner;
import java.time.Year;

public class ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите год рождения: ");
        int birthYear = scanner.nextInt();

        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;

        System.out.println("Имя: " + name + ", возраст: " + age);

        scanner.close();
    }
}