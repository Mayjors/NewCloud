package algorithm.DP;

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
*/

import java.util.Arrays;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args) {
        Leetcode300 leetcode300 = new Leetcode300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(leetcode300.lengthOfLIS(nums));
    }
}
