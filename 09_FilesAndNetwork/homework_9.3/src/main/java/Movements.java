import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movements {
    public static List<Account> staff = new ArrayList<>();                  //список строк файла
    public HashMap<String, ArrayList<Double>> companies = new HashMap<>();  //список компаний

    public Movements(String pathMovementsCsv) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            //удаляем первую строку, так как она является "шапкой" таблицы
            lines.remove(0);

            for (String line : lines) {
                //разделяем строку по запятым, игнорируя запятые в кавычках
                String[] fragments = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (fragments.length > 0) {
                    String dateFormat = "dd.MM.yy";
                    staff.add(new Account(
                                    fragments[0],                                           //accountType
                                    fragments[1],                                           //accountNumber
                                    fragments[2],                                           //currency
                                    (new SimpleDateFormat(dateFormat).parse(fragments[3])), //date
                                    fragments[4],                                           //reference
                                    fragments[5],                                           //operation
                                    getCorrectDouble(fragments[6]),                         //coming
                                    getCorrectDouble(fragments[7])));                       //expense
                } else {
                    System.out.println("Wrong line: " + line);
                }
            }
        }
        catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
        setCompanyList();
    }

    public double getExpenseSum() {
        return staff.stream().mapToDouble(Account::getExpense).sum();
    }

    public double getIncomeSum() {
        return staff.stream().mapToDouble(Account::getComing).sum();
    }


    //дополнительные методы
    //коррекция числовой записи
    public static Double getCorrectDouble(String fragment) {
        return Double.parseDouble(fragment.replace("\"", "")
                                                    .replace(",", "."));
    }

    //создание списка по компаниям
    public void setCompanyList() {
        for (Account s : staff) {
            String company = getCompanyFormat(s.getOperation());
            ArrayList<Double> companyExpense = companies.computeIfAbsent(company, k -> new ArrayList<>());

            companyExpense.add(s.getExpense());
        }
    }

    //получение списка по компаниям
    public void getCompanyList() {
        for (String key : companies.keySet()) {
            double sum = companies.get(key).stream().mapToDouble(value -> value).sum();
            System.out.println(key + "\t" + sum + " руб");
        }
    }

    //форматирование компании из поля операции
    public static String getCompanyFormat(String operation) {
        StringBuilder company = new StringBuilder();
        //разбиваем строку на фрагменты в местах где больше 2 пробелов
        String[] strFragments = operation.split("\\s{3,}");
        operation = strFragments[1];
        //избавляемся от слэшей в названиях
        String[] words = operation.split("[/\\\\]");
        //формируем строку компании
        for (int i = 1; i < words.length; i++) {
            company.append(words[i]);
        }
        return company.toString();
    }
}
