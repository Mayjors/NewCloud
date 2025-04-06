package demo.eu.algorithm.DP;

import java.util.Arrays;

public class Leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int s = strs.length;
        int[][] counts = new int[s][2];
        // 初始化counts统计每个字符串所含的0 1数
        for(int i=0; i<s; i++){
            Arrays.fill(counts[i], 0);
        }
        for(int i=0; i<s; i++){
            for(int j=0; j<strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){counts[i][0]++;}
                else{counts[i][1]++;}
            }
        }
        System.out.println(Arrays.deepToString(counts));

        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            Arrays.fill(dp[i], 0);
        }
        for(int k=0; k<s; k++){
            int cnt0 = counts[k][0];
            int cnt1 = counts[k][1];
            for(int i=m; i>=cnt0; i--){
                for(int j=n; j>=cnt1; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-cnt0][j-cnt1]+1);
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Leetcode474 leetcode474 = new Leetcode474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(leetcode474.findMaxForm(strs, m, n));
    }
}
