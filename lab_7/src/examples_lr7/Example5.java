package examples_lr7;

import lr7.FileDemoConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Example5 {

    public static void run() throws IOException {
        var inputFile = FileDemoConfig.resolve("example5", "input.txt");
        var outputFile = FileDemoConfig.resolve("example5", "output.txt");
        Files.createDirectories(inputFile.getParent());

        String sourceText = "первая строка\nвторая строка\nтретья строка";
        Files.writeString(inputFile, sourceText, StandardCharsets.UTF_8);
        System.out.println("Исходный файл input.txt создан.");

        System.out.println("Чтение из input.txt и преобразование в верхний регистр...");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile.toFile()), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(outputFile.toFile()), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
        }

        System.out.println("Результат записан в output.txt:");
        System.out.println(Files.readString(outputFile, StandardCharsets.UTF_8));

        Files.deleteIfExists(inputFile);
        Files.deleteIfExists(outputFile);
        System.out.println("Временные файлы удалены.");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Пример 1.5. Преобразование байтовых потоков в символьные");
        run();
    }
}
