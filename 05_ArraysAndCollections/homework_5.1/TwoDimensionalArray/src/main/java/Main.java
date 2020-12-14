import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] result = TwoDimensionalArray.getTwoDimensionalArray(7);

        //вывод в консоль
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
