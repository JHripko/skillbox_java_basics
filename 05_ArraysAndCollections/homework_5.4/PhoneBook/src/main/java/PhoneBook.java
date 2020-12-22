import java.util.*;

public class PhoneBook {

    //создаем HashMap с телефонной книгой (в качестве ключа - имя, в качестве значения - список номеров телефонов)
    HashMap<String, ArrayList<String>> myPhoneBook = new HashMap<>();

    public static final String WRONG_NAME_FORMAT = "Неверный формат имени!";
    public static final String WRONG_PHONE_FORMAT = "Неверный формат номера телефона";

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (isNameValid(name)) {
            if (isPhoneValid(phone)) {
                //создаем список номеров телефонов для контакта
                ArrayList<String> phones = myPhoneBook.get(name);
                //если такого имени в myPhoneBook нет, то вернет null, поэтому создаем новый список
                if (phones == null) {

                    phones = new ArrayList<>();
                    //добавляем значения имени и номера телефона
                    myPhoneBook.put(name, phones);
                }

                //проверяем на наличие номера телефона в списке и меняем имя контакта
                setContactName(name, phone);
                phones.add(phone);

                System.out.println("Контакт сохранен!");
            } else System.out.println(WRONG_PHONE_FORMAT);
        } else System.out.println(WRONG_NAME_FORMAT);
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        //создаем пустую строку для передачи ответа
        StringBuilder response = new StringBuilder();

        //поиск имени в myPhoneBook по номеру телефона
        for (Map.Entry<String, ArrayList<String>> entry : myPhoneBook.entrySet()) {
            String contactName = entry.getKey();
            ArrayList<String> contactPhones = entry.getValue();

            //если такой номер существует, то возвращаем строку с контактом
            if (contactPhones.contains(phone)) {
                response.append(contactName).append(" - ");
                StringBuilder numbers = new StringBuilder();
                for (String number : contactPhones) {
                    numbers.append(number);
                }
                response.append(numbers);
            }
        }

        return response.toString();
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

        //создаем список номеров телефонов
        TreeSet<String> phones = new TreeSet<>();
        String phonesList = "";

        //если myPhoneBook содержит имя, которое ввел пользователь - вывести его номера телефонов
        if (myPhoneBook.containsKey(name)) {
            phonesList += myPhoneBook.get(name).toString();
            //формируем строку с номерами телефона (убираем квадратные скобки)
            phonesList = phonesList.substring(1, phonesList.length() - 1);
            phones.add(name + " - " + phonesList);
        }

        return phones;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        //создаем список номеров телефонов
        TreeSet<String> contacts = new TreeSet<>();

        for (String key : myPhoneBook.keySet()) {
            //формируем строку с номерами телефонов (удаляем квадратные скобки)
            String numbers = myPhoneBook.get(key).toString();
            numbers = numbers.substring(1, numbers.length() - 1);
            contacts.add(key + " - " + numbers);
        }
        return contacts;
    }


    //дополнительные методы
    //валидатор имени
    public static boolean isNameValid(String name) {
        if (!name.isEmpty()) {
            char ch = name.charAt(0);

            return Character.isUpperCase(ch);
        } else return false;
    }

    //валидатор номера телефона
    public static boolean isPhoneValid(String phone) {
        if (!phone.isEmpty()) {
            if (phone.length() == 11) {

                return phone.charAt(0) == '7' || phone.charAt(0) == '8';
            } else return false;
        } else return false;
    }

    //изменение имени контакта, при добавлении номера уже существующего в списке
    public void setContactName(String name, String phone) {

        for (Map.Entry<String, ArrayList<String>> entry : myPhoneBook.entrySet()) {
            //получаем старое имя списка контактов
            String oldName = entry.getKey();
            //получаем номера телефонов для контакта
            ArrayList<String> numbers = entry.getValue();
            /*
                если такой номер телефона уже есть в списке
                то находим имя контакта и удаляем его, затем создаем контакт с новым именем
                и помещаем в него номера телефонов прежднего контакта
            */
            if (numbers.contains(phone)) {
                myPhoneBook.remove(oldName);
                myPhoneBook.put(name, numbers);
                System.out.println("Имя контакта \"" + oldName + "\" изменено на \"" + name + "\"");
                break;
            }
        }
    }

}