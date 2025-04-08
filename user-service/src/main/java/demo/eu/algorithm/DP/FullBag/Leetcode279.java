package demo.eu.algorithm.DP.FullBag;

import java.util.Arrays;

public class Leetcode279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                if(dp[i-j*j]!=max){
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                }
            }
        }

        return dp[n];
    }
}
