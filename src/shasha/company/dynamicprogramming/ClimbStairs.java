package shasha.company.dynamicprogramming;

class ClimbStairs {
    public static void main(String[] args) {
        int result =climbStairs2(3);
        System.out.println(result);
    }

    //Takes an memory of n size can be reduced.
    public static int climbStairs(int n) {
        int a[] = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            if(i==0 || i==1 || i==2)
            {
                a[i] =i;
            }
            else{
                a[i] = a[i-1] + a[i-2];
            }

        }
        return a[n];
    }

    public static int climbStairs2(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int a=0;
        int b=2;
        int c=1;
        for(int i=3;i<=n;i++){
            a = b+c;
            c=b;
            b=a;
        }
        return a;
    }
}