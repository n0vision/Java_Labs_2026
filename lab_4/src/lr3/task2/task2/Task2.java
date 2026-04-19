package lr3.task2.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите число строк и столбцов: ");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Размеры матрицы должны быть положительными.");
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Введите номер столбца (с 0): ");
            int col = scanner.nextInt();
            if (col < 0 || col >= cols) {
                throw new IndexOutOfBoundsException("Нет столбца с таким номером.");
            }

            System.out.println("Столбец " + col + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][col]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число (введена строка).");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Задание 2 завершено.");
        }
    }
}
