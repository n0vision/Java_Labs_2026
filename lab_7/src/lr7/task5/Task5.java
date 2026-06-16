package lr7.task5;

import lr7.FileDemoConfig;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class Task5 {

    public static void run() throws Exception {
        var file = FileDemoConfig.resolve("task5", "size_demo.txt");
        Files.createDirectories(file.getParent());
        Files.writeString(file, "Пример файла для определения размера.", StandardCharsets.UTF_8);

        String fileName;
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            if (FileDemoConfig.isDemoMode()) {
                fileName = "task5/size_demo.txt";
                System.out.println("Введите имя файла (демо): " + fileName);
            } else {
                System.out.print("Введите имя файла (относительно папки data): ");
                fileName = scanner.nextLine().trim();
            }
        }

        var target = FileDemoConfig.getDataDir().resolve(fileName);
        if (!Files.exists(target)) {
            System.out.println("Файл не найден: " + target);
            return;
        }

        long size = Files.size(target);
        System.out.println("Размер файла \"" + target.getFileName() + "\": " + size + " байт");

        Files.deleteIfExists(file);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 5. Размер файла в байтах");
        run();
    }
}
