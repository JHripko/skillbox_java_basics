import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Cat cat = new Cat();

        while (true) {
            //отобразить меню
            System.out.println("Выберите действие:");
            System.out.println("\n1 - Создать кошку" +
                                "\n2 - Показать вес кошки" +
                                "\n3 - Покормить кошку" +
                                "\n4 - Напоить кошку" +
                                "\n\n0 - Состояние кошки");

            //получение действия
            int answer = new Scanner(System.in).nextInt();

            //действия:
            //1 - Создать кошку
            if (answer == 1) {
                Cat.increaseCount();
                Cat.getCount();
            }

            //2 - Показать вес кошки
            if (answer == 2) {
                if (Cat.isCount()) {
                    System.out.println("Вес кошки: " + cat.getWeight());
                } else {
                    cat.CatCreatedError();
                }
            }

            //3 - Покормить кошку
            if (answer == 3) {
                if (Cat.isCount()) {
                    cat.feed(500.0);
                    System.out.println("Кошка покормлена! " + cat.getStatus());
                } else {
                    cat.CatCreatedError();
                }
            }

            //4 - Напоить кошку
            if (answer == 4) {
                if (Cat.isCount()) {
                    cat.drink(200.0);
                    System.out.println("Кошка напоена! " + cat.getStatus());
                } else {
                    cat.CatCreatedError();
                }
            }

            //0 - Состояние кошки
            if (answer == 0) {
                if (Cat.isCount()) {
                    System.out.println(cat.getStatus());
                } else {
                    cat.CatCreatedError();
                }
            }
        }
    }
}
