package examples_lr8;

import lr8.DataDemoConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Files;

public class Example1 {

    public static void run() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element library = document.createElement("library");
        document.appendChild(library);

        addBook(document, library, "Война и мир", "Лев Толстой", "1869");
        addBook(document, library, "Мастер и Маргарита", "Михаил Булгаков", "1967");

        var xmlFile = DataDemoConfig.resolve("example1", "example.xml");
        Files.createDirectories(xmlFile.getParent());

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(xmlFile.toFile()));

        System.out.println("XML-файл успешно создан: " + xmlFile);
    }

    private static void addBook(Document document, Element library, String title, String author, String year) {
        Element book = document.createElement("book");

        Element titleElement = document.createElement("title");
        titleElement.setTextContent(title);
        book.appendChild(titleElement);

        Element authorElement = document.createElement("author");
        authorElement.setTextContent(author);
        book.appendChild(authorElement);

        Element yearElement = document.createElement("year");
        yearElement.setTextContent(year);
        book.appendChild(yearElement);

        library.appendChild(book);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.2.1. Создание XML-файла");
        run();
    }
}
