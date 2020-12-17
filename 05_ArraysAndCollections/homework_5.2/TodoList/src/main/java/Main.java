import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String command = "";         //переменная команды (LIST, ADD, EDIT, DELETE)
    static String todoText = "";        //переменная текста задачи
    static int todoIndex = 0;           //переменная пункта списка дел
    static boolean hasIndex = false;    //переменная наличия пункта списка в команде
    static boolean program = true;      //переменная активности программы (если false - выход из программы)

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        while (program) {
            //пользователь вводит с клавиатуры текст
            Scanner in = new Scanner(System.in);

            //передаем текст на распределение на команду - индекс - текст
            scannerParser(in);
            //сбрасываем значения переменных
            resetAll();
        }
    }



    //дополнительные методы:
    //разделение команды индекса и текста
    public static void scannerParser(Scanner in) {
        //создаем переменную со значением строки Scanner.in
        String input = in.nextLine().trim();
        //разделяем строку на массив элементов
        String[] commands = input.split("\\s");

        //первый элемент по порядку должен быть командой
        command = commands[0];
        if (commands.length > 1) {
            //проверяем на наличие текста после команды и отправляем массив методу который проверяет наличие индекса
            getIndex(commands);
        }
        //передаем команду на исполнение
        commandDefinition(command);
    }

    //определение и исполнение команды
    public static void commandDefinition(String command) {
        switch (command) {
            case "LIST":
                getEmptyTodoListError();
                getToDoList();
                break;

            case "ADD":
                hasText(todoText);
                break;

            case "EDIT":
                todoList.edit(todoText, todoIndex);
                break;

            case "DELETE":
                getIndexToDelete();
                break;

            case "EXIT":
                exit();
                break;

            default:
                getCommandError();
        }
    }

    //отображение списка задач
    public static void getToDoList() {
        //получаем список методом getTodos класса TodoList
        ArrayList<String> myList = todoList.getTodos();

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + " - " + myList.get(i));
        }
    }

    //проверка на содержание индекса и сборка текста
    public static void getIndex(String[] commands) {
        //создаем переменную типа StringBuilder в которую будем собирать строку из элементов массива
        StringBuilder text = new StringBuilder();

        //проверяем является ли элемент массива числом
        if (commands[1].matches("[0-9]+")) {
            todoIndex = Integer.parseInt(commands[1]);
            hasIndex = true;

            for (int i = 2; i< commands.length; i++) {
                text.append(commands[i]).append(" ");
            }
        } else {
            //сборка текста из остальных элементов массива, если отсутствует индекс
            for (int i = 1; i < commands.length; i++) {
                text.append(commands[i]).append(" ");
            }
        }
        todoText = text.toString().trim();
    }

    //проверка на наличие индекса для удаления
    public static void getIndexToDelete() {
        if (!hasIndex) {
            getNoIndexError();
        } else {
            todoList.delete(todoIndex);
        }
    }

    //проверка на наличие текста
    public static void hasText(String todoText) {
        //если переменная содержит пустую строку
        if (todoText.equals("")) {
            //выдать ошибку об отсутствии текста задачи
            getEmptyTextError();
        } else {
            //если в команде содержится индекс
            if (hasIndex) {
                //передается команда с индексом
                todoList.add(todoIndex, todoText);
            } else {
                //если индекс не передавался то добавить текст дела в конец списка
                todoList.add(todoText);
            }
        }
    }

    //сброс содержимого
    public static void resetAll() {
        command = "";
        todoIndex = 0;
        todoText = "";
        hasIndex = false;
    }

    //выход из приложения
    public static void exit() {
        program = false;
    }


    //ошибки:
    //отображение ошибки команды
    public static void getCommandError() {
        System.out.println("Команда не распознана! Пожалуйста используйте команды:" +
                        "\nLIST - для отображения списка задач" +
                        "\nADD - для добавления задачи" +
                        "\nEDIT *номер задачи* - для редактирования задачи" +
                        "\nDELETE *номер задачи* - для удаления задачи" +
                        "\nEXIT - для выхода из программы");
    }

    //отображение ошибки отсутствия текста
    public static void getEmptyTextError() {
        System.out.println("Введите, что нужно сделать!");
    }

    //отображение ошибки отсутствия пункта
    public static void getNoIndexError() {
        System.out.println("Не указан пункт списка!");
    }

    //отображение ошибки отсутствия списка
    public static void getEmptyTodoListError() {
        if (todoList.myTodoList.size() == 0) {
            System.out.println("Создайте список дел, добавив запись!");
        }
    }
}
