package lr7.task4;

import examples_lr7.Example9;
import lr7.FileDemoConfig;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Task4 {

    public static void run() throws Exception {
        var source = FileDemoConfig.resolve("task4", "source.txt");
        var target = FileDemoConfig.resolve("task4", "copy.txt");
        Files.createDirectories(source.getParent());
        Files.writeString(source, "Содержимое исходного файла.\nЕщё одна строка.", StandardCharsets.UTF_8);

        Example9.copyFile("task4/source.txt", "task4/copy.txt");
        System.out.println("Файл скопирован.");
        System.out.println(Files.readString(target, StandardCharsets.UTF_8));

        Files.deleteIfExists(source);
        Files.deleteIfExists(target);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 4. Копирование текстового файла");
        run();
    }
}
