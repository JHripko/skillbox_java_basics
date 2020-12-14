public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        //создание масива размером size x size
        char[][] arrayChars = new char[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (i == j || i + j == (size - 1)) {
                    arrayChars[i][j] = symbol;
                } else {
                    arrayChars[i][j] = ' ';
                }
            }
        }
        return arrayChars;
    }
}
