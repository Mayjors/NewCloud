package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = p.length()-1;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            }
            else {
                map2.put(c, 1);
            }
        }

        while (right < n){
            if (map.equals(map2)){
                ans.add(left);
            }
            right++;
            if (right == n){break;}
            char c = s.charAt(right);
            if (map2.containsKey(c)){map2.put(c, map2.get(c) + 1);}
            else {map2.put(c, 1);}
            char c2 = s.charAt(left);
            map2.put(c2, map2.get(c2) - 1);
            if (map2.get(c2) == 0){map2.remove(c2);}
            left++;
        }

        return ans;
    }
}
