package com.atlantis.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 438.找到字符串中所有字母异位词
// https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen)
            return new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> ans = new ArrayList<>();
        // 使用数组来存储字符串 p 和滑动窗口中每种字母的数量
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) { // 如果两个数组相同 （注意关注Arrays.equals(s,p)方法）
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a']; // 去除首元素
            ++sCount[s.charAt(i + pLen) - 'a']; // 添加后一个元素，以保证两个数组的数量一致

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams.findAnagrams(s, p);
    }
}
