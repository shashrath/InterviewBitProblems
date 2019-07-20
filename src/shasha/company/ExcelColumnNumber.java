package shasha.company;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZZ"));
    }
    private static int titleToNumber(String A) {
        int sum=0;
        int k=0;
        for(int i=A.length()-1;i>=0;i--)
        {
            int val= A.charAt(i)-'A'+1;
            sum= sum+ ((int)Math.pow(26,k)*val);
            k++;
        }
        return sum;
    }
}
