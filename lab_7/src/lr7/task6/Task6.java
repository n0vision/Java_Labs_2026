package lr7.task6;

import lr7.FileDemoConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {

    public static List<String> findLinesWithWord(String filePath, String word) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    result.add(line);
                }
            }
        }
        return result;
    }

    public static void run() throws Exception {
        var file = FileDemoConfig.resolve("task6", "search.txt");
        Files.createDirectories(file.getParent());
        Files.writeString(file,
                "Java — язык программирования.\nРабота с файлами в Java.\nПотоки ввода-вывода.\n",
                StandardCharsets.UTF_8);

        String fileName;
        String word;
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            if (FileDemoConfig.isDemoMode()) {
                fileName = "task6/search.txt";
                word = "Java";
                System.out.println("Введите имя файла (демо): " + fileName);
                System.out.println("Введите слово для поиска (демо): " + word);
            } else {
                System.out.print("Введите имя файла (относительно папки data): ");
                fileName = scanner.nextLine().trim();
                System.out.print("Введите слово для поиска: ");
                word = scanner.nextLine().trim();
            }
        }

        var target = FileDemoConfig.getDataDir().resolve(fileName);
        List<String> lines = findLinesWithWord(target.toString(), word);

        System.out.println("Строки, содержащие \"" + word + "\":");
        if (lines.isEmpty()) {
            System.out.println("(нет совпадений)");
        } else {
            lines.forEach(System.out::println);
        }

        Files.deleteIfExists(file);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 6. Поиск строк, содержащих заданное слово");
        run();
    }
}
