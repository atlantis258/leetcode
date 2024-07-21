package com.atlantis.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 84.柱状图中最大的矩形
// https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/266844/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/?envType=study-plan-v2&envId=top-100-liked
public class LargestRectangleArea {

    // 方法一：单调栈
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; // 存储元素对应的索引值
        int[] right = new int[n]; // 存储元素对应的索引值

        Deque<Integer> mono_stack = new ArrayDeque<>();
        // 从左到右遍历，填充左列表
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) { // 如果栈非空，且栈顶元素大于当前元素，则栈顶元素出栈
                mono_stack.pop();
            }
            // 如果栈内元素为空，说明当前元素左侧没有小于当前元素的值，默认为-1
            // 如果栈非空，则栈顶 即为第一个小于当前元素值的索引值
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i); // 当前元素对应的索引值入栈
        }

        // 从右到左遍历，填充右列表
        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {  // 如果栈非空，且栈顶元素大于当前元素，则栈顶元素出栈
                mono_stack.pop();
            }
            // 如果栈内元素为空，说明当前元素右侧没有小于当前元素的值，默认为n
            // 如果栈非空，则栈顶 即为第一个小于当前元素值的索引值
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i); // 当前元素对应的索引值入栈
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    // 方法二：单调栈 + 常数优化
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; // 存储元素对应的索引值
        int[] right = new int[n]; // 存储元素对应的索引值
        Arrays.fill(right, n);

        Deque<Integer> mono_stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i; // 满足出栈条件，则 mono_stack.peek()索引处 右边 第一个小于的索引值为 i （比较是相互的）
                mono_stack.pop(); // 栈顶元素出栈
            }
            // 如果栈内元素为空，说明当前元素左侧没有小于当前元素的值，默认为-1
            // 如果栈非空，则栈顶 即为第一个小于当前元素值的索引值
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i); // 当前元素对应的索引值入栈
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            // left[] 从当前元素，向左遍历找到 小于当前元素 的第一个索引值
            // right[] 从当前元素，向右遍历找到 小于当前元素 的第一个索引值
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]); // 最大宽 * 当前高
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int[] height = {2,1,5,6,2,3};
        int res = largestRectangleArea.largestRectangleArea(height);
        System.out.println(res);
    }
}
