package demo.eu.algorithm.DP.ZeroOne;

import java.util.Arrays;
import java.util.Scanner;
//01背包问题
public class ZeroOneBag {
    public static int getMostValue(int m, int n, int[] weights, int[] values){
        int[][] dp = new int[m][n+1];
        //初始化
        for(int i = 0; i < weights[0]; i++){
            dp[0][i] = 0;
        }
        for(int i = weights[0]; i <= n; i++){
            dp[0][i] = values[0];
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < weights[i] && j <= n; j++){
                dp[i][j] = dp[i-1][j]; //放不下物品i
            }
            for(int j = weights[i]; j <= n; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i]); //能放，放不放
            }
        }

        return dp[m-1][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] weights = new int[m];
        int[] values = new int[m];
        for(int i = 0; i < m; i++){
            weights[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            values[i] = sc.nextInt();
        }
        System.out.println(m);
        System.out.println(n);
        System.out.println(Arrays.toString(weights));
        System.out.println(Arrays.toString(values));
        int result = getMostValue(m, n, weights, values);
        System.out.println(result);
    }
}
