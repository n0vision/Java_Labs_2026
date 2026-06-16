package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public final class JsonBookService {

    private JsonBookService() {
    }

    public static Path defaultJsonPath() {
        return DataDemoConfig.resolve("task3", "library.json");
    }

    public static JSONObject createInitialLibrary() {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        books.add(createBook("Java Programming", "John Doe", "2015"));
        books.add(createBook("Python Programming", "Jane Smith", "2018"));
        books.add(createBook("Ruby Programming", "Bob Johnson", "2016"));

        library.put("books", books);
        return library;
    }

    public static JSONObject createBook(String title, String author, String year) {
        JSONObject book = new JSONObject();
        book.put("title", title);
        book.put("author", author);
        book.put("year", year);
        return book;
    }

    public static void saveLibrary(JSONObject library, Path jsonPath) throws Exception {
        Files.createDirectories(jsonPath.getParent());
        try (FileWriter writer = new FileWriter(jsonPath.toFile())) {
            writer.write(library.toJSONString());
        }
    }

    public static JSONObject loadLibrary(Path jsonPath) throws Exception {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new FileReader(jsonPath.toFile()));
    }

    public static JSONArray getBooks(JSONObject library) {
        return (JSONArray) library.get("books");
    }

    public static void findBooksByAuthor(JSONObject library, String author) {
        JSONArray books = getBooks(library);
        for (Object item : books) {
            if (!(item instanceof JSONObject)) {
                continue;
            }
            JSONObject book = (JSONObject) item;
            if (!author.equals(book.get("author"))) {
                continue;
            }
            System.out.println();
            System.out.println("Найдена книга:");
            System.out.println("Название: " + book.get("title"));
            System.out.println("Автор: " + book.get("author"));
            System.out.println("Год издания: " + book.get("year"));
        }
    }

    public static void addBook(JSONObject library, String title, String author, String year) {
        JSONObject newBook = createBook(title, author, year);
        getBooks(library).add(newBook);
    }

    public static boolean removeBookByTitle(JSONObject library, String title) {
        JSONArray books = getBooks(library);
        Iterator<?> iterator = books.iterator();
        while (iterator.hasNext()) {
            JSONObject book = (JSONObject) iterator.next();
            if (title.equals(book.get("title"))) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
