package lr8.task2;

import lr8.DataDemoConfig;
import lr8.XmlBookService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    private static String readLine(Scanner scanner, String prompt, String demoValue) {
        if (DataDemoConfig.isDemoMode()) {
            System.out.println(prompt + demoValue);
            return demoValue;
        }
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void run() throws Exception {
        Path xmlPath = XmlBookService.defaultXmlPath();
        if (!xmlPath.toFile().exists()) {
            XmlBookService.createInitialLibrary(xmlPath);
        }

        Document document = XmlBookService.loadDocument(xmlPath.toFile());
        System.out.println("Текущая библиотека (XML):");
        XmlBookService.printBooks(XmlBookService.findBooks(document, "", ""));

        Scanner scanner = new Scanner(System.in);

        String title = readLine(scanner, "Введите название новой книги: ", "Идиот");
        String author = readLine(scanner, "Введите автора: ", "Фёдор Достоевский");
        String year = readLine(scanner, "Введите год издания: ", "1869");
        XmlBookService.addBook(document, title, author, year);
        XmlBookService.saveDocument(document, xmlPath.toFile());
        System.out.println("Книга добавлена в XML-файл.");

        String searchAuthor = readLine(scanner, "Введите автора для поиска: ", "Лев Толстой");
        String searchYear = readLine(scanner, "Введите год для поиска (или пусто): ", "1869");
        System.out.println("Результаты поиска:");
        List<Element> found = XmlBookService.findBooks(document, searchAuthor, searchYear);
        XmlBookService.printBooks(found);

        String removeTitle = readLine(scanner, "Введите название книги для удаления: ", "Идиот");
        if (XmlBookService.removeBookByTitle(document, removeTitle)) {
            XmlBookService.saveDocument(document, xmlPath.toFile());
            System.out.println("Книга \"" + removeTitle + "\" удалена.");
        } else {
            System.out.println("Книга \"" + removeTitle + "\" не найдена.");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 2. Доработка XML-парсера (список книг)");
        run();
    }
}
