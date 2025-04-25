package algorithm.DP;// 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

import java.util.Arrays;

public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], 0);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        Leetcode1143 leetcode1143 = new Leetcode1143();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(leetcode1143.longestCommonSubsequence(text1, text2));
    }
}
