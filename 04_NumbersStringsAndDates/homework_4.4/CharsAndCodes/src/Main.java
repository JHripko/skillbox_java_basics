public class Main {
    public static void main(String[] args) {

        System.out.println("Ангийский алфавит:");
        for (char i = 'A', j = 'a'; i <= 'Z' && j <= 'z'; i++, j++) {
            int uppercaseCode = i;
            int lowercaseCode = j;
            System.out.println(i + " code: " + uppercaseCode + "\t" + j + " code: " + lowercaseCode);
        }

        System.out.println("\nРусский алфавит:");
        for (char i = 'А', j = 'а'; i <= 'Я' && j <= 'я'; i++, j++) {
            int uppercaseCode = i;
            int lowercaseCode = j;
            System.out.println(i + " code: " + uppercaseCode + "\t" + j + " code: " + lowercaseCode);
        }
    }
}
