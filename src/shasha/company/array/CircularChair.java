package shasha.company.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
* InterviewBit
* Find the Winner of the Circular Game
* */
public class CircularChair {
    public static void main(String[] args) {
        int result = findTheWinner3(5, 5);
        System.out.println(result );
    }

    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> nums = new ArrayList();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int count = 0;
        int i = 0;
        //while (i < nums.size() && nums.size() > 1) {
        while (nums.size() > 1) {
           // count = ( count + k - 1 )%nums.size();
            count++;
            if (count % k == 0) {
               nums.remove(i);
               i=i%nums.size();
            }
            else
                i = (i + 1) % nums.size();
            //nums.remove(count);
            //count = (count + 1) % nums.size();
        }
        return nums.get(0);
    }

    public static int findTheWinner1(int n, int k) {
        int ans=0;
        for(int i=2;i<=n;i++)
            ans=(ans+k)%i;
        return ans+1;
    }
    
    //Easiest Solution
    public static int findTheWinner3(int n, int k){
        Queue<Integer> circle = new LinkedList<>();
        for(int i=1;i<=n;i++){
            circle.offer(i);
        }
        while(circle.size()>1){
            int t = (k-1)%circle.size();
            while(t > 0){
                circle.offer(circle.remove());
                t--;
            }
            circle.remove();
        }
        return circle.remove();
    }

    //Explained solution not working
    public static int findTheWinner2(int n, int k){
        int i=1;
        while(Math.pow(k,i)< n)
            i++;

        int rem = n - (int)Math.pow(k, i-1);
        int res = rem*k +1;
        return res;
    }
}
