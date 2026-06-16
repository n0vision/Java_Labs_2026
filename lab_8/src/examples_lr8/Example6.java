package examples_lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Example6 {

    private static final String URL = "http://fat.urfu.ru/index.html";

    public static void run() throws Exception {
        Document document = Jsoup.connect(URL)
                .userAgent("Mozilla/5.0")
                .timeout(10_000)
                .get();

        Elements newsItems = document.select("div.news-item, div.news, article, li.news");
        if (newsItems.isEmpty()) {
            newsItems = document.select("h3, h4");
        }

        System.out.println("Новости с сайта " + URL + ":");

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

            System.out.println(index + ". " + title + (date.isEmpty() ? "" : " (" + date + ")"));
            index++;

            if (index > 10) {
                break;
            }
        }

        if (index == 1) {
            System.out.println("Не удалось найти блоки новостей. Заголовок страницы: " + document.title());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.4.3. Парсинг страницы fat.urfu.ru/index.html");
        run();
    }
}
