import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable{
    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;
    private int id;

    public ImageResizer(File[] files, int newWidth, String dstFolder, long start, int id) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("start thread " + id);
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                //создаем новое изображение с измененным размером используя ImgScalr
                BufferedImage newImage = Scalr.resize(image, newWidth);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Thread " + id + " finished after start: " + (System.currentTimeMillis() - start + " ms"));
    }
}
