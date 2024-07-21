package com.atlantis.greedyAlgorithm;

// 55.跳跃游戏
// https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-100-liked
public class CanJump {

    // 对于数组中的任意一个位置 y，我们如何判断它是否可以到达？
    // 根据题目的描述，只要存在一个位置 x，它本身可以到达，并且它跳跃的最大长度为 x+nums[x]，这个值大于等于 y，即 x+nums[x]≥y，那么位置 y 也可以到达。
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        CanJump canJump = new CanJump();
        boolean b = canJump.canJump(nums);
        System.out.println(b);
    }
}
