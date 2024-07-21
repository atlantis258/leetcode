package com.atlantis.dynamicProgramming;

// 70.爬楼梯
// https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked
public class ClimbStairs {

    // 用 f(x) 表示爬到第 x 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶
    // f(x)=f(x−1)+f(x−2)
    // 爬到第 x 级台阶的方案数是爬到第 x−1 级台阶的方案数和爬到第 x−2 级台阶的方案数的和
    // 每次只能爬 1 级或 2 级，所以 f(x) 只能从 f(x−1) 和 f(x−2) 转移过来，而这里要统计方案总数，我们就需要对这两项的贡献求和。

    // 边界条件：
    // 从第 0 级爬到第 0 级我们可以看作只有一种方案，即 f(0)=1；
    // 从第 0 级到第 1 级也只有一种方案，即爬一级，f(1)=1
    // 这两个作为边界条件就可以继续向后推导出第 n 级的正确结果。
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int f0;
        int f1 = 1;
        int fcur = 2;
        for (int i = 2; i < n; i++) {
            f0 = f1;
            f1 = fcur;
            fcur = f0 + f1;
        }
        return fcur;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = 3;
        int count = climbStairs.climbStairs(n);
        System.out.println(count);
    }

    // 答案解法
    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
