package com.atlantis.greedyAlgorithm;

// 121.买卖股票的最佳时机
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-100-liked

// 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
public class MaxProfit {

    // 需要找出给定数组中两个数字之间的最大差值（即，最大利润）。此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
    // 形式上，对于每组 i 和 j（其中 j>i）我们需要找出 max(prices[j]−prices[i])。

    // 方法二：一次遍历
    // 只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE; // 最低价格
        int maxprofit = 0; // 最大利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i]; // 更新最低价格
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice; // 更新最大利润
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        int max = maxProfit.maxProfit(prices);
        System.out.println(max);
    }

    // 方法一：暴力法【超时】
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}
