import java.util.Scanner;

public class Main {
    public static boolean program = true;

    public static void main(String[] args) throws Exception {
        while (program) {
            System.out.println("Введите путь до папки:");
            Scanner in = new Scanner(System.in);
            String path = in.nextLine().trim();

            long size = FileUtils.calculateFolderSize(path);
            System.out.println(FileUtils.formatSize(size));
        }
    }
}
