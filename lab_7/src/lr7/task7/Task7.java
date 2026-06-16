package lr7.task7;

import lr7.FileDemoConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class Task7 {

    public static void run() throws Exception {
        String fileName;
        String text;
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            if (FileDemoConfig.isDemoMode()) {
                fileName = "task7/output.txt";
                text = "Текст для записи в файл.";
                System.out.println("Введите имя файла (демо): " + fileName);
                System.out.println("Введите текст (демо): " + text);
            } else {
                System.out.print("Введите имя файла (относительно папки data): ");
                fileName = scanner.nextLine().trim();
                System.out.print("Введите текст для записи: ");
                text = scanner.nextLine();
            }
        }

        var file = FileDemoConfig.getDataDir().resolve(fileName);
        Files.createDirectories(file.getParent());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile(), StandardCharsets.UTF_8))) {
            writer.write(text);
        }

        int charCount = text.length();
        System.out.println("Записано символов: " + charCount);
        System.out.println("Содержимое файла: " + Files.readString(file, StandardCharsets.UTF_8));

        Files.deleteIfExists(file);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 7. Запись текста в файл и подсчёт символов");
        run();
    }
}
