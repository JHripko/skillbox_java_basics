import java.util.Arrays;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //создаем массив с количеством элементов, переданных в метод
        float[] temperatureData = new float[patientsCount];

        //заполняем массив сгенерированными значениями температур от 32 до 40
        for (int i = 0; i < temperatureData.length; i++) {
            float value = (float) Math.random() * (40 - 32) + 32;

            //округление до десятых
            temperatureData[i] = rounding(value);
        }

        return temperatureData;
    }

    public static String getReport(float[] temperatureData) {
        int healthyCount = 0;               //количество здоровых пациентов
        float sumTemperature = 0;           //сумма температур
        float averageTemperature;          //средняя температура
        String temperatures = "";           //переменная строки со значениями температур

        for (int i = 0; i < temperatureData.length; i++) {
            //проверка каждой температуры на соответствие здоровому пациенту
            if (isHealthy(temperatureData[i])) {
                healthyCount++;     //счетчик кол-ва здоровых пациентов
            }

            sumTemperature += temperatureData[i];       //суммирование значения температур
            temperatures += temperatureData[i] + " ";   //добавление значения в строку
        }

        //вычисление средней температуры
        averageTemperature = (float) sumTemperature / temperatureData.length;
        //округление до десятых
        averageTemperature = rounding(averageTemperature);

        String report =
                "Температуры пациентов: " + temperatures.trim() +
                        "\nСредняя температура: " + averageTemperature +
                        "\nКоличество здоровых: " + healthyCount;

        return report;
    }

    //вспомогательные методы:
    //округление до десятых
    public static float rounding(float number) {
        number = (float) Math.round(number * 10) / 10;
        return number;
    }

    //проверка здоровый ли пациент
    public static boolean isHealthy(float temperature) {
        if (temperature >= (float) 36.2 && temperature <= (float) 36.9) {
            return true;
        } else return false;
    }
}
