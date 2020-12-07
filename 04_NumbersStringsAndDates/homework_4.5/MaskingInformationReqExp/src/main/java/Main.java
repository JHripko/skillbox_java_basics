public class Main {

    public static void main(String[] args) {
        String text = "Номер банковской карты <0000> 0000 <0000> 0000";
        String hide = searchAndReplaceDiamonds(text, "****");

        System.out.println(hide);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        for (int i = 0; i < text.length(); i++) {
            if (text.indexOf('<') >=0 && text.indexOf('>') >= 0) {
                String pattern = "\\<.*?\\>";
                text = text.replaceAll(pattern, placeholder);
            }
        }
        return text;
    }

}