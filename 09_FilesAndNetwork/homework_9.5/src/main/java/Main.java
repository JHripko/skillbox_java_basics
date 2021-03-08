import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static final String URL = "https://www.moscowmap.ru/metro.html#lines";

    public static void main(String[] args) throws IOException, ParseException {
        Movements movements = new Movements(URL);
    }
}
