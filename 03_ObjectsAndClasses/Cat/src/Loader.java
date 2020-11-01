import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        String menu = "main";

        Cat murka = new Cat();
        Cat boris = new Cat();
        Cat vasya = new Cat();
        Cat tomas = new Cat();
        Cat barsik = new Cat();
        Cat leo = new Cat();

        Cat cat = new Cat();

        while (true) {
            //вывод главного меню
            while (menu.equals("main")){
                mainMenu();

                //Ввод буквы пользователем
                Scanner in = new Scanner(System.in);
                menu = in.nextLine();
            }

            //вывод работы к урокам 1-2
            while (menu.equals("a")) {
                firstSelect();

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
                    barsik.drink(150.00);

                    System.out.println("Барсик напился:" +
                            "\nБарсик, вес: " + barsik.getWeight());
                }

                //5 - Сводить Барсика в туалет
                if (answer == 5) {
                    barsik.pee();

                    System.out.println("Успешно, вес Барсика: " + barsik.getWeight());
                }

                //6 - Покормить Леопольда и показать сколько он съел еды
                if (answer == 6) {
                    leo.feed(150.00);

                    System.out.println("Леопольд поел, вес еды: " + leo.weightOfFood());
                }

                //7 - Показать статус кошек
                if (answer == 7) {
                    allStatus(murka, boris, vasya, tomas, barsik, leo);
                }

                //Выйти в главное меню
                if (answer == 0) {
                    menu = "main";
                }
            }

            //вывод работы к уроку 3
            while (menu.equals("b")) {
                secondSelect();

                //получение действия от пользователя
                int answer = (new Scanner(System.in)).nextInt();

                //1 - Создать кошку
                if (answer == 1) {
                    cat = new Cat();
                    Cat.increaseCount();
                    System.out.println("Кошка создана. Вес кошки: " + cat.getWeight());
                }

                //2 - Перекормить кошку (взорвать)
                if (answer == 2) {
                    if (Cat.getCount() > 0 && cat.isAlive()) {
                        while (cat.isAlive()) {
                            cat.feed(1000.0);
                            System.out.println("Вес: " + cat.getWeight());
                        }

                        System.out.println(cat.getStatus());
                    } else {
                        System.out.println("Кошка умерла или не создана!");
                    }
                }

                //3 - Напоить кошку
                if (answer == 3) {
                    if (Cat.getCount() > 0 && cat.isAlive()) {
                        cat.drink(200.0);
                        System.out.println("Кошка напилась, вес: " + cat.getWeight());
                    } else {
                        System.out.println("Кошка умерла или не создана!");
                    }
                }

                //0 - Выйти в главное меню
                if (answer == 0) {
                    menu = "main";
                }
            }

            //вывод работы к уроку 4
            while (menu.equals("c")) {
                thirdSelect();

                //получение действия от пользователя
                int answer = (new Scanner(System.in)).nextInt();

                //1 - Создать кошку и показать ее цвет
                if (answer == 1) {
                    cat = new Cat();
                    System.out.println("Кошка создана. Цвет кошки: " + cat.getColor());
                }

                if (answer == 0) {
                    menu = "main";
                }
            }

            //вывод работы к уроку 5
            while (menu.equals("d")) {
                fourthSelect();

                //получение действия от пользователя
                int answer = (new Scanner(System.in)).nextInt();

                //1 - Создать кошку весом 1100.0
                if (answer == 1) {
                    Cat kitten = getKitten("Мурка", 1100.0);
                    System.out.println("Кошка " + kitten.getName() + " создана. Вес: " + kitten.getWeight());
                }

                //2 - Создать трех кошек
                if (answer == 2) {
                    Cat kittenTom = getKitten("Том", 1500.0);
                    Cat kittenBarsik = getKitten("Барсик", 2000.0);
                    Cat kittenLeo = getKitten("Леопольд", 1500.0);

                    System.out.println("Кошки созданы:" +
                            "\n" + kittenTom.getName() + " вес: " + kittenTom.getWeight() +
                            "\n" + kittenBarsik.getName() + " вес: " + kittenBarsik.getWeight() +
                            "\n" + kittenLeo.getName() + " вес: " + kittenLeo.getWeight());
                }

                if (answer == 0) {
                    menu = "main";
                }
            }

            //вывод работы к уроку 6
            while (menu.equals("e")) {
                fifthSelect();

                //получение действия от пользователя
                int answer = (new Scanner(System.in)).nextInt();

                //1 - Создать кошку и задать ей цвет
                if (answer == 1) {
                    cat = new Cat();
                    cat.setColor(Color.WHITE);
                }

                //2 - Отобразить цвет кошки
                if (answer == 2) {
                    System.out.println("Цвет кошки: " + cat.getColor());
                }

                //0 - Выйти в главное меню
                if (answer == 0) {
                    menu = "main";
                }
            }

            //вывод работы к уроку 7
            while (menu.equals("f")) {
                sixthSelect();

                //получение действия от пользователя
                int answer = (new Scanner(System.in)).nextInt();

                //1 - Создать и показать клонированный объект
                if (answer == 1) {
                    leo.setName("Леопольд");
                    setCopy(leo, cat);
                }

                if (answer == 2) {
                    leo.setColor(Color.GINGER);
                    setCopy(leo, cat);
                }

                if (answer == 0) {
                    menu = "main";
                }
            }
        }
    }

    //метод вывода статуса кошек
    private static void allStatus(Cat murka, Cat boris, Cat vasya, Cat tomas, Cat barsik, Cat leo) {
        System.out.println("Список подопытных:"
                + "\nМурка, вес: " + murka.getWeight() + " " + murka.getStatus()
                + "\nБорис, вес: " + boris.getWeight() + " " + boris.getStatus()
                + "\nВаська, вес:" + vasya.getWeight() + " " + vasya.getStatus()
                + "\nТом, вес: " + tomas.getWeight() + " " + tomas.getStatus()
                + "\nБарсик, вес: " + barsik.getWeight() + " " + barsik.getStatus()
                + "\nЛеопольд, вес: " + leo.getWeight() + " " + leo.getStatus());
        System.out.println("\n=================================\n");
    }

    //метод генерации котенка
    private static Cat getKitten(String name, double weight) {
        Cat cat = new Cat(name, weight);
        return cat;
    }

    //метод создания копии кошки
    public static void setCopy(Cat origin, Cat copy) {
        copy = new Cat(origin.getName(), origin.getWeight());

        System.out.println("Исходная кошка:" +
                "\n" + origin.getName() + ", вес: " + origin.getWeight() + ", цвет: " + origin.getColor() +

                "\n\nКопия кошки:" +
                "\n" + copy.getName() + ", вес: " + copy.getWeight() + ", цвет: " + origin.getColor());
    }

    //Главное меню
    private static void mainMenu() {
        System.out.println("---Главное меню---" +
                "\nВыберите букву для перехода к заданию" +
                "\na - Задания к урокам 1-2" +
                "\nb - Задание к уроку 3" +
                "\nc - Задание к уроку 4" +
                "\nd - Задание к уроку 5" +
                "\ne - Задание к уроку 6" +
                "\nf - Задание к уроку 7");
    }

    //Отображение содержимого подпунтктов меню
    //Задания к урокам 1-2
    private static void firstSelect() {
        System.out.println("Задания к урокам 1-2:" +
                "\nЧто делаем с кошками?" +
                "\n1 - Покормить Мурку и Бориса" +
                "\n2 - Перекормить Ваську" +
                "\n3 - Замяукать Тома" +
                "\n4 - Напоить Барсика" +
                "\n5 - Сводить Барсика в туалет" +
                "\n6 - Покормить Леопольда и показать сколько всего он съел еды" +

                "\n\n7 - Показать статус кошек" +

                "\n\n0 - Выйти в главное меню");
    }

    //Задание к уроку 3
    private static void secondSelect() {
        System.out.println("Задание к уроку 3:" +
                "\nКол-во кошек: " + Cat.getCount() +
                "\n1 - Создать кошку" +
                "\n2 - Перекормить кошку (взорвать)" +
                "\n3 - Напоить кошку" +

                "\n\n0 - Выйти в главное меню");
    }

    //Задание к уроку 4
    private static void thirdSelect() {
        System.out.println("Задание к уроку 4:" +
                "\n1 - Создать кошку и показать ее цвет" +

                "\n\n0 - Выйти в главное меню");
    }

    //Задание к уроку 5
    private static void fourthSelect() {
        System.out.println("Задание к уроку 5:" +
                "\n1 - Создать кошку, весом 1100.0" +
                "\n2 - Создать трех кошек" +

                "\n\n0 - Выйти в главное меню");
    }

    //Задание к уроку 6
    private static void fifthSelect() {
        System.out.println("Задание к уроку 6" +
                "\n1 - Создать кошку и задать ей цвет" +
                "\n2 - Отобразить цвет кошки" +

                "\n\n0 - Выйти в главное меню");
    }

    //Задание к уроку 7
    private static void sixthSelect() {
        System.out.println("Задание к уроку 7" +
                "\n1 - Создать и показать скопированный объект" +
                "\n2 - Поменять цвет исходной кошки и вывести объекты" +

                "\n\n0 - Выход в главное меню");
    }
}
