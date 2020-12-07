import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                fullNameFormatter(input);
            }
        }
    }

    //дополнительные методы
    //метод преобразования введенной строки в формат записи ФИО
    public static void fullNameFormatter(String input) {

        if (isCorrect(input)) {
            String[] arrayText = input.split(" ");

            System.out.println("Фамилия: " + arrayText[0]);
            System.out.println("Имя: " + arrayText[1]);
            System.out.println("Отчество: " + arrayText[2]);
        } else {
            System.out.println("Введенная строка не является ФИО");
        }
    }

    //метод определения содержит ли строка цифры
    public static boolean isNumber(String input) {
        String text = input
                .replaceAll("\\s+", "")
                .trim();

        if (text.matches("\\d+")) {
            return false;
        } else return true;
    }

    //метод проверки содержания трех слов
    public static boolean isThreeWords(String input) {
        String[] arrayText = input.split(" ");

        if (arrayText.length == 3) {
            return true;
        } else return false;
    }

    //метод проверки корректности записи
    public static boolean isCorrect(String input) {
        if (isNumber(input) && isThreeWords(input)) {
            return true;
        } else return false;
    }
}