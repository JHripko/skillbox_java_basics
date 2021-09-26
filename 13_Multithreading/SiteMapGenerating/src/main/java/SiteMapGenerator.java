import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SiteMapGenerator extends RecursiveTask<HashSet<String>> {
    private SiteNode siteNode;

    public SiteMapGenerator(SiteNode siteNode) {
        this.siteNode = siteNode;
    }

    @Override
    protected HashSet<String> compute() {
//        HashSet<String> siteMap = new HashSet<>();
//        siteMap.add(siteNode.getValue());
//        List<SiteMapGenerator> taskList = new ArrayList<>();
//
//        try {
//            for (String child : siteNode.getChildren()) {
//                SiteMapGenerator task = new SiteMapGenerator(new SiteNode(child));
//                task.fork();
//                taskList.add(task);
//            }
//
//            for (SiteMapGenerator task : taskList) {
//                siteMap.addAll(task.join());
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
