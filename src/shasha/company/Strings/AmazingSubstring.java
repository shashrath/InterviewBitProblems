package shasha.company.Strings;

public class AmazingSubstring {
    public static void main(String[] args) {
        System.out.println(solve("ABEC"));
    }
    private static int solve(String A) {
        int n=A.length();
        int total=0;
        String s="aeiouAEIOU";
        for(int i=0;i<n;i++){
            char ch = A.charAt(i);
            if( s.indexOf(ch)!= -1){
                total+=n-i;
            }
            if(total>10003)
                total=total%10003;
        }
        return (int)total%10003;
    }
}
