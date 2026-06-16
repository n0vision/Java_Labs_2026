package lr6.task6;

import lr6.ArrayParallelUtils;

import java.util.Arrays;

public class Task6 {

    public static long sumArray(int[] array) throws InterruptedException {
        return ArrayParallelUtils.parallelSum(array);
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {12, -4, 87, 5, 33, 87, 0, -19, 44, 7};
        long sum = sumArray(numbers);

        System.out.println("Задание 6. Сумма элементов массива");
        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.println("Количество потоков: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Сумма: " + sum);
    }
}
