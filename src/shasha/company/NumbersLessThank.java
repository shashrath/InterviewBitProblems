package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersLessThank {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(0, 1, 2, 5));
        int b = 2;
        int c = 21;
        System.out.println(solve(al, b, c));
    }

    private static int solve(ArrayList<Integer> A, int B, int C) {
        int cz = 0, result = 1;
        for (int i = 0; i < A.size(); i++)
            if (A.get(i) == 0)
                cz++;
        int temp = C, divisor = 1;
        while (temp / divisor > 9) {
            temp = temp / divisor;
            divisor = divisor * 10;
        }
        boolean flag = false;
        while (B > 0) {
            if (divisor == 0)
                return 0;
            int digit = C / divisor;
            int count = 0;
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) <= digit) {
                    count++;
                }
            }
            if (flag == false && B != 1)
                count = count - cz;
            flag = true;

            result = result * count;
            C = C % divisor;
            divisor = divisor / 10;
            B--;
        }
        return result;
    }
}
