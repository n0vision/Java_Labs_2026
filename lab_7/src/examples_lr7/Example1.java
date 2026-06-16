package examples_lr7;

import lr7.FileDemoConfig;

import java.io.File;
import java.io.IOException;

public class Example1 {

    public static void run() throws IOException {
        File folder = FileDemoConfig.resolve("example1", "example_folder").toFile();
        File file = new File(folder, "example_file.txt");

        System.out.println("Создание папки: " + folder.getPath());
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана.");
            } else {
                System.out.println("Не удалось создать папку.");
            }
        } else {
            System.out.println("Папка уже существует.");
        }

        System.out.println("Создание файла: " + file.getPath());
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("Файл создан.");
            } else {
                System.out.println("Не удалось создать файл.");
            }
        } else {
            System.out.println("Файл уже существует.");
        }

        System.out.println("Имя файла: " + file.getName());
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Размер файла: " + file.length() + " байт");
        System.out.println("Это файл: " + file.isFile());
        System.out.println("Это каталог: " + file.isDirectory());

        System.out.println("Удаление файла...");
        if (file.exists() && file.delete()) {
            System.out.println("Файл удалён.");
        }

        System.out.println("Удаление папки...");
        if (folder.exists() && folder.delete()) {
            System.out.println("Папка удалена.");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Пример 1.1. Работа с классом File");
        run();
    }
}
