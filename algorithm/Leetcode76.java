import java.util.HashMap;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        String res = "";
        int min = s.length()+1;
        int cnt = 0;
        int target = map1.size();
        //System.out.println(map1.values());
        for (int right = 0; right<s.length(); right++) {
            char c = s.charAt(right);
            if (map1.containsKey(c)){
                //System.out.println(c);
                map2.put(c, map2.getOrDefault(c, 0) + 1);
                if (map2.get(c).equals(map1.get(c))){
                    cnt++;
                    //System.out.println(cnt);
                }
            }
            while (cnt == target) {
                //System.out.println(right);
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    res = s.substring(left, right+1);
                }
                char c2 = s.charAt(left);
                if (map2.containsKey(c2)) {
                    map2.put(c2, map2.get(c2) - 1);
                    if (map2.get(c2) < map1.get(c2)){
                        cnt--;
                    }
                }
                left++;
            }
        }
        //System.out.println(map2.values());
        return res;
    }
}
