package lr5.task7;

import lr5.StreamFunctions;

import java.util.Arrays;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd", "hello");
        int minLength = 3;
        List<String> result = StreamFunctions.filterLongerThan(strings, minLength);

        System.out.println("Исходный список: " + strings);
        System.out.println("Минимальная длина: " + minLength);
        System.out.println("Строки длиннее заданного значения: " + result);
    }
}
