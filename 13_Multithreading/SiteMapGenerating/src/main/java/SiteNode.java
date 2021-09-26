import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class SiteNode {
    public String url;

    public SiteNode(String url) {
        this.url = url;
    }

    public SiteNode(){}

    public String getValue() {
        return url;
    }

    public ArrayList<SiteNode> getChildren() {

        return null;
    }
}
