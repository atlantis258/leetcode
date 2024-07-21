package com.atlantis.skill;

// 136.只出现一次的数字
// https://leetcode.cn/problems/single-number/solutions/242211/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

// 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
public class SingleNumber {

    // 方法一：位运算：数组中的全部元素的异或运算结果即为数组中只出现一次的数字。
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        SingleNumber singleNumber = new SingleNumber();
        int res = singleNumber.singleNumber(nums);
        System.out.println(res);
    }
}
