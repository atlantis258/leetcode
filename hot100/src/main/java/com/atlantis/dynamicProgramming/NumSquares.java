package com.atlantis.dynamicProgramming;

// 279.完全平方数
// https://leetcode.cn/problems/perfect-squares/?envType=study-plan-v2&envId=top-100-liked

// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// n = 11 = 9 + 1 + 1
// n = 12 = 4 + 4 + 4
// n = 13 = 4 + 9
// n = 14 = 4 + 9 + 1
public class NumSquares {

    // f[i] 表示最少需要多少个数的平方来表示整数 i。
    // 这些数必然落在区间 [1,根号n]。我们可以枚举这些数，假设当前枚举到 j，那么我们还需要取若干数的平方，构成 i−j平方
    // 。此时我们发现该子问题和原问题类似，只是规模变小了。这符合了动态规划的要求，于是我们可以写出状态转移方程。
    public int numSquares(int n) {
        int[] f = new int[n + 1];  // 初始化为0值
        for (int i = 1; i <= n; i++) { // 计算每一个f(i)
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int n = 12;
        int i = numSquares.numSquares(n);
        System.out.println(i);
    }
}
