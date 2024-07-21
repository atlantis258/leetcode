package com.atlantis.stack;

// 394.字符串解码
// https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked

import java.util.Collections;
import java.util.LinkedList;

// 给定一个经过编码的字符串，返回它解码后的字符串。
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
public class DecodeString {

    // 可能出现括号嵌套的情况，比如 2[a2[bc]]，这种情况下我们可以先转化成 2[abcbc]，在转化成 abcbcabcbc。我们可以把字母、数字和括号看成是独立的 TOKEN，并用栈来维护这些 TOKEN。

    // 遍历这个栈：
    // 如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
    // 如果当前的字符为字母或者左括号，直接进栈
    // 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字（此时栈顶一定是数字，想想为什么？），就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
    //
    // 重复如上操作，最终将栈中的元素按照从栈底到栈顶的顺序拼接起来，就得到了答案。注意：这里可以用不定长数组来模拟栈操作，方便从栈底向栈顶遍历。

    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) { // 如果当前元素是数字
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') { // 如果当前元素是字母或者是 [
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else { // 如果当前元素是 ]
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) { // 一直迭代直到遇到 [
                    sub.addLast(stk.removeLast());
                }
                // 出栈序列反转
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();

                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }

                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    // 获取数字
    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    // 获取字符串
    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        // 3[a]2[bc]  ->  aaabcbc
        // 3[a2[c]]   ->  accaccacc
        // 2[abc]3[cd]ef   ->  abcabccdcdcdef
        // abc3[cd]xyz   ->  abccdcdcdxyz
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();
        String s1 = decodeString.decodeString(s);
        System.out.println(s1);
    }
}
