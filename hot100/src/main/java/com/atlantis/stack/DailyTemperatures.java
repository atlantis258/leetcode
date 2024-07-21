package com.atlantis.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 739.每日温度
// https://leetcode.cn/problems/daily-temperatures/?envType=study-plan-v2&envId=top-100-liked
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        // 单调栈满足从栈底到栈顶元素对应的温度递减，因此每次有元素进栈时，会将温度更低的元素全部移除，并更新出栈元素对应的等待天数，这样可以确保等待天数一定是最小的
        Deque<Integer> stack = new LinkedList<>(); // 存储元素对应的索引值

        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) { // 如果当前栈非空 且 当前温度 大于 栈顶索引对应的温度
                int prevIndex = stack.pop(); // 将栈顶索引弹出
                ans[prevIndex] = i - prevIndex; // 跟新栈顶索引对应的after值
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        // [73,74,75,71,69,72,76,73]  ->  [1,1,4,2,1,1,0,0]
        // [30,40,50,60]  ->  [1,1,1,0]
        // [30,60,90]  ->  [1,1,0]
        int[] temperature = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures.dailyTemperatures(temperature);
        System.out.println(Arrays.toString(ans));
    }
}
