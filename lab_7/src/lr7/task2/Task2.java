package lr7.task2;

import lr7.FileDemoConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class Task2 {

    private static String readConsoleData(Scanner scanner) {
        if (FileDemoConfig.isDemoMode()) {
            String demoData = "demo data from console";
            System.out.println("Введите данные для записи в файл (демо): " + demoData);
            return demoData;
        }

        System.out.print("Введите данные для записи в файл: ");
        return scanner.nextLine();
    }

    public static void runByteStreams(Scanner scanner) throws Exception {
        String data = readConsoleData(scanner);
        var file = FileDemoConfig.resolve("task2", "byte_file.txt");
        Files.createDirectories(file.getParent());

        try (FileOutputStream output = new FileOutputStream(file.toFile())) {
            output.write(data.getBytes(StandardCharsets.UTF_8));
        }

        try (FileInputStream input = new FileInputStream(file.toFile())) {
            System.out.println("Прочитано из файла: " + new String(input.readAllBytes(), StandardCharsets.UTF_8));
        }

        Files.deleteIfExists(file);
    }

    public static void runCharStreams(Scanner scanner) throws Exception {
        String data = readConsoleData(scanner);
        var file = FileDemoConfig.resolve("task2", "char_file.txt");
        Files.createDirectories(file.getParent());

        try (FileWriter writer = new FileWriter(file.toFile())) {
            writer.write(data);
        }

        try (FileReader reader = new FileReader(file.toFile())) {
            StringBuilder builder = new StringBuilder();
            int symbol;
            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
            System.out.println("Прочитано из файла: " + builder);
        }

        Files.deleteIfExists(file);
    }

    public static void runBufferedStreams(Scanner scanner) throws Exception {
        String data = readConsoleData(scanner);
        var file = FileDemoConfig.resolve("task2", "buffered_file.txt");
        Files.createDirectories(file.getParent());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            writer.write(data);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
            System.out.println("Прочитано из файла: " + reader.readLine());
        }

        Files.deleteIfExists(file);
    }

    public static void runStreamAdapter(Scanner scanner) throws Exception {
        String data = readConsoleData(scanner);
        var inputFile = FileDemoConfig.resolve("task2", "adapter_input.txt");
        var outputFile = FileDemoConfig.resolve("task2", "adapter_output.txt");
        Files.createDirectories(inputFile.getParent());
        Files.writeString(inputFile, data, StandardCharsets.UTF_8);

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

        System.out.println("Преобразованный текст: " + Files.readString(outputFile, StandardCharsets.UTF_8));

        Files.deleteIfExists(inputFile);
        Files.deleteIfExists(outputFile);
    }

    public static void runPrintWriter(Scanner scanner) throws Exception {
        String data = readConsoleData(scanner);
        var file = FileDemoConfig.resolve("task2", "print_file.txt");
        Files.createDirectories(file.getParent());

        try (PrintWriter writer = new PrintWriter(file.toFile(), StandardCharsets.UTF_8)) {
            writer.println(data);
        }

        System.out.println("Записано в файл: " + Files.readString(file, StandardCharsets.UTF_8));
        Files.deleteIfExists(file);
    }

    public static void run() throws Exception {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.println("--- Байтовые потоки ---");
            runByteStreams(scanner);
            System.out.println();

            System.out.println("--- Символьные потоки ---");
            runCharStreams(scanner);
            System.out.println();

            System.out.println("--- Буферизованные потоки ---");
            runBufferedStreams(scanner);
            System.out.println();

            System.out.println("--- Адаптеры потоков ---");
            runStreamAdapter(scanner);
            System.out.println();

            System.out.println("--- PrintWriter ---");
            runPrintWriter(scanner);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 2. Ввод данных с консоли для записи в файл");
        run();
    }
}
