package shasha.company.Strings;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    private static String reverseWords(String a) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            while (i < a.length() && a.charAt(i) == ' ')
                i++;
            if (a.charAt(i) != ' ') {
                StringBuilder st = new StringBuilder();
                while (i < a.length() && a.charAt(i) != ' ') {
                    st.append(a.charAt(i));
                    i++;
                }
                result.insert(0, st.toString());
                result.insert(0, ' ');
            }

        }
        return result.toString().trim();
    }
}
