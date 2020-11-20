public class Main {
    public static void main(String[] args) {

        //вывод min и max числа типа byte
        System.out.println("BYTE MIN: " + Byte.MIN_VALUE + " MAX: " + Byte.MAX_VALUE);

        //вывод min и max числа типа short
        System.out.println("SHORT MIN: " + Short.MIN_VALUE + " MAX: " + Short.MAX_VALUE);

        //вывод min и max числа типа int
        System.out.println("INTEGER MIN: " + Integer.MIN_VALUE + " MAX: " + Integer.MAX_VALUE);

        //вывод min и max числа типа long
        System.out.println("LONG MIN: " + Long.MIN_VALUE + " MAX: " + Long.MAX_VALUE);

        //вывод min и max числа типа double
        System.out.println("DOUBLE MIN: " + (-Double.MAX_VALUE) + " MAX: " + Double.MAX_VALUE);

        //вывод min и max числа типа float
        System.out.println("FLOAT MIN: " + (-Float.MAX_VALUE) + " MAX: " + Float.MAX_VALUE);

        /*
        Т.к. для знака в типах double и float отведен отдельный бит, то минимальное отрицательное значение
        чисел данных типов будет являться MAX_VALUE со знаком минус, в противном случае MIN_VALUE даст просто
        минимальное положительное число близкое к нулю.
         */
    }
}
