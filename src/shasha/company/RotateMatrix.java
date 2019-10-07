package shasha.company;

import java.util.ArrayList;

public class RotateMatrix {
    public static void main(String[] args) {
        int a = 3;
        int count = 1;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            al.add(new ArrayList<>());
            for (int j = 0; j < a; j++) {
                al.get(i).add(count);
                count++;
            }
        }
        for (ArrayList<Integer> b : al) {
            for (Integer c : b)
                System.out.print(c + " ");
            System.out.println();
        }
        rotate(al);
        for (ArrayList<Integer> b : al) {
            for (Integer c : b)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    private static void rotate(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
/*        for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < N-x-1; y++)
            {
                // store current cell in temp variable
                int temp = A.get(x).get(y);

                // move values from right to top
                //mat[x][y] = mat[y][N-1-x];
                A.get(x).set(y,A.get(y).get(N-1-x));

                // move values from bottom to right
               // mat[y][N-1-x] = mat[N-1-x][N-1-y];
                A.get(y).set(N-1-x,A.get(N-1-x).get(N-1-y));

                // move values from left to bottom
                //mat[N-1-x][N-1-y] = mat[N-1-y][x];
                A.get(N-1-x).set(N-1-y,A.get(N-1-y).get(x));

                // assign temp to left
                //mat[N-1-y][x] = temp;
                A.get(N-1-y).set(x,temp);
            }
        }*/
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {

                // Swap elements of each cycle
                // in clockwise direction
                //int temp = a[i][j];
                int temp = A.get(i).get(j);

                //a[i][j] = a[N - 1 - j][i];
                A.get(i).set(j, A.get(N - 1 - j).get(i));

                // a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                A.get(N - 1 - j).set(i, A.get(N - 1 - i).get(N - 1 - j));

                // a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                A.get(N - 1 - i).set(N - 1 - j, A.get(j).get(N - 1 - i));

                //a[j][N - 1 - i] = temp;
                A.get(j).set(N - 1 - i, temp);
            }
        }


    }
}
