package lr5.task5;

import lr5.StreamFunctions;

import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java Stream", "Python", "Stream API", "Lambda");
        String substring = "Stream";
        List<String> result = StreamFunctions.filterBySubstring(strings, substring);

        System.out.println("Исходный список: " + strings);
        System.out.println("Подстрока: " + substring);
        System.out.println("Строки с подстрокой: " + result);
    }
}
