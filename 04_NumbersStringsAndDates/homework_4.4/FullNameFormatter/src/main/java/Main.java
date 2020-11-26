import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int beginIndex = 0;         //начальный индекс
        int spacesCount = 0;        //счетчик пробелов

        boolean isCorrect = true;   //переменная корректной записи

        String firstName;           //имя
        String secondName;          //отчество
        String lastName;            //фамилия

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            //создаем копию текста
            String text = input;

            for (int i = 0; i <= input.length(); i++) {

                //если в копии текста нет пробелов то вернется -1
                if (text.indexOf(' ') >= 0) {
                    int spaceIndex = text.indexOf(' ');   //индекс пробела

                    //выделяем первое слово в текущей строке
                    String word = text.substring(beginIndex, spaceIndex);
                    char c = word.charAt(i);

                    //проверяем введены ли числа
                    if (Character.isDigit(c)) {
                        isCorrect = false;
                        break;
                    }

                    //отделяем предыдущее слово
                    text = text.substring(spaceIndex + 1);

                    spacesCount++;    //добавляем 1 к счетчику пробелов

                } else {
                    break;
                }
            }

            //если в тексте пробелов больше 2, то запись некорректна
            if (spacesCount != 2) {
                isCorrect = false;
                getError();
                break;
            }

            //если введены 3 слова через пробел, то записываем их в переменные
            if (isCorrect) {
                int firstSpace = input.indexOf(' ');
                int secondSpace = input.lastIndexOf(' ');

                lastName = input.substring(beginIndex, firstSpace);
                secondName = input.substring(secondSpace, input.length());
                firstName = input.substring(firstSpace, secondSpace);

                System.out.println("Фамилия: " + lastName);
                System.out.println("Имя: " + firstName.trim());
                System.out.println("Отчество: " + secondName.trim());

            } else {
                getError();
            }
        }
    }

    //вспомогательные методы
    //ошибка
    public static void getError() {
        System.out.println("Введенная строка не является ФИО");
    }
}