package com.atlantis.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 20.有效的括号
// https://leetcode.cn/problems/valid-parentheses/solutions/373578/you-xiao-de-gua-hao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 每个右括号都有一个对应的相同类型的左括号。
public class IsValid {

    public boolean isValid(String s) {
        int n = s.length();
        // 有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程
        if (n % 2 == 1) {
            return false;
        }

        // 为了快速判断括号的类型，我们可以使用哈希表存储每一种括号。哈希表的键为右括号，值为相同类型的左括号。
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>(); // 存储左括号
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) { // 如果当前元素是 右括号
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) { // 如果栈为空 或者 栈顶元素 和 当前元素不匹配
                    return false;
                }
                stack.pop(); // 如果匹配，则弹出栈顶元素
            } else { // 如果当前元素是 左括号，则进栈
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String s = "([{}])";
        boolean valid = isValid.isValid(s);
        System.out.println(valid);
    }
}
