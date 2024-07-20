package com.atlantis.substring;

import java.util.HashMap;

// 560.和为K的子数组
// https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
public class SubarraySum {
    // 方法一：枚举
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] nums = {1,1,1};
        int k = 2;
        int count = subarraySum.subarraySum(nums, k);
        System.out.println(count);
    }

    // todo 方法二（还未研究）：前缀和 + 哈希表优化
    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
