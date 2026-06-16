package examples_lr7;

import lr7.FileDemoConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Example8 {

    public static int countLines(String filePath) throws IOException {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lines++;
            }
        }
        return lines;
    }

    public static void run() throws IOException {
        var file = FileDemoConfig.resolve("example8", "lines.txt");
        Files.createDirectories(file.getParent());
        Files.writeString(file, "строка 1\nстрока 2\nстрока 3\n", StandardCharsets.UTF_8);

        int lineCount = countLines(file.toString());
        System.out.println("Файл: " + file);
        System.out.println("Количество строк: " + lineCount);

        Files.deleteIfExists(file);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Задача 3. Подсчёт строк в текстовом файле");
        run();
    }
}
