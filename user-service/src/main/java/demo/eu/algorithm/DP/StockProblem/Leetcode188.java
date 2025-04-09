package demo.eu.algorithm.DP.StockProblem;

import java.util.Arrays;

/**
 * leetcode123题 2 -> k
 */
public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][k*2+1];
        Arrays.fill(dp[0], 0);
        for(int i=1; i<k*2+1; i+=2){
            dp[0][i] = -prices[0];
        }

        for(int i=1; i<n; i++){
            dp[i][0] = 0;
            for(int j=1; j<k*2+1; j++){
                if(j%2==1){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]-prices[i]);
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+prices[i]);
                }
            }
        }
        return dp[n-1][k*2];
    }
}
