package lr1;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input day of week: ");
        String dayOfWeek = scanner.nextLine();
        System.out.println("Input month: ");
        String month = scanner.nextLine();
        System.out.println("Input day: ");
        int day = scanner.nextInt();

        System.out.println("Сегодня: " + dayOfWeek + ", " + day + " " + month);

        scanner.close();
    }
}
