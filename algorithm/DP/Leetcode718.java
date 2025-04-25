/*
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 
 */

 /*
  * dp[i][j]: 数组1中以i-1为下标的字母结尾 和 数组2中以j-1为下标的字母结尾的公共、长度最长的子数组的长度
  */

import java.util.Arrays;

public class Leetcode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], 0);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
            System.out.println(i + Arrays.toString(dp[i]));
        }

        return ans;
    }

    public static void main(String[] args) {
        Leetcode718 leetcode718 = new Leetcode718();
        int[] nums1 = {0,1,1,1,1};
        int[] nums2 = {1,0,1,0,1};
        System.out.println(leetcode718.findLength(nums1, nums2));
    }
}
