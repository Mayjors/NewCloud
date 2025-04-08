package demo.eu.algorithm.DP.FullBag;

import java.util.Arrays;

//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
//假设每一种面额的硬币有无限个。
//题目数据保证结果符合 32 位带符号整数
/*
dp[i][j]: 使用物品0~i将容量为j的背包填满的方法数
 */
public class Leetcode518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        Arrays.fill(dp[0], 0);
        dp[0][0] = 1;
        for(int i=coins[0]; i<=amount; i+=coins[0]){
            dp[0][i] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<coins[i] && j<=amount; j++){
                dp[i][j] = dp[i-1][j];
            }
            for(int j=coins[i]; j<=amount; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[n-1][amount];
    }

    public static void main(String[] args) {
        Leetcode518 leetcode518 = new Leetcode518();
        int amount = 3;
        int[] coins = {2};
        System.out.println(leetcode518.change(amount, coins));
    }
}
