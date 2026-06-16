package lr5.task4;

import lr5.StreamFunctions;

import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, -6);
        List<Integer> squares = StreamFunctions.mapToSquares(numbers);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Квадраты чисел: " + squares);
    }
}
