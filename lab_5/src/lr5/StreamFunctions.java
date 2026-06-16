package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class StreamFunctions {

    private StreamFunctions() {
    }

    public static int[] filterEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    public static int[] commonElements(int[] first, int[] second) {
        Set<Integer> secondSet = Arrays.stream(second)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(first)
                .filter(secondSet::contains)
                .distinct()
                .toArray();
    }

    public static List<String> filterUpperCaseStart(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static List<Integer> mapToSquares(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<Integer> filterDivisibleBy(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(n -> divisor != 0 && n % divisor == 0)
                .collect(Collectors.toList());
    }

    public static List<String> filterLongerThan(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }

    public static List<Integer> filterGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }

    public static List<String> filterLettersOnly(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }

    public static List<Integer> filterLessThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }

    public static boolean hasEvenNumber(int[] numbers) {
        return Arrays.stream(numbers).anyMatch(n -> n % 2 == 0);
    }
}
