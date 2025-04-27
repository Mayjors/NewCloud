package algorithm;

import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (set.contains(num-1)){
                continue;
            }
            int cnt = 1;
            while (set.contains(num+cnt)) {
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
