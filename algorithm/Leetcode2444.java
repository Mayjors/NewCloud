package algorithm;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和两个整数 minK 以及 maxK 。
 * nums 的定界子数组是满足下述条件的一个子数组：
 * 子数组中的 最小值 等于 minK 。
 * 子数组中的 最大值 等于 maxK 。
 * 返回定界子数组的数目。
 * 子数组是数组中的一个连续部分。
 */

public class Leetcode2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int min = -1, max = -1, tag = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i]==maxK){
                max = i;
            }
            if (nums[i]==minK){
                min = i;
            }
            if (nums[i]<minK || nums[i]>maxK){
                tag = i;
            }
            System.out.println(Arrays.asList(max, min, tag));
            if(min==-1 || max==-1 || min<tag || max<tag){
                continue;
            }
            ans += (Math.min(max, min) - tag);
        }

        return ans;
    }

    public static void main(String[] args) {
        Leetcode2444 leetcode = new Leetcode2444();
        int[] nums = {1,3,5,2,7,5};
        int maxK = 5, minK = 1;
        System.out.println(leetcode.countSubarrays(nums, minK, maxK));
    }
}
// nums = [1, 4, 3, 4, 5, 2, 2, 3, 3]
// maxK = 4, minK = 2
