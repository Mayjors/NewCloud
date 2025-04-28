package algorithm.DP.StealMaxValue;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统
//如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//房屋围成圈
/*
考虑两种情况：
1、包含首不包含尾
2、包含尾不包含首
 */
public class Leetcode213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[n-1]; // situation 1
        int[] dp2 = new int[n-1]; // situation 2
        dp1[0] = nums[0];
        dp2[0] = nums[1];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = Math.max(nums[1], nums[2]);
        for(int i=2; i<n-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i+1]);
        }
        return Math.max(dp1[n-2], dp2[n-2]);
    }
}
