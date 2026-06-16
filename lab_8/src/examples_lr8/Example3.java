package examples_lr8;

import lr8.DataDemoConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.nio.file.Files;

public class Example3 {

    public static void run() throws Exception {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        books.add(createBook("Java Programming", "John Doe", "2015"));
        books.add(createBook("Python Programming", "Jane Smith", "2018"));

        library.put("books", books);

        var jsonFile = DataDemoConfig.resolve("example3", "example-json.json");
        Files.createDirectories(jsonFile.getParent());

        try (FileWriter writer = new FileWriter(jsonFile.toFile())) {
            writer.write(library.toJSONString());
        }

        System.out.println("JSON-файл успешно создан: " + jsonFile);
    }

    private static JSONObject createBook(String title, String author, String year) {
        JSONObject book = new JSONObject();
        book.put("title", title);
        book.put("author", author);
        book.put("year", year);
        return book;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.3.2. Создание JSON-файла");
        run();
    }
}
