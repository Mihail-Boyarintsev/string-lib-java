import com.example.stringlib.LevenshteinDistance;

public class SpellChecker {
    private static final String[] DICTIONARY = {"hello", "world", "java", "string"};

    public static String suggest(String input) {
        String best = null;
        int minDist = Integer.MAX_VALUE;
        for (String word : DICTIONARY) {
            int dist = LevenshteinDistance.compute(input, word);
            if (dist < minDist) {
                minDist = dist;
                best = word;
            }
        }
        return minDist <= 2 ? best : null;
    }

    public static void main(String[] args) {
        System.out.println(suggest("helo"));   // -> hello
        System.out.println(suggest("javv"));   // -> java
        System.out.println(suggest("xyz"));    // -> null
    }
}