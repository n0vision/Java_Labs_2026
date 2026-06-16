package lr5.task3;

import lr5.StreamFunctions;

import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "python", "Stream", "api", "Lambda");
        List<String> upperCaseStart = StreamFunctions.filterUpperCaseStart(strings);

        System.out.println("Исходный список: " + strings);
        System.out.println("Строки с большой буквы: " + upperCaseStart);
    }
}
