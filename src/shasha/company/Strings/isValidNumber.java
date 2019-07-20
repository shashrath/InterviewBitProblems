package shasha.company.Strings;

public class isValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber(""));
    }
    private static int isNumber(final String a) {
        String  A=a.trim();
        if(A.isEmpty())
            return 0;
        int i=0;
        int n= A.length();
        boolean flag=false;
        if(A.charAt(i)=='+' || A.charAt(i)=='-')
            i++;
        if(i==n)
            return 0;
        if(i<n && !Character.isDigit(A.charAt(i)))
            return 0;
        while(i<A.length()){
            if(A.charAt(i)=='e')
            {
                return checkNumber(i+1,A);
            }
            else if(A.charAt(i)=='.')
            {
                if(i+1==n)
                    return 0;
                if(!flag)
                    flag = true;
                else
                    return 0;
            }
            else if(!Character.isDigit(A.charAt(i)))
                return 0;
            i++;
        }
        return 1;
    }
    private static int checkNumber(int i,String A)
    {
        if(i==A.length())
            return 0;
        if(A.charAt(i)=='+'|| A.charAt(i)=='-')
            i++;
        while(i<A.length() && Character.isDigit(A.charAt(i)))
            i++;

        if (i==A.length()){
            return 1;
        }
        else
            return 0;
    }
}
