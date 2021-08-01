package shasha.company.dynamicprogramming;

public class DifferentWays {
    public static void main(String[] args) {
        int[][]obstacleGrid = {{0,0},{0,1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] output = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                output[i][j] = -1;
            }
        }
        return  obstacleGridUtility(obstacleGrid,0,0,m,n,output);
    }
    public static int obstacleGridUtility(int [][]obstacleGrid, int i, int j,int m, int n, int [][]output){
        if(i == m-1 && j == n-1 ){
            if(obstacleGrid[i][j] == 0)
                return 1;
            else
                return 0;
        }
        else if(obstacleGrid[i][j] == 1){
            return 0;
        }
        else if(output[i][j] == -1){
            output[i][j] = 0;
            if(j+1 < n){
                if(output[i][j+1] == -1){
                    output[i][j+1] = obstacleGridUtility(obstacleGrid,i,j+1,m,n,output);
                }
                output[i][j] += output[i][j+1];
            }
            if(i+1 < m){
                if(output[i+1][j] ==  -1){
                    output[i+1][j] = obstacleGridUtility(obstacleGrid,i+1,j,m,n,output);
                }
                output[i][j] += output[i+1][j];
            }
        }
        return output[i][j];
    }
}
