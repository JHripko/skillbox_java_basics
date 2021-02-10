import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        try {
            String[] components = data.split("\\s+");
            if (!isPhoneValid(components[INDEX_PHONE])) {
                throw new IllegalArgumentException("Неверный формат номера телефона");
            }
            if (!isEmailValid(components[INDEX_EMAIL])) {
                throw new IllegalArgumentException("Неверный формат электронной почты");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Wrong command! Available command examples: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }


    //дополнительные методы
    //проверка номера телефона
    public boolean isPhoneValid(String phoneNumber) {
        if (!phoneNumber.isEmpty()) {
            if (phoneNumber.length() == 11) {
                return phoneNumber.charAt(0) == '7' || phoneNumber.charAt(0) == '8';
            } else if (phoneNumber.length() == 12) {
                return phoneNumber.charAt(0) == '+' && phoneNumber.charAt(1) == '7';
            } else return false;
        } else return false;
    }

    //проверка адреса эл. почты
    public boolean isEmailValid(String email) {
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}