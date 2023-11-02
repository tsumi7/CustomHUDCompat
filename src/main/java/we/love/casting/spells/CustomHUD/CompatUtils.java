package we.love.casting.spells.CustomHUD;

public class CompatUtils {
    public static String toCamelCase(String snakeStr) {
        StringBuilder camelStr = new StringBuilder();
        String[] words = snakeStr.split("_");

        camelStr.append(words[0]);
        for (int i = 1; i < words.length; i++)
            camelStr.append(capitalizeWord(words[i]));

        return camelStr.toString();
    }

    public static String capitalizeWord(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
