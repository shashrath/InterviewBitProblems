package shasha.company.practice;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FurthestBuilding {
    public static void main(String[] args) {
/*        int a[] = {4,2,7,6,9,14,12};
        System.out.println(furthestBuilding(a,5,1));*/
        newFunction();
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> largest = new PriorityQueue<>();
        int pos = 0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]<= heights[i-1]){
                pos = i;
            }
            else{
                int diff = heights[i]-heights[i-1];
                largest.add(diff);
                if(largest.size()> ladders){
                    diff = largest.poll();
                    bricks = bricks-diff;
                }
                if(bricks <= 0)
                    return pos;
                else
                    pos = i;
            }
        }
        return pos;
    }
    
    public static void newFunction(){
        int x =0;
        for(x=1;x<4;x++);
        System.out.println(x);
    }
    
}
