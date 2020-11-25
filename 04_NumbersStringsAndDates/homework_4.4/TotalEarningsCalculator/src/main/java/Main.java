public class Main {
    public static void main(String[] args) {

        int beginIndex = 0;   //начальный индекс символа в строке
        int sum = 0;          //начальное значение суммы зарплат

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String myText = text; //создаем копию текста

        for (int i = 0; i <= (text.length()); i++) {

            //проверяем наличие пробелов в строке (в противном случае возвращает -1)
            if (myText.indexOf(' ') >= 0) {

                int spaceIndex = myText.indexOf(' ');

                //выделяем слово в строке
                String word = myText.substring(beginIndex, spaceIndex);

                //отделяем от проверенной строки выделенное слово
                myText = myText.substring(spaceIndex + 1);

                //помещаем первый символ слова в переменную
                char c = word.charAt(0);

                //проверяем является ли первый символ числом
                if (Character.isDigit(c)) {
                    sum += Integer.parseInt(word);    //преобразуем в int и прибавляем к сумме зарплат
                }
            } else {
                break;
            }
        }

        System.out.println(sum);
    }
}