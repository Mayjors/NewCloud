package demo.eu.algorithm.DP.FullBag;

//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数
/*
注意：顺序不同元素相同算两种
 */

import java.util.Arrays;

public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int i=1; i<=target; i++){
            for(int j=0; j<n; j++){
                if(i>=nums[j]){
                    dp[i] += dp[i-nums[j]];
                    //System.out.println(dp[i]);
                }
                //System.out.println(dp[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Leetcode377 leetcode377 = new Leetcode377();
        System.out.println(leetcode377.combinationSum4(new int[]{1,2,3}, 4));
    }
}
