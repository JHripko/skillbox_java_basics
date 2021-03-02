import java.io.IOException;

public class Main {

    public static final String URL = "https://lenta.ru/";               //ссылка на сайт который парсим

    public static void main(String[] args) throws IOException {
        Movements movements = new Movements(URL);
        movements.saveImages();
        movements.getImagesList();
    }
}
