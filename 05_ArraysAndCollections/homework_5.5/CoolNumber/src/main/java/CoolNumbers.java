import java.util.*;

public class CoolNumbers {

    //создаем HashSet список с номерами
    public static HashSet<String> gosNumbersAsHashSet = new HashSet<>();
    public static TreeSet<String> gosNumbersAsTreeSet = new TreeSet<>();

    public static List<String> generateCoolNumbers() {

        String[] letters = {"А","В","Е","К","М","О","Н","С","Т","Р","У","Х"};

        Arrays.sort(letters);

        for (int number = 111; number <= 999; number += 111) {
            for (String a : letters) {
                for (String b : letters) {
                    for (String c : letters) {
                        for (int region = 1; region <= 199; region++) {
                            gosNumbersAsHashSet.add(String.format("%s%03d%s%s%d", a, number, b, c, region));
                        }
                    }
                }
            }
        }
        ArrayList<String> gosNumbersAsList = new ArrayList<>(gosNumbersAsHashSet);
        gosNumbersAsTreeSet.addAll(gosNumbersAsHashSet);

        return gosNumbersAsList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        boolean isFound = false;

        for (String gosNumber : list) {
            if (gosNumber.equals(number)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int index = Collections.binarySearch(sortedList, number);

        return (index >=0);
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        boolean isFound = false;
        for (String entry : hashSet) {
            if (entry.equals(number)) {
                isFound = true;
                break;
            }
        }

        return isFound;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        boolean isFound = false;
        for (String entry : treeSet) {
            if (entry.equals(number)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

}
