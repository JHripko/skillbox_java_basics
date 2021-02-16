import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long length = 0;                            //размер файла
        File folder = new File(path);               //инициализируем переменную типа File
        File[] files = folder.listFiles();          //создаем массив из файлов в текущей дериктории

        try {
            for (File file : files) {
                //проверяем, если текущий элемент массива является файлом то вычисляем его размер
                if (file.isFile()) {
                    length += file.length();
                    //если текущий элемент массива является папкой то рекурсивно вызываем метод и передаем в него
                    //путь к текущей папки и вычисляем размеры файлов в ней
                } else {
                    length += calculateFolderSize(file.getPath());
                }
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
            System.out.println(Arrays.toString(exception.getStackTrace()));
        }

        return length;
    }

    //дополнительный метод
    //метод форматирования размера директории
    public static String formatSize(long size) {
        String unit = "байт";
        if (size > 1024) {
            size = size / 1024;
            unit = "Кб";
        }

        if (size > 1024) {
            size = size / 1024;
            unit = "Мб";
        }

        if (size > 1024) {
            size = size / 1024;
            unit = "Гб";
        }

        return " " + size + " " + unit;
    }
}
