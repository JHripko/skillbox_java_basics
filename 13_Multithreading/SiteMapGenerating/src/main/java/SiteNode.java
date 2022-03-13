import java.io.IOException;
import java.util.Set;

public class SiteNode {
    public String url;

    public SiteNode(String url) {
        this.url = url;
    }

    public String getValue() {
        return url;
    }

    public Set<String> getChildren() throws IOException, InterruptedException {
        LinkParser linkParser = new LinkParser();
        Set<String> childLinks = linkParser.getLinks(url);
        SiteMapGenerator.uniqueLinks.addAll(childLinks);

        return childLinks;
    }
}
