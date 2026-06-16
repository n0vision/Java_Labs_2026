package lr7.task3;

import examples_lr7.Example8;
import lr7.FileDemoConfig;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Task3 {

    public static void run() throws Exception {
        var file = FileDemoConfig.resolve("task3", "sample.txt");
        Files.createDirectories(file.getParent());
        Files.writeString(file, "первая\nвторая\nтретья\n", StandardCharsets.UTF_8);

        int lines = Example8.countLines(file.toString());
        System.out.println("Файл: " + file.getFileName());
        System.out.println("Количество строк: " + lines);

        Files.deleteIfExists(file);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 3. Подсчёт строк в текстовом файле");
        run();
    }
}
