package shasha.company.Backtracking;

public class RatInaMaze {
    private static int N = 4;

    public static void main(String[] args) {
        RatInaMaze ratInaMaze = new RatInaMaze();
        int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        System.out.println("Printing Maze");
        ratInaMaze.printSolution(maze);
        System.out.println();
        ratInaMaze.mazeSolution(maze);
    }

    private void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void mazeSolution(int[][] maze) {
        int[][] sol = new int[4][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }
        if (mazeUtil(maze, sol, 0, 0))
            printSolution(sol);
        else
            System.out.println("No Path found");
    }

    private boolean mazeUtil(int[][] maze, int[][] sol, int x, int y) {
        if (x < 4 && y < 4 && maze[x][y] == 1) {
            sol[x][y] = 1;
            if (x == 3 && y == 3)
                return true;
            if (mazeUtil(maze, sol, x + 1, y))
                return true;
            else if (mazeUtil(maze, sol, x, y + 1))
                return true;
            else {
                sol[x][y] = 0;
                return false;
            }
        } else
            return false;
    }
}
