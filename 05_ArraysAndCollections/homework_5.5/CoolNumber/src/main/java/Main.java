import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static CoolNumbers coolNumbers = new CoolNumbers();

    public static ArrayList<String> carNumbersAsList = (ArrayList<String>) CoolNumbers.generateCoolNumbers();
    public static HashSet<String> carNumbersAsHashSet = CoolNumbers.gosNumbersAsHashSet;
    public static TreeSet<String> carNumberAsTreeSet = CoolNumbers.gosNumbersAsTreeSet;

    public static String number = "Х555АК167";

    public static long bruteForceTime;
    public static long binarySearchTime;
    public static long hashSetSearchTime;
    public static long treeSetSearchTime;

    public static void main(String[] args) {

        getBruteForceSearch();
        //сортируем список
        Collections.sort(carNumbersAsList);

        getBinarySearch();
        getHashSetSearch();
        getTreeSetSearch();

        //выводим самый быстрый результат в консоль
        getCompare();

    }

    //дополнительные методы
    //поиск перебором
    public static void getBruteForceSearch() {
        long start = System.nanoTime();
        if (CoolNumbers.bruteForceSearchInList(carNumbersAsList, number)) {
            long end = System.nanoTime();
            bruteForceTime = end - start;
            System.out.println("Поиск перебором. Номер: " + number + " Время: " + bruteForceTime + " нс");
        } else {
            System.out.println("Не найдено");
        }
    }

    //бинарный поиск
    public static void getBinarySearch() {
        long start = System.nanoTime();
        if (CoolNumbers.binarySearchInList(carNumbersAsList, number)) {
            long end = System.nanoTime();
            binarySearchTime = end - start;
            System.out.println("Бинарный поиск. Номер: " + number + " Время: " + binarySearchTime + " нс");
        } else {
            System.out.println("Не найдено");
        }
    }

    //поиск в HashSet
    public static void getHashSetSearch() {
        long start = System.nanoTime();
        if (CoolNumbers.searchInHashSet(carNumbersAsHashSet, number)) {
            long end = System.nanoTime();
            hashSetSearchTime = end - start;
            System.out.println("Поиск в HashSet. Номер: " + number + " Время: " + hashSetSearchTime + " нс");
        } else {
            System.out.println("Не найдено");
        }
    }

    //поиск в TreeSet
    public static void getTreeSetSearch() {
        long start = System.nanoTime();
        if (CoolNumbers.searchInTreeSet(carNumberAsTreeSet, number)) {
            long end = System.nanoTime();
            treeSetSearchTime = end - start;
            System.out.println("Поиск в TreeSet. Номер: " + number + " Время: " + treeSetSearchTime + " нс");
        } else {
            System.out.println("Не найдено");
        }
    }

    //сравнение
    public static void getCompare() {
        long first = Math.min(bruteForceTime, binarySearchTime);
        long second = Math.min(hashSetSearchTime, treeSetSearchTime);

        if (first > second) {
            System.out.println("Самый быстрый результат: " + second + " нс");
        } else if (first < second) {
            System.out.println("Самый быстрый результат: " + first + " нс");
        }
    }
}
