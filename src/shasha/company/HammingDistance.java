package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class HammingDistance {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2, 4, 6));
        System.out.println(hammingDistance(al));
    }

    private static int hammingDistance(ArrayList<Integer> A) {
        long sum = 0;
        int[] stor = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {

                sum = sum + myfunction(A.get(i), A.get(j));
            }
        }
        sum = sum * 2;
        return (int) (sum % 1000000007);
    }

    private static int myfunction(int m, int n) {
        Integer xor = m ^ n;
        Integer count1 = 0;
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((xor & (1 << i)) != 0)
                count1++;
        }
        return count1;
    }

}
