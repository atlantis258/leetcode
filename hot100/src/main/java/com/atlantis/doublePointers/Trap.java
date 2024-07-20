package com.atlantis.doublePointers;

// 42.接雨水
// https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked
public class Trap {
    // 双指针法：
    // 分别计算每个位置i的雨水值
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                ans += leftMax - height[left]; // leftMax - height[left] 即为左侧 位置left的雨水值
                ++left;
            } else {
                ans += rightMax - height[right]; // rightMax - height[right] 即为右侧 位置right的雨水值
                --right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int total = trap.trap(height);
        System.out.println(total);
    }
}
