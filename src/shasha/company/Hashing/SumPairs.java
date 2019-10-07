package shasha.company.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumPairs {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(8, 6, 6, 3, 2, 7, 2, 5, 2, 8, 9, 6, 7, 1, 5, 5, 11, 5, 8, 11, 0, 3, 12, 2, 1, 5, 7));
        SumPairs sumPairs = new SumPairs();
        ArrayList<Integer> result = sumPairs.equal(al);
        for (Integer i : result) {
            System.out.print(i + " ");
        }

    }

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<>();
        ArrayList<Integer> sol = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                temp.clear();
                temp.add(i);
                temp.add(j);
                int sum = A.get(i) + A.get(j);
                if (h.containsKey(sum)) {
                    ArrayList<Integer> x = h.get(sum);
                    if (x.size() < 4) {
                        if (!x.contains(temp.get(0)) && !x.contains(temp.get(1))) {
                            x.add(temp.get(0));
                            x.add(temp.get(1));
                            h.put(sum, new ArrayList<Integer>(x));
                            if (!sol.isEmpty()) {
                                for (int k = 0; k < sol.size(); k++) {
                                    if (sol.get(k) > x.get(k)) {
                                        sol = new ArrayList<Integer>(x);
                                        break;
                                    } else if (sol.get(k) < x.get(k))
                                        break;
                                }
                            } else {
                                sol = new ArrayList<Integer>(x);
                            }
                        }
                    }
                } else {
                    h.put(sum, new ArrayList<Integer>(temp));
                }
            }
        }
        return sol;
    }
}
