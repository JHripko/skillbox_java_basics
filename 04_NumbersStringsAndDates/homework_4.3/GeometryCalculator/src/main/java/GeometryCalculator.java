public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double circleSquare = Math.PI * Math.pow(radius, 2);
        return Math.abs(circleSquare);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        return Math.abs(volume);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        boolean isPossible;
        double max = Math.max(Math.max(a, b), c);
        if ((c >= a + b) || (b >= a + c) || (a >= b + c) || max == 0.0) {
            isPossible = false;
        } else {
            isPossible = true;
        }
        return isPossible;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double semiPerimeter = (a + b + c) / 2;
        double triangleSquare = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
        return triangleSquare;
    }
}
