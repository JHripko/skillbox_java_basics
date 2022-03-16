import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SiteMapFormatter {
    public Set<String> siteMap;

    public SiteMapFormatter(Set<String> siteMap) {
        this.siteMap = siteMap;
    }

    public Set<String> getFormattedSet() {
        Set<String> formattedSet = new LinkedHashSet<>();
        siteMap.forEach(link -> {
            StringBuilder linkString = new StringBuilder();
            int mainURLSlash = Main.url.split("/").length;      //количество слешей домашнего URL
            int linkSlash = link.split("/").length;             //количество слешей ссылки

            //если ссылка имеет вложенности, то вычислям глубину вложенности ссылки
            if (linkSlash > mainURLSlash) {
                int tabsCount = linkSlash - mainURLSlash;
                //в зависимости от ложенности добавляем табуляцию в строку
                linkString.append("\t".repeat(tabsCount)).append(link);

                formattedSet.add(linkString.toString());
            } else {
                formattedSet.add(link);
            }
        });
        return formattedSet;
    }
}
