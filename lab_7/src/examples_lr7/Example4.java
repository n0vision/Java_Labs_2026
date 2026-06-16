package examples_lr7;

import lr7.FileDemoConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Example4 {

    public static void run(String data) throws IOException {
        var file = FileDemoConfig.resolve("example4", "example_file.txt");
        Files.createDirectories(file.getParent());

        System.out.println("Запись данных в файл: \"" + data + "\"");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            writer.write(data);
            System.out.println("Данные записаны.");
        }

        System.out.println("Чтение данных из файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            System.out.println("Прочитано: " + builder);
        }

        System.out.println("Удаление файла...");
        if (Files.deleteIfExists(file)) {
            System.out.println("Файл удалён.");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Пример 1.4. Буферизация (BufferedReader / BufferedWriter)");
        run("data");
    }
}
