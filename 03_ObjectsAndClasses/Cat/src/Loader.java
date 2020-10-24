
public class Loader {
    public static void main(String[] args) {
        Cat cat = new Cat();

        cat.setColor(Color.GINGER);

        System.out.println("Создана кошка." +
                "\nВес: " + cat.getWeight() +
                "\nКоличество глаз: " + cat.getEyeCount() +
                "\n" + cat.getStatus());
    }
}
