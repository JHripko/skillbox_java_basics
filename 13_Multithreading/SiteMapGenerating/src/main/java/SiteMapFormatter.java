import java.util.Set;
import java.util.TreeSet;

public class SiteMapFormatter {
    public Set<String> siteMap;

    public SiteMapFormatter(Set<String> siteMap) {
        this.siteMap = siteMap;
    }

    public Set<String> getFormattedSet() {
        Set<String> formattedSet = new TreeSet<>();
        siteMap.forEach(link -> {
            StringBuilder linkString = new StringBuilder();
            int mainURLSlash = Main.url.split("/").length;
            int linkSlash = link.split("/").length;

            if (linkSlash > mainURLSlash) {
                int tabsCount = linkSlash - mainURLSlash;
                linkString.append("\t".repeat(tabsCount)).append(link);

                formattedSet.add(linkString.toString());
            } else {
                formattedSet.add(link);
            }
        });
        return formattedSet;
    }
}
