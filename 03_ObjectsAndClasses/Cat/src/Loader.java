
public class Loader {

    private static Cat getKitten(String name, double weight) {
        Cat cat = new Cat(name, weight);
        return cat;
    }

    public static void main(String[] args) {
        Cat vasya = getKitten("Васька", 1100.0);
        Cat murka = getKitten("Мурка", 1000.0);
        Cat boris = getKitten("Борис", 1200.0);

        System.out.println("Список кошек:" +
                            "\n" + vasya.getName() + ", весом: " + vasya.getWeight() +
                            "\n" + murka.getName() + ", весом: " + murka.getWeight() +
                            "\n" + boris.getName() + ", весом: " + boris.getWeight());
    }
}
