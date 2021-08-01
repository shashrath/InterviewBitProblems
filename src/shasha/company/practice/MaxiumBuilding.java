package shasha.company.practice;

import java.util.Arrays;

public class MaxiumBuilding {
    public static void main(String[] args) {
        int [][] restrictions = {{2,1},{4,1}};
        System.out.println(maxBuilding(5,restrictions));
    }

    public static int maxBuilding1(int n, int[][] restrictions) {
        int result[] = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 0; i < restrictions.length; i++) {
            result[restrictions[i][0] - 1] = restrictions[i][1];
        }
        for (int i = 1; i < n ; i++) {
            if (result[i] == Integer.MAX_VALUE)
                result[i] = result[i - 1] + 1;
            else
                result[i] = Math.min(result[i - 1] + 1, result[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            result[i] = Math.min(result[i + 1] + 1, result[i]);
        }
        int max = 1;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public static int maxBuilding(int n, int[][] restrictions) {
        int len = restrictions.length;
        Arrays.sort(restrictions, (x,y) -> Integer.compare(x[0],y[0]));
        int pI = 1;
        int pH = 0;
        for(int i=0;i<len;i++){
            restrictions[i][1] = Math.min(restrictions[i][1], pH + restrictions[i][0]-pI);
            pI = restrictions[i][0];
            pH = restrictions[i][1];
        }
        for(int i=len-2;i>=0;i--){
            restrictions[i][1] =  Math.min(restrictions[i][1], restrictions[i+1][1] + restrictions[i+1][0]- restrictions[i][0]);
        }
        pI = 1;
        pH = 0;
        int maxHeight = 0;
        for(int i=0;i<len;i++){
            int h = restrictions[i][1];
            int cI = restrictions[i][0];
            if(h > pH){
                h = Math.min(h, pH + cI-pI);
                int remains = Math.max(0, (cI-pI) - (h - pH));
                maxHeight = Math.max(maxHeight, h + remains/2);
            }
            else{
                int remains = (cI-pI) - (pH-h);
                maxHeight = Math.max(maxHeight, pH + remains/2);
            }
            pI = cI;
            pH = h;
        }
        return maxHeight;
    }
}
