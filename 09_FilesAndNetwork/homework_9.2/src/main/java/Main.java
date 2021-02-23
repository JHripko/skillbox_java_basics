import java.util.Scanner;

public class Main {
    private static boolean program = true;
    private static final String PATH_FORMAT_ERROR = "Неверный формат пути";
    private static final String COMMAND_ERROR = "Команда не распознана";

    public static void main(String[] args) {
        while (program) {
            System.out.println("Введите команду (help для справки, exit для выхода):");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().trim();

            getCommand(input);
        }
    }


    //дополнительные методы
    //определение команды
    public static void getCommand(String input) {
        String[] data = input.split("\\s+");

        if (data.length != 0) {
            switch (data[0]) {
                case "cp":
                    getPaths(data);
                    break;

                case "help":
                    getHelp();
                    break;

                case "exit":
                    program = false;
                    break;

                default:
                    System.out.println(COMMAND_ERROR);
                    break;
            }
        }
    }

    //передаем пути папок
    public static void getPaths(String[] data) {
        if (isContainsPaths(data)) {
            String sourceDirectory = data[1];
            String destinationDirectory = data[2];
            FileUtils.copyFolder(sourceDirectory, destinationDirectory);
        } else {
            System.out.println(PATH_FORMAT_ERROR);
        }
    }

    //проверяем наличие пути в команде
    public static boolean isContainsPaths(String[] data) {
        return data.length == 3 && data[1] != null && data[2] != null;
    }

    //отображение справки
    public static void getHelp() {
        System.out.println("Формат команды:");
        System.out.println("cp SOURCE_PATH DESTINATION_PATH");
    }
}
