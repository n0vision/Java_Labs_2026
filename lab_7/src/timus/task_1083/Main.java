package timus.task_1083;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = 0;
        while (scanner.hasNextLong()) {
            sum += scanner.nextLong();
        }
        System.out.println(sum);
    }
}
