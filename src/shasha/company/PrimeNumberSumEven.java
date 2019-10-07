package shasha.company;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//Find two prime numbers with given sum (Even Number)
public class PrimeNumberSumEven {
    public static void main(String[] args) {
        ArrayList<Integer> res;
        long startTime = System.nanoTime();
        res = findPrimeNumbers(50);
        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);
        System.out.println("Time in milli second: " + durationInNano);
        primeNumbers(res,50);

/*        for(int i: res)
            System.out.println(i);*/
    }

    //SieveOfEratosthenes
    private static ArrayList<Integer> findPrimeNumbers(Integer n){
        boolean isPrime[] = new boolean[n+1];
        ArrayList<Integer> al = new ArrayList<>();
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int p = 2; p * p <= n; p++)  //Important Points p*p is important to know Why
        {
            // If isPrime[p] is not changed,
            // then it is a prime
            if (isPrime[p])
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p) // Important Points again p*p is important to know Why
                    isPrime[i] = false;
            }
        }
        for(int i=2;i<=n;i++){
            if(isPrime[i])
                al.add(i);
        }
        return al;
    }
    private static void primeNumbers(ArrayList<Integer> al,int n){
        for(int i=0;i<al.size();i++)
        {
            int other = n-al.get(i);
            if(al.contains(other))
            {
                System.out.println("Value of a: "+ al.get(i) + "and b: " + other);
                break;
            }
        }
    }
}
