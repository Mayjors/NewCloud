package demo.eu.algorithm.DP.FullBag;

import java.util.Arrays;
import java.util.List;

//回溯版本
public class Leetcode139 {
    public static boolean find(String s, List<String> wordDict, int[] memory, int start, int n, int m){
        if(start == n){
            return true;
        }

        if(memory[start]==1){
            return false;
        }

        for(int i=0; i<m; i++){
            int l = wordDict.get(i).length();
            if(start+l <= n){
                String subs = s.substring(start, start+l);
                //System.out.println(subs+" "+wordDict.get(i));
                if (subs.equals(wordDict.get(i))){
                    if(find(s, wordDict, memory, start+l, n, m)){
                        return true;
                    }
                }
            }
        }
        memory[start] = 1;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.size();
        int[] memory = new int[n];
        Arrays.fill(memory, 0);
        return find(s, wordDict, memory, 0, n, m);
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.size();
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<m; j++){
                int l = wordDict.get(j).length();
                if(i>=l && dp[i-l]==1 && s.substring(i-l, i).equals(wordDict.get(j))){
                    dp[i] = 1;
                }
            }
        }
        return dp[n]==1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        Leetcode139 leetcode139 = new Leetcode139();
        System.out.println(leetcode139.wordBreak(s, wordDict));
        System.out.println(leetcode139.wordBreak2(s, wordDict));
    }
}
