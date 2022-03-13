import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class LinkParser {

    //получаем список ссылок по текущему URL
    public Set<String> getLinks(String url) throws IOException, InterruptedException {
        sleep(100);
        Document document = Jsoup.connect(url).ignoreHttpErrors(true).maxBodySize(0).get();

        return document.select("a")
                .stream()
                .map(el -> el.attr("abs:href")) //получаем url страниц
                .filter(el ->
                        el.contains(Main.url) &&          //фильтруем по домену
                                !el.contains("#") &&      //фильтруем ссылки на внутренние элементы страницы
                                el.endsWith("/") &&       //фильтруем на ссылки не оканчивающиеся на слеш
                                !SiteMapGenerator.uniqueLinks.contains(el)  //проверяем уникальность ссылки
                ).collect(Collectors.toSet());
    }
}
