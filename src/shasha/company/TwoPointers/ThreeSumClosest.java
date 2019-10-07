package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
        System.out.println(threeSumClosest(al, -1));
    }

    private static int threeSumClosest(ArrayList<Integer> A, int B) {
        int result = Integer.MAX_VALUE, n = A.size(), ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = A.get(i) + A.get(j) + A.get(k);
                    if (result > Math.abs(B - sum)) {
                        result = Math.abs(B - sum);
                        ans = sum;
                    }

                }
            }
        }
        return ans;
    }
}
