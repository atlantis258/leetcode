package com.atlantis.dynamicProgramming;

// 198.打家劫舍
// https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&envId=top-100-liked
public class Rob {

    // 如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k (k>2) 间房屋，有两个选项：
    // 1.偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
    // 2.不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
    // 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 k 间房屋能偷窃到的最高总金额。

    // 用 dp[i] 表示前 i 间房屋能偷窃到的最高总金额
    // dp[i]=max(dp[i−2]+nums[i], dp[i−1])
    // 边界条件为：
    // dp[0]=nums[0]  只有一间房屋，则偷窃该房屋
    // dp[1]=max(nums[0], nums[1])，只有两间房屋，则选择其中金额较高的房屋进行偷窃
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[length-1];
    }

    // 方法二：滚动数组优化
    // 上述方法使用了数组存储结果。考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }

        return second;
    }
}
