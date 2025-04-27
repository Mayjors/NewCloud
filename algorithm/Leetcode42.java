package algorithm;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */

class Leetcode42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        int n = height.length;
        for(int i=0; i<n; i++){
            while(!stack.empty() && height[stack.peek()]<height[i]){
                //System.out.println(stack.peek());
                int t = stack.pop();
                if(!stack.empty()){
                    ans += (Math.min(height[i], height[stack.peek()])-height[t])*(i-stack.peek()-1);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}