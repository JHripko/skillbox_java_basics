
public class Cat {
    private double originWeight;
    private double weight;

    private double MIN_WEIGHT;
    private double MAX_WEIGHT;

    private double foodWeight;

    private static int count;

    private Color color;

    private boolean alive;

    private String name;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        MIN_WEIGHT = 1000.0;
        MAX_WEIGHT = 9000.0;
        color = Color.BLACK;
    }

    //дополнительный конструктор
    public Cat(String name, double weight) {
        this();
        this.name = name;
        this.weight = weight;
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        weight = weight + amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            Cat.reduceCount();
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            Cat.reduceCount();
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public void pee() {
        weight = weight - 100.0;
        System.out.println("Pee");
    }

    public double weightOfFood() {
        foodWeight = weight - originWeight;
        return foodWeight;
    }

    //отобразить кол-во кошек
    public static int getCount() {
        return count;
    }

    //добавить кошку
    public static void increaseCount() {
        count++;
    }

    //убрать кошку
    public static void reduceCount() {
        count--;
    }

    //проверка жива ли кошка
    public boolean isAlive() {
        if (weight > MAX_WEIGHT || weight < MIN_WEIGHT) {
            alive = false;
        } else alive = true;

        return alive;
    }

    //задать цвет кошки
    public void setColor (Color color) {
        this.color = color;
    }

    //получить цвет кошки
    public Color getColor() {
        return color;
    }

    //задать имя кошки
    public void setName(String name) {
        this.name = name;
    }

    //получить имя кошки
    public String getName() {
        return name;
    }
}