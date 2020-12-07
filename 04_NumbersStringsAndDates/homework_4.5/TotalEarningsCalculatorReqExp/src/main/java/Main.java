public class Main {

    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(calculateSalarySum(text));
    }

    public static int calculateSalarySum(String text){
        //переменная суммы зарплат
        Integer sum = 0;

        //создаем переменную, содержащую строку из зарплат через пробел
        String selection = text.replaceAll("[^0-9]", " ");

        //создаем массив строк с зарплатами
        String[] salaries = selection.split("\\s+");

        /*
            в случае, если первый элемент массива после метода split будет пустой строкой,
            преобразовать этот элемент к типу Integer не получится, поэтому проводим проверку каждого
            элемента массива salaries[]
        */
        for (int i = 0; i < salaries.length; i++) {

            if (!salaries[i].equals("")) {
                sum += Integer.parseInt(salaries[i]);
            }
        }

        return sum;
    }

}