package timus.task_1409;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();

        long numerator = pow(a, b);
        long denominator = pow(c, d);
        System.out.println(numerator / denominator);
    }

    private static long pow(long base, long exponent) {
        long result = 1;
        for (long i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
