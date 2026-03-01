package timus.task_1293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во панелей: ");
        int N = scanner.nextInt();
        System.out.println("Введите длину панели: ");
        int A = scanner.nextInt();
        System.out.println("Введите шиирну панели: ");
        int B = scanner.nextInt();

        int result = N * A * B * 2;

        System.out.println(result);

        scanner.close();
    }
}
