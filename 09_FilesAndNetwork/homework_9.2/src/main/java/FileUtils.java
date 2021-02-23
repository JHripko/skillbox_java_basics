import java.io.*;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        File srcFile = new File(sourceDirectory);
        File destFile = new File(destinationDirectory);

        //если папка
        if (srcFile.isDirectory()) {
            //создаем директорию
            if (!destFile.exists()) {
                destFile.mkdir();
            }

            String[] children = srcFile.list();
            for (int i = 0; i < children.length; i++) {
                File srcFolder = new File(srcFile, children[i]);
                File destFolder = new File(destFile, children[i]);

                //рекурсивно вызываем метод для перехода к следующм папкам
                copyFolder(srcFolder.getPath(), destFolder.getPath());
            }
        } else {
            //если файл
            try {
                //создаем потоки
                InputStream inputStream = new FileInputStream(srcFile);
                OutputStream outputStream = new FileOutputStream(destFile);

                //копируем побитово файл
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

                inputStream.close();
                outputStream.close();
            }
            catch (IOException exception) {
                exception.getStackTrace();
                System.out.println("Операция не выполнена");
            }
        }
    }
}
