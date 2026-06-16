package timus.task_1877;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int getRequests = scanner.nextInt();
        int postRequests = scanner.nextInt();

        if (getRequests > postRequests) {
            System.out.println("GET");
        } else if (getRequests < postRequests) {
            System.out.println("POST");
        } else {
            System.out.println("EQUAL");
        }

        scanner.close();
    }
}
