
public class Cat {
    private double originWeight;
    private double weight;
    private String name;
    private Color color;

    private double MIN_WEIGHT = 1000.0;
    private double MAX_WEIGHT = 9000.0;

    private double foodWeight;

    private static int count;

    private boolean isAlive;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        color = Color.BLACK;
        isAlive = true;
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

    //метод кормления
    public void feed(Double amount) {
        if (isAlive) {
            weight = weight + amount;
            foodWeight = foodWeight + amount;
            if (isWeightNormal()) {
                System.out.println("Кот покормлен. Вес: " + getWeight() +
                                    " " + getStatus());
            } else {
                count--;
                isAlive = false;
                System.out.println(getStatus());
            }
        } else {
            System.out.println("Котик не может кушать :(");
        }
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
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

    //метод подсчета веса съеденной еды
    public double weightOfFood() {
        return foodWeight;
    }

    //отобразить кол-во кошек
    public static int getCount() {
        return count;
    }

    //убрать кошку
    public static void reduceCount() {
        count--;
    }

    //сбросить счетчик
    public static void resetCount() {
        count = 0;
    }

    //проверка нормальный ли вес
    public boolean isWeightNormal() {
        return (weight > MIN_WEIGHT && weight < MAX_WEIGHT);
    }

    //задать цвет кошки
    public void setColor (Color color) {
        this.color = color;
    }

    //получить цвет кошки
    public Color getColor() {
        return color;
    }

    //задать вес кошки
    public void setWeight(double weight) {
        this.weight = weight;
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