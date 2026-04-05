package lr3.task3;

import java.util.Scanner;

public class ArrayRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("Размер не может быть отрицательным.");
            scanner.close();
            return;
        }
        int[] data = new int[n];
        if (n > 0) {
            System.out.println("Введите " + n + " целых чисел:");
            fillArray(scanner, data, 0);
        }
        System.out.print("Массив: ");
        printArray(data, 0);
        System.out.println();
        scanner.close();
    }

    public static void fillArray(Scanner scanner, int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        array[index] = scanner.nextInt();
        fillArray(scanner, array, index + 1);
    }

    public static void printArray(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        if (index > 0) {
            System.out.print(" ");
        }
        System.out.print(array[index]);
        printArray(array, index + 1);
    }
}
