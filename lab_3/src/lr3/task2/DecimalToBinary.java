package lr3.task2;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();
        long magnitude = n < 0 ? -(long) n : n;
        if (n < 0) {
            System.out.print("-");
        }
        System.out.println(toBinary(magnitude));
        scanner.close();
    }

    public static String toBinary(long n) {
        if (n < 2) {
            return String.valueOf(n);
        }
        return toBinary(n / 2) + (n % 2);
    }
}
