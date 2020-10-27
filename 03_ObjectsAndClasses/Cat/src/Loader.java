
public class Loader {
    public static Cat vasya = new Cat();
    public static Cat murka = new Cat();
    public static Cat boris = new Cat();

    public static void main(String[] args) {

        vasya.setKitten("Васька", 1100.0, "Черный");
        murka.setKitten("Мурка", 1000.0, "Белый");
        boris.setKitten("Борис", 1200.0, "Рыжий");

        System.out.println("Список кошек:" +
                            "\n" + vasya.getName() + ", вес: " + vasya.getWeight()
                                    + ", цвет: " + vasya.getColor() +
                            "\n" + murka.getName() + ", вес: " + murka.getWeight()
                                    + ", цвет: " + murka.getColor() +
                            "\n" + boris.getName() + ", вес: " + boris.getWeight()
                                    + ", цвет: " + boris.getColor());
    }
}
