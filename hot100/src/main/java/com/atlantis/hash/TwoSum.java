package com.atlantis.hash;

import java.util.Arrays;

// 1. 两数之和
// https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i< nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] nums = {2,7,11,15};
//        int target = 9;

//        int[] nums = {3,2,4};
//        int target = 6;

        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
