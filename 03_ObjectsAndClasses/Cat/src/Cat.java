
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodWeight;

    private static int count;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
            weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            Cat.reduceCount();
            return "Dead";
        }
        else if(weight > maxWeight) {
            Cat.reduceCount();
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    //отобразить кол-во кошек
    public static void getCount() {
        System.out.println("Количество кошек: " + count);
    }

    //счетчик кошек
    //добавить кошку
    public static void increaseCount() {
        count++;
    }

    //убрать кошку
    public static void reduceCount() {
        count--;
    }

    //проверка наличия кошек
    public static Boolean isCount() {
        boolean response;
        response = count > 0;
        return response;
    }

    //вывод ошибки о наличии кошки
    public void CatCreatedError() {
        System.out.println("Кошка умерла или не создана!");
    }
}