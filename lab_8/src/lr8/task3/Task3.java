package lr8.task3;

import lr8.DataDemoConfig;
import lr8.JsonBookService;
import org.json.simple.JSONObject;

import java.nio.file.Path;
import java.util.Scanner;

public class Task3 {

    private static String readLine(Scanner scanner, String prompt, String demoValue) {
        if (DataDemoConfig.isDemoMode()) {
            System.out.println(prompt + demoValue);
            return demoValue;
        }
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void run() throws Exception {
        Path jsonPath = JsonBookService.defaultJsonPath();
        JSONObject library;
        if (!jsonPath.toFile().exists()) {
            library = JsonBookService.createInitialLibrary();
            JsonBookService.saveLibrary(library, jsonPath);
        } else {
            library = JsonBookService.loadLibrary(jsonPath);
        }

        System.out.println("Текущая библиотека (JSON) загружена из: " + jsonPath);

        Scanner scanner = new Scanner(System.in);

        String searchAuthor = readLine(scanner, "Введите автора для поиска: ", "John Doe");
        System.out.println("Результаты поиска по автору:");
        JsonBookService.findBooksByAuthor(library, searchAuthor);

        String title = readLine(scanner, "Введите название новой книги: ", "Новая книга");
        String author = readLine(scanner, "Введите автора: ", "Новый автор");
        String year = readLine(scanner, "Введите год издания: ", "2023");
        JsonBookService.addBook(library, title, author, year);
        JsonBookService.saveLibrary(library, jsonPath);
        System.out.println("Книга добавлена в JSON-файл.");

        String removeTitle = readLine(scanner, "Введите название книги для удаления: ", "Новая книга");
        if (JsonBookService.removeBookByTitle(library, removeTitle)) {
            JsonBookService.saveLibrary(library, jsonPath);
            System.out.println("Книга \"" + removeTitle + "\" удалена.");
        } else {
            System.out.println("Книга \"" + removeTitle + "\" не найдена.");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 3. Доработка JSON-парсера");
        run();
    }
}
