package lr5.task1;

import lr5.StreamFunctions;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] evenNumbers = StreamFunctions.filterEvenNumbers(numbers);

        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Четные числа: " + Arrays.toString(evenNumbers));
        System.out.println("Есть четные числа (anyMatch): " + StreamFunctions.hasEvenNumber(numbers));
    }
}
