package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    //сеттер number
    public void setNumber(String number) {
        this.number = number;
    }

    //геттер number
    public  String getNumber() {
        return number;
    }

    //сеттер height
    public void setHeight(int height) {
        this.height = height;
    }

    //геттер height
    public int getHeight() {
        return height;
    }

    //сеттер weight
    public void setWeight(double weight) {
        this.weight = weight;
    }

    //геттер weight
    public double getWeight() {
        return weight;
    }

    //сеттер hasVehicle
    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    //геттер hasVehicle
    public boolean getHasVehicle() {
        return hasVehicle;
    }

    //сеттер isSpecial
    public void setSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    //геттер isSpecial
    public boolean getSpecial() {
        return isSpecial;
    }
}