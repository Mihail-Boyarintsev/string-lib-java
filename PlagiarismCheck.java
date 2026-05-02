import com.example.stringlib.LongestCommonSubstring;

public class PlagiarismCheck {
    public static void main(String[] args) {
        String doc1 = "Алгоритмы обработки строк представляют большой интерес.";
        String doc2 = "Большой интерес представляют алгоритмы обработки строк.";
        String lcs = LongestCommonSubstring.find(doc1, doc2);
        System.out.println("Наибольшая общая подстрока: \"" + lcs + "\"");
    }
}