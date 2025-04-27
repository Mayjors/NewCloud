package algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[0];
        Deque<Integer> q = new LinkedList<>(); // 队列维护数据降序
        int[] res = new int[n - k + 1];
        int left = 0;
        for (int i = 0; i < n; i++) {
            while(!q.isEmpty() && q.getLast()<nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);
            // 没到窗口大小
            if (i<k-1){
                continue;
            }
            // 大于等于窗口大小
            //System.out.println(q.getFirst());
            res[left] = q.getFirst();
            if (nums[left] == q.getFirst()){
                q.removeFirst();
            }
            left++;
        }
        return res;
    }
}
