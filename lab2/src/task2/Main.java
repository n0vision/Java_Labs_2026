package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int n = in.nextInt();

        System.out.print("Введите количество столбцов: ");
        int m = in.nextInt();

        int[][] array = new int[n][m];

        int value = 1;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                // слева направо
                for (int j = 0; j < m; j++) {
                    array[i][j] = value++;
                }
            } else {
                // справа налево
                for (int j = m - 1; j >= 0; j--) {
                    array[i][j] = value++;
                }
            }
        }

        // вывод массива
        System.out.println("\nМассив:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
    }
}

