package shasha.company.Backtracking;

public class KnightTour {

    private static int N = 8;

    public static void main(String[] args) {
        KnightTour knightTour = new KnightTour();
        knightTour.KTSolution();
    }

    private boolean safeStep(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    private void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(sol[x][y] + "\t");
            }
            System.out.println();
        }
    }

    private void KTSolution() {
        int sol[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        int xmove[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int ymove[] = {-1, 1, -2, 2, -2, 2, -1, 1};

        sol[0][0] = 0;
        System.out.println(KTUtil(0, 0, 1, sol, xmove, ymove));
        printSolution(sol);
    }

    private boolean KTUtil(int x, int y, int count, int[][] sol, int[] xmove, int[] ymove) {
        if (count == N * N)
            return true;
        for (int i = 0; i < 8; i++) {
            int nextX = x + xmove[i];
            int nextY = y + ymove[i];

            if (safeStep(nextX, nextY, sol)) {
                sol[nextX][nextY] = count;
                if (KTUtil(nextX, nextY, count + 1, sol, xmove, ymove))
                    return true;
                else
                    sol[nextX][nextY] = -1;
            }
        }
        return false;
    }
}
