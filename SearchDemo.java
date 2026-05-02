import com.example.stringlib.KMPAlgorithm;
import java.util.List;

public class SearchDemo {
    public static void main(String[] args) {
        String text = "ABBABABABBA";
        String pattern = "BAB";
        List<Integer> indices = KMPAlgorithm.search(text, pattern);
        System.out.println("Образец встречается на позициях: " + indices);
        // Ожидание: [2, 4, 6]
    }
}
