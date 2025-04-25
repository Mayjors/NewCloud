package algorithm.DP.ZeroOneBag;

import java.util.Arrays;

/* 分割等和子集:
    给你一个【只包含正整数】的【非空】数组nums。
    请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
// 等价为01背包问题
public class Leetcode416 {
    // 动态一维dp
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0){ return false; }
        int n = nums.length;
        int target = sum/2;
        int[] dp = new int[target+1];
        Arrays.fill(dp, 0);

        for(int i = 0; i < n; i++){
            for(int j=target; j >= nums[i]; j--){ // 防止重复+nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        if(dp[target] == target){ return true; }
        return false;
    }
    // 二维dp
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0){ return false; }
        int n = nums.length;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 0);
        }
        for(int i = nums[0]; i <= target; i++){
            dp[0][i] = nums[0];
        }

        for(int i = 1; i < n; i++){
            for(int j=0; j<nums[i]; j++){
                dp[i][j] = dp[i-1][j];
            }
            for(int j=nums[i]; j <= target; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][target] == target;
    }

    public static void main(String[] args) {
        Leetcode416 leetcode416 = new Leetcode416();
        int[] nums = {1,5,11,5};
        System.out.println(leetcode416.canPartition(nums));
        System.out.println(leetcode416.canPartition2(nums));
    }
}
