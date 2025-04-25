package demo.eu.algorithm.DP.FullBag;

import java.util.Arrays;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp[0], max);
        dp[0][0] = 0;
        for(int i=coins[0]; i<=amount; i+=coins[0]){
            dp[0][i] = dp[0][i-coins[0]]+1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<coins[i] && j<=amount; j++){
                dp[i][j] = dp[i-1][j];
            }
            for(int j=coins[i]; j<=amount; j++){
                if(dp[i][j-coins[i]]!=max){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]]+1);
                }
                else{dp[i][j] = dp[i-1][j];}
            }
        }
        // for(int i=0; i<n; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        if (dp[n-1][amount]==max){
            return -1;
        }
        return dp[n-1][amount];
    }
    public static void main(String[] args) {
        int[] coins = {474,83,404,3};
        int amount = 264;
        Leetcode322 leetcode322 = new Leetcode322();
        System.out.println(leetcode322.coinChange(coins, amount));
    }
}
