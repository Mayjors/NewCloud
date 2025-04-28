public class Leetcode2302 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0;
        long ans = 0;
        long sum = 0;
        for (int right=0; right < n; right++) {
            sum += nums[right];
            while(sum*(right-left+1)>=k){
                sum -= nums[left++];
            }
            if(sum*(right-left+1)<k){
                ans += (right-left+1);
            }
        }
        return ans;
    }
}
