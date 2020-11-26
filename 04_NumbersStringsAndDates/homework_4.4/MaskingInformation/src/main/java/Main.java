public class Main {

    public static void main(String[] args) {

        String text = "Номер банковской карты <0000> 0000 <0000> 0000";
        String safe = searchAndReplaceDiamonds(text, "****");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        for (int i = 0; i <= text.length(); i++) {
            if (text.indexOf('<') >=0 && text.indexOf('>') >= 0) {
                int beginDiamond = text.indexOf('<');
                int endDiamond = text.indexOf('>');

                //выбираем номер который в кавычках
                String hideNumber = text.substring(beginDiamond, endDiamond + 1);
                //меняем содержимое в кавычках на placeholder
                text = text.replaceAll(hideNumber, placeholder);
            }
        }
        return text;
    }

}