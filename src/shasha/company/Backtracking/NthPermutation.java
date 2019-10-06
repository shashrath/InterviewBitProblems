package shasha.company.Backtracking;

import java.util.ArrayList;

public class NthPermutation {
    private Integer count;
    private String s;
    NthPermutation (){
        count =0;
        s= null;
    }
    public static void main(String[] args) {
        int c = 0/1;
        NthPermutation nthPermutation = new NthPermutation();
        System.out.println(nthPermutation.getPermutation(3, 5));
    }

    public String getPermutation(int A, int B) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i <= A; i++)
            a.add(i);
        permuteUtil(a, B, 0);
        return s;
    }

    public void permuteUtil(ArrayList<Integer> a, int b, int pos) {
        if (pos == a.size()) {
            count++;
            if (count == b) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < a.size(); i++)
                    sb.append(a.get(i));
                s = sb.toString();
            }
        } else {
            for (int i = pos; i < a.size(); i++) {
                swap(a, pos, i);
                permuteUtil(a, b, pos + 1);
                swap(a, pos, i);
            }
        }
    }

    public void swap(ArrayList<Integer> a, int v1, int v2) {
        int temp = a.get(v1);
        a.set(v1, a.get(v2));
        a.set(v2, temp);
    }
}
