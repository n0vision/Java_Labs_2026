package task1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите размер массива: ");
        int size = in.nextInt();

        int[] nums = new int[size];

        System.out.println("Массив:");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(200);
            System.out.println("nums[" + i + "] = " + nums[i]);
        }

        // Поиск минимального значения
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        System.out.println("\nМинимальный элемент = " + min);

        // Поиск всех индексов минимального элемента
        System.out.print("Индекс(ы) минимального элемента: ");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}

