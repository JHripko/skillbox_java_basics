import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static int newWidth = 400;

    public static void main(String[] args) {
//        String srcFolder = "/users/sortedmap/Desktop/src";
//        String dstFolder = "/users/sortedmap/Desktop/dst";
        String srcFolder = "D:\\Java\\SkillBox\\ImageResizer\\src";
        String dstFolder = "D:\\Java\\SkillBox\\ImageResizer\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        //получаем кол-во доступных ядер
        int coresCount = Runtime.getRuntime().availableProcessors();
        System.out.println("cores count: " + coresCount);

        //часть массива
        int part = files.length / coresCount;

        //в цикле создаем кол-во потоков в соотв. с кол-вом доступных ядер процессора
        for (int i = 1; i <= coresCount - 1; i++) {
            File[] files1 = new File[part];
            System.arraycopy(files, 0, files1, 0, files1.length);
            ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start, i);
            new Thread(resizer1).start();

            File[] files2 = new File[files.length - part];
            System.arraycopy(files, part, files2, 0, files2.length);
            files = files2;
        }

        ImageResizer resizer = new ImageResizer(files, newWidth, dstFolder, start, coresCount);
        new Thread(resizer).start();
    }
}
