package timus.task_1264;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long M = scanner.nextLong();

        long result = N * (M + 1);

        System.out.println(result);

        scanner.close();
    }
}
