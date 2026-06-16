package examples_lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Example5 {

    private static final String URL = "https://itlearn.ru/first-steps";

    public static void run() throws Exception {
        Document document = Jsoup.connect(URL)
                .userAgent("Mozilla/5.0")
                .timeout(10_000)
                .get();

        Elements links = document.select("a[href]");
        System.out.println("Ссылки на странице " + URL + ":");

        int count = 0;
        for (Element link : links) {
            String href = link.attr("abs:href");
            if (!href.isBlank()) {
                System.out.println(href);
                count++;
            }
        }

        System.out.println("Всего ссылок: " + count);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.4.2. Парсинг страницы itlearn.ru/first-steps");
        run();
    }
}
