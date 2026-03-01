package lr1;

import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");
        int number = scanner.nextInt();

        int first = number;
        int second = number - 1;
        int third = number + 1;
        int sum = first + second + third;
        int fourth = sum * sum;

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);

        scanner.close();
    }
}