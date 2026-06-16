package examples_lr7;

import lr7.FileDemoConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class Example7 {

    public static void run() throws IOException, ClassNotFoundException {
        var file = FileDemoConfig.resolve("example7", "person.ser");
        Files.createDirectories(file.getParent());

        Person person = new Person("Иван", 25);
        System.out.println("Исходный объект: " + person);

        System.out.println("Сериализация объекта в файл...");
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file.toFile()))) {
            output.writeObject(person);
        }

        System.out.println("Десериализация объекта из файла...");
        Person restored;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file.toFile()))) {
            restored = (Person) input.readObject();
        }

        System.out.println("Восстановленный объект: " + restored);

        Files.deleteIfExists(file);
        System.out.println("Файл сериализации удалён.");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Пример 1.7. Сериализация объекта Person");
        run();
    }
}
