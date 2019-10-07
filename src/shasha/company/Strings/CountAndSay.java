package shasha.company.Strings;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int A) {
        String result = "";
        if (A <= 0)
            return result;
        result = "1";
        for (int i = 2; i <= A; i++) {
            int j = 0;
            StringBuilder sr = new StringBuilder();
            while (j < result.length()) {
                char ch = result.charAt(j);
                int count = 0;
                while (j < result.length() && ch == result.charAt(j)) {
                    count++;
                    j++;
                }
                sr.append(String.valueOf(count));
                sr.append(String.valueOf(ch));
            }
            result = sr.toString();
        }
        return result;
    }
}
