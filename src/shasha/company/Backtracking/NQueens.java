package shasha.company.Backtracking;

public class NQueens {
    private static int N = 20;

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens();
    }

    private void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    private boolean isSafe(int[][] sol, int row, int col) {
        //Check left column
        for (int i = col; i >= 0; i--) {
            if (sol[row][i] == 1)
                return false;
        }

        // Checking for left upper diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (sol[i][j] == 1)
                return false;
        }
        // Checking for left down diagonal
        for (int i = row + 1, j = col - 1; i < N && j >= 0; i++, j--) {
            if (sol[i][j] == 1)
                return false;
        }
        return true;
    }

    private boolean nQueensUtil(int[][] sol, int col) {
        if (col == N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(sol, i, col)) {
                sol[i][col] = 1;
                if (nQueensUtil(sol, col + 1))
                    return true;
            }
            sol[i][col] = 0;
        }
        return false;
    }

    private void solveNQueens() {
        int sol[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }
        if (nQueensUtil(sol, 0))
            printSolution(sol);
        else
            System.out.println("Solution Dosen't Exist");
    }

}
