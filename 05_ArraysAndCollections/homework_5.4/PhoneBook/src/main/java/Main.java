import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static String name = "";
    public static String phone = "";
    public static boolean program = true;

    public static final String WRONG_INPUT_FORMAT = "Неправильный формат ввода!";
    public static final String NO_NAME_IN_PHONEBOOK = "Такого имени нет в телефонной книге";
    public static final String NO_PHONE_IN_PHONEBOOK = "Такого номера нет в телефонной книге";

    public static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {

        while (program) {
            System.out.println("Введите команду, имя или номер");
            Scanner input = new Scanner(System.in);

            getInputData(input);
            resetAll();
        }
    }


    //дополнительные методы
    //метод определения данных (Команда, Имя или Номер)
    public static void getInputData(Scanner input) {
        String data = input.nextLine().trim();

        if (!data.isEmpty()) {
            if (data.equals("LIST")) {
                getPhoneBook();
            } else if (data.equals("0")) {
                program = false;
            } else if (data.matches("[0-9]+")) {
                phone = data;
                setRequestByPhone(phone);
            } else {
                name = data;
                setRequestByName(name);
            }
        } else {
            System.out.println(WRONG_INPUT_FORMAT);
        }
    }

    //отображение списка контактов
    public static void getPhoneBook() {
        TreeSet<String> contacts = (TreeSet<String>) phoneBook.getAllContacts();
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }

    //отправка запроса по номеру телефона
    public static void setRequestByPhone(String phone) {
        String response = phoneBook.getNameByPhone(phone);

        if (response.isEmpty()) {
            System.out.println(NO_PHONE_IN_PHONEBOOK);
            System.out.println("Введите имя абонента для номера \"" + phone + "\"");
            Scanner in = new Scanner(System.in);

            name = in.nextLine().trim();
            phoneBook.addContact(phone, name);
        } else {
            System.out.println(response);
        }
    }

    //отправка запроса по имени
    public static void setRequestByName(String name) {
        TreeSet<String> contacts = (TreeSet<String>) phoneBook.getPhonesByName(name);

        if (contacts.isEmpty()) {
            System.out.println(NO_NAME_IN_PHONEBOOK);
            System.out.println("Введите номер абонента \"" + name + "\"");
            Scanner in = new Scanner(System.in);

            phone = in.nextLine().trim();
            phoneBook.addContact(phone, name);
        } else {
            for (String contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    //сброс содержимого
    public static void resetAll() {
        name = "";
        phone = "";
    }
}
