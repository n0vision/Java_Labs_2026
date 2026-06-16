package lr6.task5;

import lr6.ArrayParallelUtils;

import java.util.Arrays;

public class Task5 {

    public static int findMax(int[] array) throws InterruptedException {
        return ArrayParallelUtils.parallelMax(array);
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {12, -4, 87, 5, 33, 87, 0, -19, 44, 7};
        int max = findMax(numbers);

        System.out.println("Задание 5. Максимальный элемент массива");
        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.println("Количество потоков: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Максимум: " + max);
    }
}
