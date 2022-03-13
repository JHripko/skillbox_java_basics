import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String url = "https://skillbox.ru/";
    public static void main(String[] args) {
        SiteNode root = new SiteNode(url);
        Set<String> siteMap = new HashSet<>(new ForkJoinPool().invoke(new SiteMapGenerator(root)));

        siteMap.forEach(System.out::println);
    }
}
