package shasha.company.practice;

public class power {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
    public static boolean isPowerOfThree(int n) {
        int i=0;
        while((int)Math.pow(3,i) <= n){
            if((int)Math.pow(3,i) == n){
                return true;
            }
            i += 1;
        }
        return false;
    }
}
