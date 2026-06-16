package lr5.task6;

import lr5.StreamFunctions;

import java.util.Arrays;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 33);
        int divisor = 5;
        List<Integer> result = StreamFunctions.filterDivisibleBy(numbers, divisor);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Делитель: " + divisor);
        System.out.println("Числа, делящиеся без остатка: " + result);
    }
}
