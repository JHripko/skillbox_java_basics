import java.util.Scanner;

public class Main {

    private static final String FORMAT_ERROR = "Неверный формат номера";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                phoneFormatter(input);
            }
        }
    }

    //дополнительные методы
    //метод форматирования
    public static void phoneFormatter(String input) {
        String phoneNumber = input.replaceAll("[^0-9]", "");

        phoneNumber = lengthOfNumber(phoneNumber);
        System.out.println(phoneNumber);
    }

    //проверка количества цифр
    public static String lengthOfNumber(String phoneNumber) {
        if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
            phoneNumber = FORMAT_ERROR;
        } else {
            if (phoneNumber.length() == 10) {
                phoneNumber = "7" + phoneNumber;
            } else {
                phoneNumber = digitReplacement(phoneNumber);
            }
        }
        return phoneNumber;
    }

    //замена первой восьмерки на семерку или вывод ошибки если номер начинается с другой цифры
    public static String digitReplacement(String phoneNumber) {
        if (phoneNumber.charAt(0) == '8') {
            StringBuilder str = new StringBuilder(phoneNumber);
            str.setCharAt(0, '7');
            phoneNumber = str.toString();
        } else {
            if (phoneNumber.charAt(0) != '7') {
                phoneNumber = FORMAT_ERROR;
            }
        }
        return phoneNumber;
    }

}
