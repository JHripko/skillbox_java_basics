import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        List<Aircraft> aircraft = airport.getAllAircrafts();
        int count = aircraft.size();

        System.out.println("Список самолетов:");
        for (int i = 0; i < aircraft.size(); i++) {
            System.out.println(aircraft.get(i));
        }

        System.out.println("\nКол-во самолетов: " + count);
    }
}
