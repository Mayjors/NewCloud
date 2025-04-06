package demo.eu.algorithm.DP;

import java.util.Arrays;

public class Leetcode1049 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int target = sum/2;
//        System.out.println(sum);
//        System.out.println(target);
        int[][] dp = new int[n][target+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], 0);
        }
        for(int i=stones[0]; i<=target; i++){
            dp[0][i] = stones[0];
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<stones[i]; j++){
                dp[i][j] = dp[i-1][j];
            }
            for(int j=stones[i]; j<=target; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]]+stones[i]);
            }
        }
        //        System.out.println(Arrays.toString(dp[n-1]));
        return sum - dp[n-1][target]*2;
    }

    public static void main(String[] args) {
        Leetcode1049 leetcode1049 = new Leetcode1049();
        int[] stones = {31,26,33,21,40};
        System.out.println(leetcode1049.lastStoneWeightII(stones));
    }
}
