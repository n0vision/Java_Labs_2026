package examples_lr7;

import lr7.FileDemoConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Example9 {

    public static void copyFile(String sourcePath, String targetPath) throws IOException {
        Files.copy(
                FileDemoConfig.getDataDir().resolve(sourcePath),
                FileDemoConfig.getDataDir().resolve(targetPath),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    public static void run() throws IOException {
        var source = FileDemoConfig.resolve("example9", "source.txt");
        var target = FileDemoConfig.resolve("example9", "target.txt");
        Files.createDirectories(source.getParent());
        Files.writeString(source, "Текст для копирования.\nВторая строка.", StandardCharsets.UTF_8);

        System.out.println("Исходный файл: " + source);
        copyFile("example9/source.txt", "example9/target.txt");
        System.out.println("Файл скопирован в: " + target);
        System.out.println("Содержимое копии:");
        System.out.println(Files.readString(target, StandardCharsets.UTF_8));

        Files.deleteIfExists(source);
        Files.deleteIfExists(target);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Задача 4. Копирование текстового файла");
        run();
    }
}
