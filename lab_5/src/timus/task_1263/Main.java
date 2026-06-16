package timus.task_1263;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        long evenCount = Arrays.stream(numbers)
                .filter(value -> value % 2 == 0)
                .count();

        System.out.println(evenCount);
        scanner.close();
    }
}
