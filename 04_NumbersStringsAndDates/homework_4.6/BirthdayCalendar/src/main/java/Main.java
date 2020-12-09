import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        StringBuilder dates = new StringBuilder();   //переменная в которую будем конкатенировать список дат

        //календарь с текущей датой
        Calendar calendar = Calendar.getInstance();

        //календарь с датой рождения
        Calendar birthday = Calendar.getInstance();
        birthday.set(year, month - 1, day);

        //переменная с паттерном форматирования даты в нужный формат
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);

        if (compareDates(birthday, calendar)) {
            for (int i = 0; compareDates(birthday, calendar); i++) {
                birthday.set(Calendar.YEAR, year + i);

                //если после увеличения года дата становится больше текущей, то цикл прерывается
                if (compareDates(birthday, calendar) == false) {
                    break;
                }

                //форматируем дату и преобразуем в строку
                String date = df.format(birthday.getTime()).toString();
                //передаем значение текстовой переменной
                dates = dates.append(i + " - " + date + System.lineSeparator());
            }
        }


        String text = dates.toString().trim();
        return text;
    }

    //метод сравнения дат
    public static boolean compareDates(Calendar beginDate, Calendar endDate) {
        if (beginDate.compareTo(endDate) <= 0) {
            return true;
        } else return false;
    }
}
