package algorithm.DP.StockProblem;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */

import java.util.Arrays;

/**
 * 四个状态：
 * dp[i][0]: 第i天达到购入股票
 * dp[i][1]: 第i天保持不持有股票
 * dp[i][2]: 第i天当天售出股票
 * dp[i][3]: 第i天为冷冻期
 */
public class Leetcode309 {
    public static int moreCompare(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        Arrays.fill(dp[0], 0);
        dp[0][0] = -prices[0];

        for(int i = 1; i < n; i++) {
            dp[i][0] = moreCompare(dp[i-1][0], dp[i-1][1]-prices[i],dp[i-1][3]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0]+prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return moreCompare(dp[n-1][1], dp[n-1][2], dp[n-1][3]);
    }
}
