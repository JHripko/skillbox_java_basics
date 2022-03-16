import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class FileGenerator {
    public Set<String> siteMap;

    public FileGenerator(Set<String> siteMap) {
        this.siteMap = siteMap;
    }

    public void getFile() throws IOException {
        SiteMapFormatter siteMapFormatter = new SiteMapFormatter(siteMap);
        //создаем файл
        Path file = Files.createFile(Paths.get("file/sitemap.txt"));

        //форматирование списка ссылок (с учетом вложенности)
        Set<String> lines = new LinkedHashSet<>(siteMapFormatter.getFormattedSet());

        //записываем строки в файл
        Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        lines.forEach(System.out::println);
        System.out.println("\nКол-во ссылок: " + lines.size() +
                            "\nФайл сохранен в " + file.toRealPath());
    }
}
