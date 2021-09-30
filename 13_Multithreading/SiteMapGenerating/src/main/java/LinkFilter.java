import java.util.Objects;

public class LinkFilter {
    public synchronized boolean filter(String baseUrl, String link) {
        //очищаем строки адреса от http или https
        String domain = baseUrl.split("//")[1];                   //общий домен
        //проверяем что ссылка не пустая и содержит по крайней мере один слэш
        if (!Objects.equals(link, "") && link.contains("/")) {
            String line = link.split("//")[1];                    //строка ссылки

            //проверяем не короче ли ссылка чем ее домен
            if (line.length() >= domain.length()) {
                String linkDomain = line.split("/")[0];     //домен ссылки

                //если домены совпадают то выводим true
                return linkDomain.equals(domain);
            } else return false;
        }else return false;
    }
}
