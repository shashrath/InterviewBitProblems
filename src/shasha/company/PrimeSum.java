package shasha.company;

import java.util.ArrayList;

public class PrimeSum {
    public static void main(String[] args) {
        int n = 48;
        ArrayList<Integer> al = new ArrayList<>();
        al = primesum(n);
        System.out.println(al.get(0));
        System.out.println(al.get(1));
    }

    private static ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        int first = 0, second = 0;
        for (int i = 2; i < A / 2; i++) {
            if (isPrime(i)) {
                if (isPrime(A - i)) {
                    result.add(i);
                    result.add(A - i);
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        boolean flag = true;
        int i = 2;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) {
                flag = false;
                break;
            }
            i++;
        }
        return flag;
    }
}
