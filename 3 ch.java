import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class TextTransformer {

    public static String transformText(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        Pattern pattern = Pattern.compile("\\b(\\w)(\\w*)\\b"); // Регулярное выражение для поиска слов
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String firstLetter = matcher.group(1); // Первая буква слова
            String restOfWord = matcher.group(2); // Оставшаяся часть слова
            String transformedWord = restOfWord + firstLetter + "ауч"; // Формируем преобразованное слово

            matcher.appendReplacement(sb, transformedWord); // Заменяем исходное слово преобразованным
        }
        matcher.appendTail(sb); // Добавляем остаток строки (после последнего совпадения)

        return sb.toString();
    }

    public static void main(String[] args) {
        String text1 = "Это просто пример.";
        String text2 = "Каждое слово будет изменено!";
        String text3 = "Привет, мир!";

        System.out.println(transformText(text1));
        System.out.println(transformText(text2));
        System.out.println(transformText(text3));
    }
}