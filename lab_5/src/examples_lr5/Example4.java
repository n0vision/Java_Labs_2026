package examples_lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example4 {

    public static List<Integer> mapToSquares(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = mapToSquares(numbers);

        System.out.println("Пример 4. Квадраты чисел");
        System.out.println("Исходный список: " + numbers);
        System.out.println("Результат map(): " + squares);
    }
}
