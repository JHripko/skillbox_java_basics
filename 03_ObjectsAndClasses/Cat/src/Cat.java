
public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodWeight;

    private static int count;

    private boolean alive;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

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
        if (weight < minWeight) {
            Cat.reduceCount();
            return "Dead";
        } else if (weight > maxWeight) {
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

    public boolean isAlive() {
        if (weight > maxWeight || weight < minWeight) {
            alive = false;
        } else alive = true;

        return alive;
    }
}