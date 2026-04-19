package lr3.task2.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }

            byte[] a = new byte[n];
            int sum = 0;
            System.out.println("Введите " + n + " числа типа byte (-128..127):");
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Число " + value + " вне диапазона byte.");
                }
                a[i] = (byte) value;
                sum += a[i];
            }

            if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                throw new ArithmeticException("Сумма " + sum + " вне диапазона byte.");
            }

            byte result = (byte) sum;
            System.out.println("Сумма элементов = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число, но введена строка.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Задание 3 завершено.");
        }
    }
}
