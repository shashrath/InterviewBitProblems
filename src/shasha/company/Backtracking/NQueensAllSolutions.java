package shasha.company.Backtracking;

import java.util.ArrayList;

public class NQueensAllSolutions {
    public static void main(String[] args) {
        NQueensAllSolutions nQueensAllSolutions = new NQueensAllSolutions();
        nQueensAllSolutions.solveNQueens(4);
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<ArrayList<String>> sol = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            result.add(new ArrayList<String>());
            for (int j = 0; j < a; j++) {
                result.get(i).add(".");
            }
        }
        nQueensUtil(sol, result, a, 0);
        return sol;
    }

    public boolean nQueensUtil(ArrayList<ArrayList<String>> sol, ArrayList<ArrayList<String>> result, int a, int col) {
        if (col == a) {
            sol.add(new ArrayList<String>());
            StringBuilder sb = new StringBuilder();
            for (ArrayList<String> i : result) {
                for (String j : i) {
                    sb.append(j);
                }
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
            sol.get(sol.size() - 1).add(sb.toString().trim());
            return true;
        }
        for (int i = 0; i < a; i++) {
            if (isSafe(result, i, col, a)) {
                result.get(i).set(col, "Q");
                nQueensUtil(sol, result, a, col + 1);
                result.get(i).set(col, ".");
            }
        }
        return false;
    }

    public boolean isSafe(ArrayList<ArrayList<String>> sol, int row, int col, int N) {
        //Check left column
        for (int i = col; i >= 0; i--) {
            if (sol.get(row).get(i).equals("Q"))
                return false;
        }

        // Checking for left upper diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (sol.get(i).get(j).equals("Q"))
                return false;
        }
        // Checking for left down diagonal
        for (int i = row + 1, j = col - 1; i < N && j >= 0; i++, j--) {
            if (sol.get(i).get(j).equals("Q"))
                return false;
        }
        return true;
    }
}

