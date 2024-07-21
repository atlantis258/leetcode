package com.atlantis.stack;

// 155.最小栈
// https://leetcode.cn/problems/min-stack/?envType=study-plan-v2&envId=top-100-liked

import java.util.Deque;
import java.util.LinkedList;

// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 实现 MinStack 类:
//
// MinStack() 初始化堆栈对象。
// void push(int val) 将元素val推入堆栈。
// void pop() 删除堆栈顶部的元素。
// int top() 获取堆栈顶部的元素。
// int getMin() 获取堆栈中的最小元素。
public class MinStack {

    // 那么，我们可以在每个元素 a 入栈时把当前栈的最小值 m 存储起来。在这之后无论何时，如果栈顶元素是 a，我们就可以直接返回存储的最小值 m。
    // 只需要设计一个数据结构，使得每个元素 a 与其相应的最小值 m 时刻保持一一对应。因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。

    // 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
    // 当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
    // 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。

    Deque<Integer> xStack; // 元素栈
    Deque<Integer> minStack; // 辅助栈

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    // 元素入栈
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x)); // 辅助栈的栈顶值（最小值）和当前值进行比较，谁小谁入栈 辅助栈
    }

    // 元素出栈
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    // 获取栈顶元素
    public int top() {
        return xStack.peek();
    }

    // 获取栈内的最小值（即辅助栈的栈顶元素）
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(3);
        obj.pop();
        int top = obj.top();
        int min = obj.getMin();

    }
}
