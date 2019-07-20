package shasha.company.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SingleNumber {
    static final int INT_SIZE = 32;

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(3,2,3,3));
        System.out.println(singleNumber(al));
    }
    private static int singleNumber(final List<Integer> A) {
        int ones = 0, twos = 0;
        int n= A.size();
        int common_bit_mask;

        for(int i=0; i<n; i++ )
        {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & A.get(i));
            System.out.print("Twos Bits--->");
            printBinary(twos);
            System.out.println();

            /*"one & arr[i]" gives the bits that are
            there in both 'ones' and new element from arr[].
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ A.get(i);
            System.out.print("Ones Bits--->");
            printBinary(ones);
            System.out.println();

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos);
            System.out.print("Bit Mask Bits--->");
            printBinary(common_bit_mask);
            System.out.println();

            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask;
            System.out.print("Final Ones Bits--->");
            printBinary(ones);
            System.out.println();
            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask;
            System.out.print("Final Twos Bits--->");
            printBinary(twos);
            System.out.println();
        }
        System.out.println("<----------------------------------->");
        printBinary(ones);
        System.out.println();
        return ones;
    }
    private static void printBinary(int n) {
        long res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0)
                System.out.print(1);
            else
                System.out.print(0);
        }
        System.out.println();
    }

    private  static int OccureOnce(final List<Integer> A){
        int result = 0;
        int x, sum;

        // Iterate through every bit
        for(int i=0; i<INT_SIZE; i++)
        {
            // Find sum of set bits at ith position in all
            // array elements
            sum = 0;
            x = (1 << i);
            for(int j=0; j<A.size(); j++)
            {
                if((A.get(j) & x) ==0)
                    sum++;
            }
            // The bits with sum not multiple of 3, are the
            // bits of element with single occurrence.
            if ((sum % 3) == 0)
                result |= x;
        }
        return result;
    }
}
