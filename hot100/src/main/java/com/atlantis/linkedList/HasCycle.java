package com.atlantis.linkedList;

import java.util.HashSet;
import java.util.Set;

// 141.环形链表
// https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked
public class HasCycle {
    // 判断是否有环
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) { // 如果添加失败，则说明有环
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
