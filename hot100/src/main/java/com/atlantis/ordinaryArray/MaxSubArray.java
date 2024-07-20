package com.atlantis.ordinaryArray;

// 53.最大子序和
// https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked
public class MaxSubArray {
    // f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
    // f(i) = max{f(i-1)+nums[i], nums[i]}
    public int maxSubArray(int[] nums) {
        int pre = 0; // 维护 f(i) 的值
        int maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre); // 更新maxAns
        }
        return maxAns;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray.maxSubArray(nums);
        System.out.println(max);
    }
}
