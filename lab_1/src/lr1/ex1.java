package lr1;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Input first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Input middle name: ");
        String middleName = scanner.nextLine();

        System.out.println("Hello " + lastName + ", " + firstName + ", " + middleName);

        scanner.close();
    }
}