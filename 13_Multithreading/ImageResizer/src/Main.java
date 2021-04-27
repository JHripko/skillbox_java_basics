import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static int newWidth = 400;

    public static void main(String[] args) {
        String srcFolder = "/users/sortedmap/Desktop/src";
        String dstFolder = "/users/sortedmap/Desktop/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        //получаем кол-во доступных ядер
        int coresCount = Runtime.getRuntime().availableProcessors();
        System.out.println("cores count: " + coresCount);

        for (int i = 0; i < coresCount; i++) {
            int middle = files.length / 2;
            File[] files1 = new File[middle];
            System.arraycopy(files, 0, files1, 0, files1.length);
            ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
            new Thread(resizer1).start();

            File[] files2 = new File[files.length - middle];
            System.arraycopy(files, middle, files2, 0, files.length);
            ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
            new Thread(resizer2).start();
        }
    }
}
