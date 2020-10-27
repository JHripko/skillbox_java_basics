
public class Cat
{
    private double originWeight;
    private double weight;
    private String name;
    private String color;

    private static double MIN_WEIGHT;
    private static double MAX_WEIGHT;
    private static int EYE_COUNT;

    private double foodWeight;

    private static int count;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        MIN_WEIGHT = 1000.0;
        MAX_WEIGHT = 9000.0;
        EYE_COUNT = 2;

    }

    //геттер цвета color
    public String getColor() {
        return color;
    }

    public void setKitten(String name, double weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
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
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public int getEyeCount() {
        return EYE_COUNT;
    }
}