import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        for (int regionCode = 1; regionCode < 100; regionCode++) {
            //создаем файл для каждого региона
            PrintWriter writer = new PrintWriter("res/numbers_"
                    + padNumber(regionCode, 3) + ".txt");
            //вызываем в отдельном потоке генератор номеров
            Generator generator = new Generator(writer, regionCode, letters);
            generator.start();
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }

        return numberStr;
    }

    //генератор номеров
    public static class Generator extends Thread {
        public Generator(PrintWriter writer, int regionCode, char[] letters) {
            StringBuilder carNumber = new StringBuilder();

            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            carNumber.append(firstLetter)
                                    .append(padNumber(number, 3))
                                    .append(secondLetter)
                                    .append(thirdLetter)
                                    .append(padNumber(regionCode, 3))
                                    .append("\n");
                        }
                    }
                }
            }
            writer.write(carNumber.toString());
            writer.flush();
            writer.close();
        }
    }
}
