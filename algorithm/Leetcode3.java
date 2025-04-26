import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 */

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n==1){return 1;}
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right=0;
        while (right < n) {
            char c = s.charAt(right);
            res = Math.max(res, right-left);
            if (map.containsKey(c)) {
                //res = Math.max(res, right-left);
                left = Math.max(left, map.get(c)+1);
                map.replace(c, right);
            }
            else {
                map.put(c, right);
                //res = Math.max(res, right-left);
            }
            right++;
        }
        res = Math.max(res, right-left);
        return res;
    }
}
