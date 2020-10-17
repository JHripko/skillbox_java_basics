import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        Cat murka = new Cat();
        Cat boris = new Cat();
        Cat vasya = new Cat();
        Cat tomas = new Cat();
        Cat barsik = new Cat();

        //выводим список кошек
        allStatus(murka, boris, vasya, tomas, barsik);

        while (true) {
            //выводим меню действий
            System.out.println("\nЧто делаем с кошками?" +
                    "\n1 - Покормить Мурку и Бориса" +
                    "\n2 - Перекормить Ваську" +
                    "\n3 - Замяукать Тома" +
                    "\n4 - Напоить Барсика" +
                    "\n\n0 - Показать статус кошек");

            //получение действия от пользователя
            int answer = (new Scanner(System.in)).nextInt();

            //1 - Покормить Мурку и Бориса
            if (answer == 1) {
                murka.feed(500.00);
                boris.feed(700.00);

                System.out.println("Кошки покормлены и потолстели:" +
                                    "\nМурка, вес: " + murka.getWeight() +
                                    "\nБорис, вес: " + boris.getWeight());
            }

            //2 - Перекормить Ваську
            if (answer == 2) {
                while (!vasya.getStatus().equals("Exploded")) {
                    vasya.feed(1000.00);

                    System.out.println("Васька " + vasya.getStatus());
                }
            }

            //3 - Замяукать Тома
            if (answer == 3) {
                while (!tomas.getStatus().equals("Dead")) {
                    tomas.meow();

                    System.out.println("Том " + tomas.getStatus());
                }
            }

            //4 - Напоить Барсика
            if (answer == 4) {
                barsik.drink(100.00);

                System.out.println("Барсик напился:" +
                                    "\nБарсик, вес: " + barsik.getWeight());
            }

            //0 - Показать статус кошек
            if (answer == 0) {
                allStatus(murka, boris, vasya, tomas, barsik);
            }
        }
    }

    //метод вывода статуса кошек
    private static void allStatus(Cat murka, Cat boris, Cat vasya, Cat tomas, Cat barsik) {
        System.out.println("Список подопытных:"
                + "\nМурка, вес: " + murka.getWeight() + " " + murka.getStatus()
                + "\nБорис, вес: " + boris.getWeight() + " " + boris.getStatus()
                + "\nВаська, вес:" + vasya.getWeight() + " " + vasya.getStatus()
                + "\nТом, вес: " + tomas.getWeight() + " " + tomas.getStatus()
                + "\nБарсик, вес: " + barsik.getWeight() + " " + barsik.getStatus());
        System.out.println("\n=================================\n");
    }
}
