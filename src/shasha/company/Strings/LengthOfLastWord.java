package shasha.company.Strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("This is not    a place    "));
    }
    private static int lengthOfLastWord(final String A) {
        StringBuilder sr = new StringBuilder();
        int total=0;
        int n=A.length()-1;
        while(n>0 && A.charAt(n)==' ')
            n--;
        for(int i=0;i<=n;i++)
        {
            if(Character.isSpaceChar(A.charAt(i))){
              total=0;
            }
            else
                total++;
        }
        return total;
    }
}
