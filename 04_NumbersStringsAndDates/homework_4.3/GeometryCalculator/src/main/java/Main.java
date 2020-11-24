import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "main";
        double radius = 0;
        double a = 0;
        double b = 0;
        double c = 0;

        while (true) {

            //вывод главного меню
            while (menu.equals("main")) {
                mainMenu();

                //ввод буквы пользователем
                Scanner in = new Scanner(System.in);
                menu = in.nextLine();
            }

            //вывод расчета площади круга
            while (menu.equals("a")) {
                circleSquareView();

                Scanner in = new Scanner(System.in);
                if (in.hasNextDouble()) {
                    radius = in.nextDouble();
                    System.out.println("Площадь круга S = " + GeometryCalculator.getCircleSquare(radius));
                } else if (in.hasNextLine() && in.nextLine().equals("main")) {
                    menu = "main";
                } else {
                    System.out.println("Введите радиус или напишите main для перехода в главное меню!");
                }
            }

            //вывод расчета площади треугольника
            while (menu.equals("b")) {
                triangleSquareView();

                Scanner in = new Scanner(System.in);
                a = 3.0;
                b = 4.0;
                c = 5.0;
                System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                if (GeometryCalculator.isTrianglePossible(a, b, c)) {
                    System.out.println("Площадь треугольника S = " + GeometryCalculator.getTriangleSquare(a , b, c));
                } else {
                    System.out.println("С такими сторонами невозможно построить треугольник!");
                }
                System.out.println("Введите main для перехода в главное меню");

                if (in.hasNextLine() && in.nextLine().equals("main")) {
                    menu = "main";
                } else {
                    System.out.println("Введите main для перехода в главное меню!");
                }
            }

            //вывод расчет объема сферы
            while (menu.equals("c")) {
                sphereVolumeView();

                Scanner in = new Scanner(System.in);
                if (in.hasNextDouble()) {
                    radius = in.nextDouble();

                    System.out.println("Объем сферы V = " + GeometryCalculator.getSphereVolume(radius));
                } else if (in.hasNextLine() && in.nextLine().equals("main")) {
                    menu = "main";
                }
            }

            //вывод расчета возможности построения треугольника
            while (menu.equals("d")) {
                trianglePossibleView();

                Scanner in = new Scanner(System.in);
                a = 3.0;
                b = 4.0;
                c = 5.0;
                System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                System.out.println("Возможность построить треугольник с заданными сторонами:");
                if (GeometryCalculator.isTrianglePossible(a, b, c)) {
                    System.out.println("Можно построить");
                } else {
                    System.out.println("Невозможно");
                }

                if (in.hasNextLine() && in.nextLine().equals("main")) {
                    menu = "main";
                }
            }
        }
    }

    //отображение меню
    //главное меню
    public static void mainMenu() {
        System.out.println("\tГлавное меню:");
        System.out.println(
                "a - Расчет площади круга" +
                "\nb - Расчет площади треугольника" +
                "\nc - Расчет объема сферы (шара)" +
                "\nd - Проверка возможности построения треугольника");
    }

    //площадь круга
    public static void circleSquareView() {
        System.out.println("\tПлощадь круга:");
        System.out.println("S = Pi * r^2");
        System.out.println("Для перехода в главное меню введите main");
        System.out.print("Введите радиус r = ");
    }

    //площадь треугольника
    public static void triangleSquareView() {
        System.out.println("\tПлощадь треугольника:");
        System.out.println("S = sqrt(p * (p - a) * (p - b) * (p - c))");
        System.out.println("p = (a + b + c) / 2");
    }

    //объем сферы (шара)
    public static void sphereVolumeView() {
        System.out.println("\tОбъем сферы (шара):");
        System.out.println("V = (4/3) * Pi * R^3");
        System.out.print("Введите радиус R = ");
    }

    //возможность построения треугольника
    public static void trianglePossibleView() {
        System.out.println("\tВозможность построения треугольника:");
        System.out.println("Треугольник возможно построить, если сумма любых его двух сторон больше третьей");
    }
}
