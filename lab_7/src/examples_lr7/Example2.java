package examples_lr7;

import lr7.FileDemoConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Example2 {

    public static void run(String data) throws IOException {
        var file = FileDemoConfig.resolve("example2", "example_file.txt");
        Files.createDirectories(file.getParent());

        System.out.println("Запись данных в файл: \"" + data + "\"");
        try (FileOutputStream output = new FileOutputStream(file.toFile())) {
            output.write(data.getBytes());
            System.out.println("Данные записаны.");
        }

        System.out.println("Чтение данных из файла:");
        try (FileInputStream input = new FileInputStream(file.toFile())) {
            int symbol;
            StringBuilder builder = new StringBuilder();
            while ((symbol = input.read()) != -1) {
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
        System.out.println("Пример 1.2. Байтовый ввод и вывод (FileInputStream / FileOutputStream)");
        run("data");
    }
}
