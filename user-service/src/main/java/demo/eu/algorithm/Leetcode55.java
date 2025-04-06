package demo.eu.algorithm;

public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cover = 0;
        for(int i = 0; i <= cover; i++){
            cover = Math.max(cover, nums[i]+i);
            if(cover >= n-1){
                return true;
            }
        }
        return false;
    }
}
