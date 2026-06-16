package examples_lr8;

import lr8.DataDemoConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Example2 {

    public static void run() throws Exception {
        File xmlFile = DataDemoConfig.resolve("example1", "example.xml").toFile();
        if (!xmlFile.exists()) {
            Example1.run();
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());

        NodeList books = document.getElementsByTagName("book");
        System.out.println("Количество книг: " + books.getLength());

        for (int index = 0; index < books.getLength(); index++) {
            Node node = books.item(index);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element book = (Element) node;
            String title = book.getElementsByTagName("title").item(0).getTextContent();
            String author = book.getElementsByTagName("author").item(0).getTextContent();
            String year = book.getElementsByTagName("year").item(0).getTextContent();

            System.out.println("Книга " + (index + 1) + ":");
            System.out.println("  Название: " + title);
            System.out.println("  Автор: " + author);
            System.out.println("  Год: " + year);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.2.2. Чтение XML-файла");
        run();
    }
}
