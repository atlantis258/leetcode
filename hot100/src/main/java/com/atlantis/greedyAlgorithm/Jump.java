package com.atlantis.greedyAlgorithm;

// 45.跳跃游戏 II
// https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-100-liked

// 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
public class Jump {

    // 方法一：反向查找出发位置
    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    // todo 方法二：正向查找可到达的最大位置
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Jump jump = new Jump();
        int res = jump.jump(nums);
        System.out.println(res);
    }
}
