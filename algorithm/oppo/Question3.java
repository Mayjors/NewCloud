package demo.eu.algorithm.oppo;

/**
 * 输入：
 *  第一行：数字n，代表字符串长度
 *  第二行：字符串s，由i个?和n-i个数字构成
 * 求：
 *  用数字填满?后，得到的数字为3的倍数的方法数
 * 例：
 *  输入：4
 *       12?4
 *  输出：3 //(1224, 1254, 1284)
 *  输入：2
 *       ?3
 *  输出：3 //(33, 36, 39)
 */

/**
 * dp[i][j]: 处理到第i个字符，0~i构成的数字除以3余数为j的方法数
 * 转移:
 *  当前字符为数字d: dp[i][(j+d)%3] += dp[i-1][j]
 *  当前字符为?: for循环0~9, dp[i][(j+k)%3]+= dp[i-1][j]
 */


public class Question3 {
    public int getMethods(int n, String s){
        int[][] dp = new int[n+1][3];
        dp[0][0] = 1;
        int start = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 3; j++){
                if(s.charAt(i-1) == '?'){
                    if(i==1){start=1;}
                    else{start=0;}
                    for(int k=start; k<=9; k++){
                        dp[i][(j+k)%3] += dp[i-1][j];
                    }
                }
                else{
                    int num = s.charAt(i-1)-'0';
                    dp[i][(j+num)%3] += dp[i-1][j];
                }
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        Question3 q = new Question3();
        int n = 5;
        String s = "12?4?";
        System.out.println(q.getMethods(n, s));
    }
}
