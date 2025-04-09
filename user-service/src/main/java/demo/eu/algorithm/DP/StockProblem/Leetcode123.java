package demo.eu.algorithm.DP.StockProblem;/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
*/
/*
 * dp[i][0]: 第i天无操作
 * dp[i][1]: 第i天第一次持有
 * dp[i][2]: 第i天第一次不持有
 * dp[i][3]: 第i天第二次持有
 * dp[i][4]: 第i天第二次不持有
 */

import java.util.Arrays;

public class Leetcode123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 0);
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            dp[i][2] = Math.max(dp[i-1][1]+prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2]-prices[i], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3]+prices[i], dp[i-1][4]);
        }

        return Math.max(dp[n-1][2], dp[n-1][4]);
    }
}
