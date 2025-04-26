import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */

// nums可能存在负数，使用前缀和

public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int[] sums = new int[n]; // 计算前缀和
        sums[0] = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>(); // 存储遍历过的sums[i]
        map.put(0, 1); // 若sums[i]==k
        for(int i = 1; i < n; i++){
            sums[i] = sums[i-1] + nums[i];
        }
        for(int i = 0; i < n; i++){
            //System.out.println(sums[i]);
            if (map.containsKey(sums[i] - k)){
                ans += map.get(sums[i] - k);
            }
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return ans;
    }
}
