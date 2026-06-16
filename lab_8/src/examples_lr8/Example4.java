package examples_lr8;

import lr8.DataDemoConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Example4 {

    public static void run() throws Exception {
        var jsonFile = DataDemoConfig.resolve("example3", "example-json.json").toFile();
        if (!jsonFile.exists()) {
            Example3.run();
        }

        JSONParser parser = new JSONParser();
        JSONObject library = (JSONObject) parser.parse(new FileReader(jsonFile));
        JSONArray books = (JSONArray) library.get("books");

        System.out.println("Количество книг в JSON: " + books.size());

        for (Object item : books) {
            JSONObject book = (JSONObject) item;
            System.out.println("Название: " + book.get("title"));
            System.out.println("Автор: " + book.get("author"));
            System.out.println("Год: " + book.get("year"));
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.3.3. Чтение JSON-файла");
        run();
    }
}
