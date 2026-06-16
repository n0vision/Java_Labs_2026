package lr8.task4;

import lr8.DataDemoConfig;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Task4 {

    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final int MAX_ATTEMPTS = 3;

    public static Document connectWithRetry(String url) throws IOException {
        IOException lastError = null;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                System.out.println("Попытка подключения " + attempt + " к " + url);
                return Jsoup.connect(url)
                        .userAgent("Mozilla/5.0")
                        .timeout(10_000)
                        .get();
            } catch (IOException error) {
                lastError = error;
                System.out.println("Ошибка при получении HTML: " + error.getMessage());
                if (attempt < MAX_ATTEMPTS) {
                    System.out.println("Повторная попытка подключения...");
                }
            }
        }

        throw lastError;
    }

    public static List<String> parseNews(Document document) {
        List<String> lines = new ArrayList<>();
        Elements newsItems = document.select("div.news-item, div.news, article, li.news");
        if (newsItems.isEmpty()) {
            newsItems = document.select("h3, h4");
        }

        int index = 1;
        for (Element item : newsItems) {
            String title = item.text().trim();
            if (title.isEmpty()) {
                continue;
            }

            String date = "";
            Element dateElement = item.selectFirst(".date, .news-date, time, span.date");
            if (dateElement != null) {
                date = dateElement.text().trim();
            }

            lines.add(index + ". " + title + (date.isEmpty() ? "" : " | " + date));
            index++;
            if (index > 15) {
                break;
            }
        }

        if (lines.isEmpty()) {
            lines.add("Заголовок страницы: " + document.title());
        }

        return lines;
    }

    public static void saveNewsToFile(List<String> lines, Path outputPath) throws IOException {
        Files.createDirectories(outputPath.getParent());
        Files.write(outputPath, lines, StandardCharsets.UTF_8);
        System.out.println("Данные сохранены в файл: " + outputPath);
    }

    public static void run() throws Exception {
        Path outputPath = DataDemoConfig.resolve("task4", "news.txt");

        try {
            Document document = connectWithRetry(URL);
            List<String> lines = parseNews(document);

            System.out.println("Полученные новости:");
            lines.forEach(System.out::println);

            saveNewsToFile(lines, outputPath);
        } catch (IOException error) {
            System.out.println("Не удалось получить HTML после " + MAX_ATTEMPTS + " попыток.");
            System.out.println("Рекомендация: проверьте подключение к сети и доступность сайта.");
            throw error;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 4. Доработка HTML-парсера");
        run();
    }
}
