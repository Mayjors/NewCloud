package demo.eu.algorithm.DP.ZeroOne;

import java.util.Arrays;

//给你一个非负整数数组 nums 和一个整数 target 。
//向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
/*
假设表达式中所有加法得到的结果为x，则所有减法得到的绝对值则为sum(nums)-x
据题意：target = x - (sum(nums)-x) = 2x - sum(nums)
则： x = (target + sum(nums))/2
则题目等价为nums数组中有几种组合使得组合的和为x，其中： 0<=组合大小<=nums.length
转换为01背包问题：现有物品n个，重量为nums[n], 有几种方法将大小为x的背包填满
二维dp数组构成：行：nums, 列：0~x, 最后返回dp[n-1][x]
初始化：i==nums[0], i==0: dp[0][i] = 1; i!=nums[i] dp[0][i] = 0
dp[i][j]: 使用0~i个物品将大小为j的背包填满的方法数 = 不放物品i + 放物品i = dp[i-1][j] + dp[i-1][j-nums[i]]
 */
public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) {return 0;}
        if((sum+target)%2==1){ return 0;}
        int x = (sum+target)/2;
        int[][] dp = new int[n][x+1];
        Arrays.fill(dp[0],0);
        int zeronum = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==0){
                zeronum++;
            }
            dp[i][0] = (int)Math.pow(2,zeronum);
        }
        if(nums[0]<=x && nums[0]>0){dp[0][nums[0]] = 1;}
        for(int i=1; i<n; i++){
            for(int j=1; j<nums[i] && j<=x; j++){
                dp[i][j] = dp[i-1][j];
            }
            for(int j=nums[i]; j<=x; j++){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][x];
    }

    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        int[] nums = {0};
        int target = 0;
        System.out.println(leetcode494.findTargetSumWays(nums, target));
    }
}
