import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String line = "Каждый охотник желает знать, где сидит фазан";
        //создаем массив из слов строки
        String[] strings = line.split(",?\\s+");

        //создаем массив, равный "перевернутому" массиву strings
        String[] reverseStrings = ReverseArray.reverse(strings);

        //преобразуем в строку
        String arrText = Arrays.toString(reverseStrings);

        System.out.print(arrText);
    }

}
