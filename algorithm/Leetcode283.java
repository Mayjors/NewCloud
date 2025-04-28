package algorithm;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作
 */

public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            while (right < n && nums[right] == 0) {
                right++;
            }
            if (right >= n){
                break;
            }
            nums[left] = nums[right];
            left++;
            right++;
        }
        while (left < n) {
            nums[left] = 0;
            left++;
        }
    }
}
