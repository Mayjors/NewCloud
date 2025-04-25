package demo.eu.algorithm.DP.FullBag;

import java.util.Arrays;
import java.util.Scanner;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
//注意：给定 n 是一个正整数。
/*
完全背包+排列
先n再m
dp[i]: 爬i阶台阶的方法数
 */
public class upStair2 {
    public int getNumUpStairs(int m, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i>=j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        upStair2 up = new upStair2();
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(up.getNumUpStairs(m, n));
        sc.close();
    }
}
