import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String command = "";         //переменная команды (LIST, ADD)
    static String email = "";           //переменная email адреса

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String WRONG_COMMAND_ANSWER = "Команда не распознана!";

    private static EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            inputParser(input);

            resetAll();
        }
    }


    //дополнительные методы
    //разделение команды
    public static void inputParser(String input) {
        input = input.trim();

        //создаем массив элементов из строки
        String[] commands = input.split("\\s");

        //первый элемент по порядку должен быть командой
        command = commands[0];

        //проверяем на наличие текста после команды
        if (commands.length == 2) {
            email = commands[1];
            commandDefinition(command);
        } else if (commands.length == 1) {
            commandDefinition(command);
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }

    //определение команды и исполнение
    public static void commandDefinition(String command) {
        switch (command) {
            case "ADD":
                emailList.add(email);
                break;

            case "LIST":
                getList();
                break;

            default:
                System.out.println(WRONG_COMMAND_ANSWER);
                break;
        }
    }

    //отображение списка
    public static void getList() {
        List<String> myList = new LinkedList<>(emailList.getSortedEmails());

        for (String emailAddress : myList) {
            System.out.println(emailAddress);
        }
    }

    //сброс значений
    public static void resetAll() {
        command = "";
        email = "";
    }
}
