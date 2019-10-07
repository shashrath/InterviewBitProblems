package shasha.company.StackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangeHistogram {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2, 4, 6));
        System.out.println(largestRectangleArea(al));
    }

    //MySolution
    private static int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> lv = new ArrayList<>(Arrays.asList(new Integer[A.size()]));
        ArrayList<Integer> rv = new ArrayList<>(Arrays.asList(new Integer[A.size()]));
        lv.set(0, 0);
        s.push(0);
        for (int i = 1; i < A.size(); i++) {
            Integer index = null;
            while (!s.isEmpty() && A.get(s.peek()) >= A.get(i)) {
                index = s.pop();
            }
            if (index == null)
                lv.set(i, 0);
            else if (s.isEmpty())
                lv.set(i, i - 0);
            else
                lv.set(i, (i - s.peek()) - 1);
            s.push(i);
        }
        rv.set(A.size() - 1, 0);
        s.clear();
        s.push(A.size() - 1);
        for (int i = A.size() - 2; i >= 0; i--) {
            Integer index = null;
            while (!s.isEmpty() && A.get(s.peek()) >= A.get(i)) //Always consider greater than equals to
            {
                index = s.pop();
            }
            if (index == null)
                rv.set(i, 0);
            else if (s.isEmpty())
                rv.set(i, A.size() - 1 - i);
            else
                rv.set(i, (s.peek() - i) - 1);
            s.push(i);
        }
        // for(int a: lv)
        //     System.out.print(a + " ");
        // System.out.println();
        // for(int a: rv)
        //     System.out.print(a + " ");
        // System.out.println();
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i) * (lv.get(i) + rv.get(i) + 1);
            if (val > max)
                max = val;
        }
        return max;
    }

}
