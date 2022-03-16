import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class SiteMapGenerator extends RecursiveTask<Set<String>> {
    private final SiteNode siteNode;
    public static volatile HashSet<String> uniqueLinks = new HashSet<>();  //Список уникальных ссылок

    public SiteMapGenerator(SiteNode siteNode) {
        this.siteNode = siteNode;
    }

    @Override
    protected Set<String> compute() {
        Set<String> siteMap = new TreeSet<>();    //Карта сайта
        List<SiteMapGenerator> taskList = new LinkedList<>();

        try {
            siteMap.add(siteNode.getValue());

            for (String child : siteNode.getChildren()) {
                SiteMapGenerator task = new SiteMapGenerator(new SiteNode(child));
                task.fork();
                taskList.add(task);
            }

            for (SiteMapGenerator task : taskList) {
                siteMap.addAll(task.join());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return siteMap;
    }
}
