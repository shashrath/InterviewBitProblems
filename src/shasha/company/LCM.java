package shasha.company;

public class LCM {
    public static void main(String[] args) {
        System.out.println("LCM is: " + lcm(96,12));
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        int ans = gcd(a,b);
        System.out.println("HCF is :"+ ans);
        return (a / ans) * b;
    }

}
