package timus.task_1880;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            System.out.println(first + second);
        }
    }
}
