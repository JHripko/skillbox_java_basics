import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int CONT_CAPACITY = 27;     //максимальное количество ящиков в контейнере (вместимость контейнера)
        int TRUCK_CAPACITY = 12;    //максимальное количество контейнеров в грузовике (вместимость грузовика)

        int boxesAmount;            //количество ящиков
        int containersAmount;       //количество контейнеров
        int trucksAmount;           //количество грузовиков

        int containerNum = 1;       //номер контейнера
        int boxNum = 1;             //номер ящика

        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        //преобразование введенного кол-ва ящиков к типу int и запись значения в переменную boxesAmount
        boxesAmount = Integer.parseInt(boxes);

        //вычисляем необходимое количество контейнеров
        //при наличии остатка от деления к кол-ву контейнеров прибавляем 1
        containersAmount = boxesAmount / CONT_CAPACITY;
        if (boxesAmount % CONT_CAPACITY > 0) {
            containersAmount++;
        }

        //вычисляем необходимое количество грузовиков
        //при наличии остатка от деления к кол-ву грузовиков прибавляем 1
        trucksAmount = containersAmount / TRUCK_CAPACITY;
        if (containersAmount % TRUCK_CAPACITY > 0) {
            trucksAmount++;
        }

        //циклы
        //вывод грузовиков
        for (int i = 1; i <= trucksAmount; i++) {
            int containersCount = 0;    //временная переменная счетчика контейнеров
            System.out.println("Грузовик: " + i);

            //вывод контейнеров
            while (containersCount < TRUCK_CAPACITY && containerNum <= containersAmount) {
                System.out.println("\tКонтейнер: " + containerNum);
                int boxesCount = 0;     //временная переменная счетчика ящиков

                //вывод ящиков
                while (boxesCount < CONT_CAPACITY && boxNum <= boxesAmount) {
                    System.out.println("\t\tЯщик: " + boxNum);

                    //увеличиваем значение номера ящика и счетчика ящиков
                    boxNum++;
                    boxesCount++;
                }

                //увеличиваем значение номера контейнера и счетчика контейнеров
                containerNum++;
                containersCount++;
            }
        }

        //отображение итоговой информации
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + trucksAmount + " шт.");
        System.out.println("контейнеров - " + containersAmount + " шт.");

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

    }

}
