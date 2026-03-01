package timus.task_1409;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int harry = scanner.nextInt();
        int larry = scanner.nextInt();

        int total = harry + larry - 1;

        int harryNotShot = total - harry;
        int larryNotShot = total - larry;

        System.out.println(harryNotShot + " " + larryNotShot);
    }
}

