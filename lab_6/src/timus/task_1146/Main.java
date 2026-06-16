package timus.task_1146;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = 0L;

        while (scanner.hasNextLong()) {
            sum += scanner.nextLong();
        }

        System.out.println(sum);
        scanner.close();
    }
}
