import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class FileGenerator {
    public Set<String> siteMap;

    public FileGenerator(Set<String> siteMap) {
        this.siteMap = siteMap;
    }

    public void getFile() throws IOException {
        SiteMapFormatter siteMapFormatter = new SiteMapFormatter(siteMap);
        Path file = Files.createFile(Paths.get("file/sitemap.txt"));

        Set<String> lines = new TreeSet<>(siteMapFormatter.getFormattedSet());

        Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        lines.forEach(System.out::println);
        System.out.println("\nКол-во ссылок: " + lines.size() +
                            "\nФайл сохранен в " + file.toRealPath());
    }
}
