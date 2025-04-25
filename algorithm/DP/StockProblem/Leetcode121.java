package algorithm.DP.StockProblem;
/*
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润
 */
// dp[i][0]: 第i天持有股票的现金; dp[i][1]: 第i天不持有股票的现金
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]); // i-1天买了 or 今天购入
            dp[i][1] = Math.max(dp[i-1][0]+prices[i], dp[i-1][1]); // i-1天持有，今天卖出 or i-1天不持有
        }

        return dp[n-1][1];
    }
}
