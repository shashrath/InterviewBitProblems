package shasha.company.practice;

import java.util.Arrays;

public class MostFrequent {
    public static void main(String[] args) {
       int []A = {3,9,6};
       MostFrequent mostFrequent = new MostFrequent();
        System.out.println(mostFrequent.maxFrequency(A,2));
    }

    public int maxFrequency(int[] A, int k) {
        int res = 1, i = 0, j;
        long sum = 0;
        Arrays.sort(A);
        for (j = 0; j < A.length; ++j) {
            sum += A[j];
            while (sum + k < (long)A[j] * (j - i + 1)) {
                sum -= A[i];
                i += 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
