package lr5.task9;

import lr5.StreamFunctions;

import java.util.Arrays;
import java.util.List;

public class Task9 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "Stream123", "API", "test!", "Lambda");
        List<String> result = StreamFunctions.filterLettersOnly(strings);

        System.out.println("Исходный список: " + strings);
        System.out.println("Строки только из букв: " + result);
    }
}
