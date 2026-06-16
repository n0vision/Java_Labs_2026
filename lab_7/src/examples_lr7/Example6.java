package examples_lr7;

import lr7.FileDemoConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Example6 {

    public static void run() throws IOException {
        var file = FileDemoConfig.resolve("example6", "print_writer.txt");
        Files.createDirectories(file.getParent());

        System.out.println("Запись в файл с помощью PrintWriter...");
        try (PrintWriter writer = new PrintWriter(file.toFile(), StandardCharsets.UTF_8)) {
            writer.print("Строка без перевода. ");
            writer.println("Строка с переводом.");
            writer.printf("Число: %d, дробь: %.2f%n", 42, 3.1415);
        }

        System.out.println("Содержимое файла:");
        System.out.println(Files.readString(file, StandardCharsets.UTF_8));

        System.out.println("Вывод на консоль через PrintWriter(System.out):");
        try (PrintWriter consoleWriter = new PrintWriter(System.out, true, StandardCharsets.UTF_8)) {
            consoleWriter.println("Сообщение через PrintWriter");
        }

        Files.deleteIfExists(file);
        System.out.println("Файл удалён.");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Пример 1.6. Класс PrintWriter");
        run();
    }
}
