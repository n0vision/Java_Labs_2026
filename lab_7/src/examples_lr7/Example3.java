package examples_lr7;

import lr7.FileDemoConfig;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Example3 {

    public static void run(String data) throws IOException {
        var file = FileDemoConfig.resolve("example3", "example_file.txt");
        Files.createDirectories(file.getParent());

        System.out.println("Запись данных в файл: \"" + data + "\"");
        try (FileWriter writer = new FileWriter(file.toFile())) {
            writer.write(data);
            System.out.println("Данные записаны.");
        }

        System.out.println("Чтение данных из файла:");
        try (FileReader reader = new FileReader(file.toFile())) {
            int symbol;
            StringBuilder builder = new StringBuilder();
            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
            System.out.println("Прочитано: " + builder);
        }

        System.out.println("Удаление файла...");
        if (Files.deleteIfExists(file)) {
            System.out.println("Файл удалён.");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Пример 1.3. Символьные потоки (FileReader / FileWriter)");
        run("data");
    }
}
