package com.atlantis.dynamicProgramming;

import java.util.Arrays;

// 332.零钱兑换
// https://leetcode.cn/problems/coin-change/solutions/132979/322-ling-qian-dui-huan-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
public class CoinChange {
    // 定义 F(i) 为组成金额 i 所需最少的硬币数量，假设在计算 F(i) 之前，我们已经计算出 F(0)~F(i−1) 的答案。
    // 则 F(i) 对应的转移方程应为
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) { // 循环遍历 (dp[i - coins[j]] + 1) 和 dp[i] 的大小
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];  // 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    }
}
