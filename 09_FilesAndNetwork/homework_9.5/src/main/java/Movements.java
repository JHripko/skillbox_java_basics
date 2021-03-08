import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Movements {

    private TreeMap<String, ArrayList<String>> metroStations = new TreeMap<>();          //(номер линии, список станций)
    private TreeMap<String, String> metroLines = new TreeMap<>();                        //(номер линии, название линии)
    private final String DATA_FILE = "out/json/metro.json";                              //путь сохранения файла json

    public Movements(String url) throws IOException, ParseException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements lines = doc.select("span.js-metro-line");

        for (Element line : lines) {
            String lineNumber = line.attr("data-line");                        //номер линий
            String lineName = line.text();                                               //название линии
            ArrayList<String> stationsList = new ArrayList<>();                          //список станций
            Elements stations = doc.select("div.t-metrostation-list-table[data-line="
                    + lineNumber + "]>p>a>span.name");                                   //получаем тэги span со станциями
            for (Element station : stations) {
                String stationName = station.text();
                stationsList.add(stationName);
            }

            metroStations.put(lineNumber, stationsList);
            metroLines.put(lineNumber, lineName);
        }

        createJsonFile();
        createMetroData();
    }

    //создание json файла
    public void createJsonFile() {
        JSONObject object = new JSONObject();
        JSONObject stationsObj = new JSONObject();
        JSONArray linesArray = new JSONArray();

        //формируем обект станций
        for (String key : metroStations.keySet()) {
            JSONArray array = new JSONArray();
            array.addAll(metroStations.get(key));

            stationsObj.put(key, array);
        }

        //формируем объект линий
        for (String key : metroLines.keySet()) {
            JSONObject obj = new JSONObject();
            obj.put("number", key);
            obj.put("name", metroLines.get(key));

            linesArray.add(obj);
        }

        //передаем данные в объект json
        object.put("stations", stationsObj);
        object.put("lines", linesArray);

        //создаем файл и сохраняем информацию
        try {
            FileWriter file = new FileWriter(DATA_FILE);
            //форматируем строки к виду json файла
            file.write(object.toJSONString());
            file.flush();

            System.out.println("Файл успешно сохранен: " + DATA_FILE + "\n");
        }
        catch (IOException exception) {
            exception.getStackTrace();
        }
    }

    //получение json файла
    public String getJsonFile() throws IOException, ParseException {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
            lines.forEach(builder::append);
        }
        catch (IOException exception) {
            exception.getStackTrace();
        }
        return builder.toString();
    }

    //парсим данные из файла
    private void createMetroData() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            JSONObject stationsObject = (JSONObject) jsonData.get("stations");

            getStationsCount(linesArray, stationsObject);
        }
        catch (IOException | ParseException exception) {
            exception.getStackTrace();
        }
    }

    //получение кол-ва станций на линии
    public void getStationsCount(JSONArray linesArray, JSONObject stationsObject) {
        TreeMap<String, String> lines = new TreeMap<>();                                //список линий
        //разбираем массив линий и добавляем значения номера и названия линии в список
        linesArray.forEach(lineObj -> {
            JSONObject lineJsonObject = (JSONObject) lineObj;
            lines.put(lineJsonObject.get("number").toString(), lineJsonObject.get("name").toString());
        });

        //разбираем объект станций и считаем кол-во станций в каждой линии
        stationsObject.keySet().forEach(lineNumberObj -> {
            String lineNumber = (String) lineNumberObj;
            String lineName = lines.get(lineNumber);                                    //получаем название линии из списка

            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObj);
            int count = stationsArray.size();

            System.out.println(lineName + "\t\tкол-во станций: " + count);
        });
    }
}
