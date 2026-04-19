package lr3.task2.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }

            int[] a = new int[n];
            long sum = 0;
            int count = 0;
            System.out.println("Введите " + n + " целых чисел:");
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                if (a[i] > 0) {
                    sum += a[i];
                    count++;
                }
            }

            if (count == 0) {
                throw new IllegalStateException("Положительные элементы отсутствуют.");
            }

            System.out.println("Среднее положительных = " + (sum / (double) count));
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число (введена строка или другой тип).");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Задание 1 завершено.");
        }
    }
}
