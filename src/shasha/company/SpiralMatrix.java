package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(5, 6));
        //ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(10,11,12));
        al.add(a1);
        al.add(a2);
        al.add(a3);
        // al.add(a4);
        spiralOrder(al);
    }

    private static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int t = 0, b = A.size() - 1, l = A.get(0).size() - 1, r = 0;
        int dir = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        while (t <= b && r <= l) {
            //first traverse the top row
            if (dir == 0) {
                for (int i = r; i <= l; i++) {
                    al.add(A.get(t).get(i));
                }
                t++;
                dir = 1;
            }

            //second traverse the leftmost column
            else if (dir == 1) {
                for (int i = t; i <= b; i++) {
                    al.add(A.get(i).get(l));
                }
                l--;
                dir = 2;
            }

            //third traverse the bottommost row
            else if (dir == 2) {
                for (int i = l; i >= r; i--) {
                    al.add(A.get(b).get(i));
                }
                b--;
                dir = 4;
            }

            //fourth traverse the rightmost column
            else if (dir == 3) {
                for (int i = b; i >= t; i--) {
                    al.add(A.get(i).get(r));
                }
                r++;
                dir = dir + 1;
            }
            dir = (dir) % 4;
        }
        for (Integer a : al)
            System.out.print(a + " ");
        System.out.println();
        return al;
    }

}
