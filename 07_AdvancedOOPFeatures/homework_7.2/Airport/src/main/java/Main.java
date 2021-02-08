import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static Date currentDate = new Date(System.currentTimeMillis());          //переменная текущего времени
    public static Date afterTime = new Date(System.currentTimeMillis() + 7200000);  //переменная времени через 2 ч
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport).forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals()
                .stream()
                .flatMap(terminal -> terminal.getFlights().stream()
                        .filter((flight -> flight.getDate()
                                //фильтруем рейсы из списка по дате через 2 ч от текущей даты
                                .after(currentDate) & flight.getDate().before(afterTime)
                                    //также фильтруем по статусу рейса "вылетает"
                                    & (flight.getType() == Flight.Type.DEPARTURE))))
                //собираем в список
                .collect(Collectors.toList());
    }

}