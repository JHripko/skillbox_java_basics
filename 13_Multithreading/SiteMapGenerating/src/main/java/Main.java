import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String url = "https://skillbox.ru/";
    public static void main(String[] args) throws IOException {
        SiteNode root = new SiteNode(url);
        Set<String> siteMap = new TreeSet<>(new ForkJoinPool().invoke(new SiteMapGenerator(root)));

        FileGenerator fileGenerator = new FileGenerator(siteMap);
        fileGenerator.getFile();
    }
}
