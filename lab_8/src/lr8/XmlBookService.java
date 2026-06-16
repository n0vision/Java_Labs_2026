package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class XmlBookService {

    private XmlBookService() {
    }

    public static Path defaultXmlPath() {
        return DataDemoConfig.resolve("task2", "library.xml");
    }

    public static void createInitialLibrary(Path xmlPath) throws Exception {
        Files.createDirectories(xmlPath.getParent());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element library = document.createElement("library");
        document.appendChild(library);

        addBook(document, library, "Война и мир", "Лев Толстой", "1869");
        addBook(document, library, "Мастер и Маргарита", "Михаил Булгаков", "1967");
        addBook(document, library, "Преступление и наказание", "Фёдор Достоевский", "1866");

        saveDocument(document, xmlPath.toFile());
    }

    public static Document loadDocument(File xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();
        return document;
    }

    public static void addBook(Document document, String title, String author, String year) {
        Element library = document.getDocumentElement();
        addBook(document, library, title, author, year);
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

    public static void saveDocument(Document document, File xmlFile) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(xmlFile));
    }

    public static List<Element> findBooks(Document document, String author, String year) {
        NodeList nodeList = document.getElementsByTagName("book");
        List<Node> nodes = new ArrayList<>();
        for (int index = 0; index < nodeList.getLength(); index++) {
            nodes.add(nodeList.item(index));
        }

        return nodes.stream()
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .filter(element -> {
                    String bookAuthor = element.getElementsByTagName("author").item(0).getTextContent();
                    String bookYear = element.getElementsByTagName("year").item(0).getTextContent();
                    boolean authorMatches = author == null || author.isBlank()
                            || bookAuthor.equalsIgnoreCase(author);
                    boolean yearMatches = year == null || year.isBlank() || bookYear.equals(year);
                    return authorMatches && yearMatches;
                })
                .collect(Collectors.toList());
    }

    public static boolean removeBookByTitle(Document document, String title) {
        NodeList nodeList = document.getElementsByTagName("book");
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element bookElement = (Element) node;
            String bookTitle = bookElement.getElementsByTagName("title").item(0).getTextContent();
            if (bookTitle.equalsIgnoreCase(title)) {
                Node parentNode = bookElement.getParentNode();
                parentNode.removeChild(bookElement);
                return true;
            }
        }
        return false;
    }

    public static void printBooks(List<Element> books) {
        if (books.isEmpty()) {
            System.out.println("Книги не найдены.");
            return;
        }

        IntStream.range(0, books.size()).forEach(index -> {
            Element book = books.get(index);
            System.out.println("Книга " + (index + 1) + ":");
            System.out.println("  Название: " + book.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("  Автор: " + book.getElementsByTagName("author").item(0).getTextContent());
            System.out.println("  Год: " + book.getElementsByTagName("year").item(0).getTextContent());
        });
    }
}
