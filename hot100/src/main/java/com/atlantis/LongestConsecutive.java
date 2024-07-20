package com.atlantis;

import java.util.HashSet;
import java.util.Set;

// 128. 最长连续序列
// https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            // 去重
            num_set.add(num);
        }

        int longestStreak = 0;

        for (Integer num : num_set) {
            // 如果 该数-1 的数字不存在 num_set集合里，则进入if循环；
            // 如果 该数-1 的数字存在 num_set集合里，则不需要重复计算 以 num 起始的最长连续序列（肯定不会超过 以 num-1 起始的最长连续序列）
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 包含有连续序列
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();

        int[] nums = {100,4,200,1,3,2};

        System.out.println(longestConsecutive.longestConsecutive(nums));
    }
}
