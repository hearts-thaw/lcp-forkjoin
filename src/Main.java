import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("techie delight", "tech", "techie",
                "technology", "technical");

        System.out.println("The longest common prefix is " +
                findLcp(words, 0, words.size() - 1));
    }

    public static String findLcp(List<String> words, int low, int high) {
        if (low > high) {
            return "";
        }

        if (low == high) {
            return words.get(low);
        }

        int mid = (low + high) / 2;

        String lowLcp = findLcp(words, low, mid);
        String highLcp = findLcp(words, mid + 1, high);

        return lcp(lowLcp, highLcp);
    }

    public static String lcp(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) != s2.charAt(j)) break;

            i++;
            j++;
        }

        return s1.substring(0, i);
    }
}