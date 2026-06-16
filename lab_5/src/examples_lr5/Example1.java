package examples_lr5;

import java.util.Arrays;

public class Example1 {

    public static int[] filterEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    public static boolean hasEvenNumber(int[] numbers) {
        return Arrays.stream(numbers).anyMatch(n -> n % 2 == 0);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] evenNumbers = filterEvenNumbers(numbers);

        System.out.println("Пример 1. Четные числа из массива");
        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Результат filter(): " + Arrays.toString(evenNumbers));
        System.out.println("Есть четные числа (anyMatch): " + hasEvenNumber(numbers));
    }
}
