import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    //создаем список
    static TreeSet<String> myEmailList = new TreeSet<>();
    //маска email адреса
    private static final String EMAIL_PATTERN =
                                "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@" +
                                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public void add(String email) {
        email = email.toLowerCase();
        if (isEmailValid(email)) {
            myEmailList.add(email);
            System.out.println("Email успешно добавлен!");
        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        return new LinkedList<>(myEmailList);
    }

    //дополнительные методы
    //валидатор email
    public static boolean isEmailValid(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
