package com.atlantis;

import java.util.*;

// 49. 字母异位词分组
// https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
public class Test2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        test2.groupAnagrams(strs);
        System.out.println(test2.groupAnagrams(strs));
    }
}
