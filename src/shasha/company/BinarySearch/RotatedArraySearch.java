package shasha.company.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotatedArraySearch {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>(Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100));
        System.out.println(search(al, 202));
    }

    private static int search(List<Integer> a, int b) {
        int pivot = findpivot(a);
        int n = a.size();
        if (pivot == 0)
            return Collections.binarySearch(a, b);
        else {
            if (b == a.get(pivot))
                return pivot;
            else if (b >= a.get(0) && b <= a.get(pivot - 1))
                return myBinarySearch(a, 0, pivot - 1, b);
            else if (b >= a.get(pivot + 1) && b <= a.get(n - 1))
                return myBinarySearch(a, pivot + 1, n - 1, b);
        }
        return -1;
    }

    private static int myBinarySearch(List<Integer> a, int start, int end, int num) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (a.get(mid) == num)
            return mid;
        else if (a.get(mid) > num)
            return myBinarySearch(a, start, mid - 1, num);
        else if (a.get(mid) < num)
            return myBinarySearch(a, mid + 1, end, num);
        else
            return -1;
    }

    private static int findpivot(List<Integer> a) {
        int n = a.size();
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            if (a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev))
                return mid;
            else if (a.get(mid) <= a.get(end))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return 0;
    }
}
