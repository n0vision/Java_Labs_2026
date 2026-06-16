package lr5.task8;

import lr5.StreamFunctions;

import java.util.Arrays;
import java.util.List;

public class Task8 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, 0, 3, 7, 10, 15);
        int threshold = 5;
        List<Integer> result = StreamFunctions.filterGreaterThan(numbers, threshold);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Пороговое значение: " + threshold);
        System.out.println("Числа больше порога: " + result);
    }
}
