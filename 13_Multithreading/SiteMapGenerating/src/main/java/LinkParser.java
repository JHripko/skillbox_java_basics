import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class LinkParser {

    //получаем список ссылок по текущему URL
    public synchronized HashSet<String> getLinks(String url) throws IOException, InterruptedException {
        //задаем задержку
        Thread.sleep(500);
        //создаем список в который будут помещены уникальные ссылки
        HashSet<String> linksSet = new HashSet<>();
        Document document = Jsoup.connect(url).get();
        //получаем все элементы, содержащие атрибут href
        Elements elements = document.getElementsByAttribute("href");

        for (Element element : elements) {

            String link = element.absUrl("href");
            linksSet.add(link);
        }

        return linksSet;
    }
}
