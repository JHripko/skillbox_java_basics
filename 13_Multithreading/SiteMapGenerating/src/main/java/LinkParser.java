import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class LinkParser {
    String baseUrl;

    public LinkParser(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public LinkFilter linkFilter = new LinkFilter();

    //получаем список ссылок по текущему URL
    public synchronized HashSet<String> getLinks(String url) throws IOException, InterruptedException {
        //задаем задержку
        Thread.sleep(500);
        //создаем список в который будут помещены уникальные ссылки
        HashSet<String> linksSet = new HashSet<>();
        Document document = Jsoup.connect(url).get();
        //получаем все элементы, содержащие атрибут href
        Elements elements = document.select("a");

        for (Element element : elements) {
            String link = element.absUrl("href");

            if (linkFilter.filter(baseUrl, link)) {
                linksSet.add(link);
            }
        }

        return linksSet;
    }
}
