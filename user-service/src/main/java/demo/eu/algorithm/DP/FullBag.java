package demo.eu.algorithm.DP;

import java.util.Arrays;
import java.util.Scanner;

public class FullBag {
    public static int getMostValue(int n, int v, int[] weights, int[] values){
        int[][] dp = new int[n][v+1];
        Arrays.fill(dp[0], 0);
        for(int i=weights[0]; i<=v; i++){
            dp[0][i] = dp[0][i-weights[0]] + values[0]; 
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<weights[i] && j<=v; j++){
                dp[i][j] = dp[i-1][j];
            }
            for(int j=weights[i]; j<=v; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weights[i]]+values[i]);
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[n-1][v];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // the number of goods
        int v = input.nextInt(); // the capacity of bag
        int[] weights = new int[n];
        int[] values = new int[n];

        for(int i=0; i<n; i++){
            weights[i] = input.nextInt();
            values[i] = input.nextInt();
        }
        // System.out.println(Arrays.toString(weights));
        // System.out.println(Arrays.toString(values));

        System.out.println(getMostValue(n, v, weights, values));
        input.close();
    }
}
