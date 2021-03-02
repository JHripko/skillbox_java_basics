import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    public List<String> imageSourcesList = new ArrayList<>();               //список ссылок на изображения
    public List<String> imageFileNamesList = new ArrayList<>();             //список имен файлов

    public Movements(String url) throws IOException {
        //получаем документ по ссылке
        Document doc = Jsoup.connect(url).get();
        //выбираем из документа все теги html с изображением любого расширения
        Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g)]");

        //добавляем ссылки изображений в список
        for (Element img : images) {
            imageSourcesList.add(img.attr("src"));
        }
    }

    //сохранение файлов
    public void saveImages() throws IOException {
        String outPath = "out/images/";                                     //папка с сохраненными файлами
        for (String src : imageSourcesList) {
            //убираем из ссылки все подпапки, оставляя имя файла
            String[] imageDir = src.split("[/\\\\]");
            String fileName = imageDir[imageDir.length - 1];
            imageFileNamesList.add(fileName);

            File imageFile = new File(outPath + fileName);
            //формируем url из строки ссылки на изображение
            URL url = new URL(src);
            //копируем файл по url используя библиотеку common-io apache
            FileUtils.copyURLToFile(url, imageFile);
        }
    }

    //отображение списка имен файлов из документа
    public void getImagesList() {
        System.out.println("Список файлов:\n");
        imageFileNamesList.forEach(System.out::println);
    }
}
