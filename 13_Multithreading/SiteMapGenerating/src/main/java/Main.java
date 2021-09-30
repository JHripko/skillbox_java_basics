import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String url = "https://lenta.ru";
    public static void main(String[] args) throws IOException, InterruptedException {
//        SiteNode root = new SiteNode(url);
//        HashSet<String> siteMap = new ForkJoinPool().invoke(new SiteMapGenerator(root));
//
//        siteMap.forEach(System.out::println);

        LinkParser linkParser = new LinkParser(url);

        HashSet<String> links = new HashSet(linkParser.getLinks(url));

        links.forEach(System.out::println);
        System.out.println("Size: " + links.size());

    }
}
