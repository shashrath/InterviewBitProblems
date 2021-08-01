package shasha.company.practice;

class NumMatrix {


    int [][] prefixSum;

    public static void main(String[] args) {
        int[][] matrix = {{-4,-5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        int res = numMatrix.sumRegion(0,0,0,0);
        System.out.println(res);
    }

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            prefixSum[i][0] = 0;
        }
        for(int i=0;i<n;i++){
            prefixSum[0][i] = 0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                prefixSum[i][j] = matrix[i-1][j-1]+prefixSum[i-1][j]+prefixSum[i][j-1]- prefixSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val1 = prefixSum[row2+1][col2+1];
        //System.out.println(val1);
        int val2 = prefixSum[row2+1][col1];
        //System.out.println(val2);
        int val3 = prefixSum[row1][col2+1];
        //System.out.println(val3);
        int val4 = prefixSum[row1][col1];
        return val1-val2-val3+val4;
    }
}
