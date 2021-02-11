import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    private List<Station> route;
    private List<Station> routeWithOneTransfer;
    private List<Station> routeWithTwoTransfers;

    private static RouteCalculator routeCalculator;

    private StationIndex stationIndex;

    Line line1, line2, line3;
    Station station1, station2, station3, station4, station5, station6, station7,
            station8, station9, station10, station11, station12, station13, station14, station15;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        routeWithOneTransfer = new ArrayList<>();
        routeWithTwoTransfers = new ArrayList<>();

        stationIndex = new StationIndex();

        //линии
        line1 = new Line(1, "Первая");
        line2 = new Line(2, "Вторая");
        line3 = new Line(3, "Третья");

        //станции
        station1 = new Station("Первая", line1);
        station2 = new Station("Вторая", line1);
        station3 = new Station("Третья", line1);
        station4 = new Station("Четвертая", line1);
        station5 = new Station("Пятая", line1);
        station6 = new Station("Шестая", line2);
        station7 = new Station("Седьмая", line2);
        station8 = new Station("Восьмая", line2);
        station9 = new Station("Девятая", line2);
        station10 = new Station("Десятая", line2);
        station11 = new Station("Одиннадцатая", line3);
        station12 = new Station("Двенадцатая", line3);
        station13 = new Station("Тринадцатая", line3);
        station14 = new Station("Четырнадцатая", line3);
        station15 = new Station("Пятнадцатая", line3);

        //добавляем станции к линиям
        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line1.addStation(station4);
        line1.addStation(station5);

        line2.addStation(station6);
        line2.addStation(station7);
        line2.addStation(station8);
        line2.addStation(station9);
        line2.addStation(station10);

        line3.addStation(station11);
        line3.addStation(station12);
        line3.addStation(station13);
        line3.addStation(station14);
        line3.addStation(station15);

        //добавляем станции в stationIndex
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addStation(station9);
        stationIndex.addStation(station10);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station14);
        stationIndex.addStation(station15);

        //добавляем линии в stationIndex
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        //пересадки
        List<Station> connection1 = new ArrayList<>();
        connection1.add(stationIndex.getStation("Третья"));
        connection1.add(stationIndex.getStation("Восьмая"));
        stationIndex.addConnection(connection1);

        List<Station> connection2 = new ArrayList<>();
        connection2.add(stationIndex.getStation("Четвертая"));
        connection2.add(stationIndex.getStation("Тринадцатая"));
        stationIndex.addConnection(connection2);

        routeCalculator = new RouteCalculator(stationIndex);

        route.add(station1);
        route.add(station2);

        routeWithOneTransfer.add(station1);
        routeWithOneTransfer.add(station2);
        routeWithOneTransfer.add(station3);
        routeWithOneTransfer.add(station8);
        routeWithOneTransfer.add(station9);

        routeWithTwoTransfers.add(station7);
        routeWithTwoTransfers.add(station8);
        routeWithTwoTransfers.add(station3);
        routeWithTwoTransfers.add(station4);
        routeWithTwoTransfers.add(station13);
        routeWithTwoTransfers.add(station14);
    }

    @Test
    public void testCalculateDurationWithOneTransfer() {
        double actual = RouteCalculator.calculateDuration(routeWithOneTransfer);
        double expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDurationWithTwoTransfers() {
        double actual = RouteCalculator.calculateDuration(routeWithTwoTransfers);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    @Test
    public void testShortestRoute() {
        List<Station> shortestRoute = new ArrayList<>();
        shortestRoute.add(station1);
        shortestRoute.add(station2);
        shortestRoute.add(station3);
        shortestRoute.add(station8);
        shortestRoute.add(station7);
        shortestRoute.add(station6);

        List<Station> actual = routeCalculator.getShortestRoute(station1, station6);
        List<Station> expected = shortestRoute;
        assertEquals(expected, actual);
    }

    @Test
    public void testShortestRouteWithTwoTransfers() {
        List<Station> shortestRoute = new ArrayList<>();
        shortestRoute.add(station6);
        shortestRoute.add(station7);
        shortestRoute.add(station8);
        shortestRoute.add(station3);
        shortestRoute.add(station4);
        shortestRoute.add(station13);
        shortestRoute.add(station14);

        List<Station> actual = routeCalculator.getShortestRoute(station6, station14);
        List<Station> expected = shortestRoute;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
