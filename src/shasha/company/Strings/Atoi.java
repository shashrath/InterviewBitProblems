package shasha.company.Strings;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(atoi("-54332872018247709407 4 54"));
    }
    private static int atoi(final String A) {
        String a=A.trim();
        long temp=0;
        boolean neg= false;
        int i=0;
        while(i<a.length()){
            if(a.charAt(i)=='-'|| a.charAt(i)=='+'){
                if(a.charAt(i)=='-')
                    neg=true;
                i++;
                continue;
            }
            if(a.charAt(i) <48 || a.charAt(i)>57)
                return 0;

            while (i<a.length() && a.charAt(i)>=48 && a.charAt(i)<=57){
                temp=temp*10+a.charAt(i)-48;
                if(temp>Integer.MAX_VALUE)
                    break;
                i++;
            }
            if(temp>Integer.MAX_VALUE)
                break;
        }
        if(neg)
            temp= -temp;
        if(temp<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if(temp>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)temp;
    }
}
