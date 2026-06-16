package examples_lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {

    public static List<String> filterUpperCaseStart(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "python", "Stream", "api", "Lambda");
        List<String> result = filterUpperCaseStart(strings);

        System.out.println("Пример 3. Строки, начинающиеся с большой буквы");
        System.out.println("Исходный список: " + strings);
        System.out.println("Результат filter(): " + result);
    }
}
