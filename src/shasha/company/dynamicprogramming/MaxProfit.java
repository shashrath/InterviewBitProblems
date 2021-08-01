package shasha.company.dynamicprogramming;

public class MaxProfit {
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        int result = maxProfit2(prices);
        System.out.println(maxProfit(prices));
    }
    //LeetCode: Best Time to Buy and Sell Stock
    //Complicated Solution to calculate two arrays
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int maxArray[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > max) {
                maxArray[i] = prices[i];
                max = prices[i];
            } else
                maxArray[i] = max;
        }
        int minArray[] = new int[n];
        int min = max;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                minArray[i] = prices[i];
                min = prices[i];
            } else
                minArray[i] = min;
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            if (maxArray[i] - minArray[i] > max) {
                max = maxArray[i] - minArray[i];
            }
        }
        return max;
    }

    //Better solution to just keep the count of the minimum value encountered
    public static int maxProfit1(int[] prices) {
        int min =Integer.MAX_VALUE;
        int max =0;
        for(int price: prices){
            min = Math.min(min,price);
            max = Math.max(max, price-min);
        }
        return max;
    }

    //Can be solved using Kandane's Algorith as well
    //By considering the problem as difference of profits.
    public static int maxProfit2(int[] prices) {
        int max_soFar =0;
        int maxCurr = 0;
        for(int i=1;i<prices.length;i++){
            maxCurr =  Math.max(0,maxCurr + prices[i]-prices[i-1]);
            max_soFar = Math.max(max_soFar, maxCurr);
        }
        return max_soFar;
    }
}
