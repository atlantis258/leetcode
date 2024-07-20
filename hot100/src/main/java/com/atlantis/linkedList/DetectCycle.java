package com.atlantis.linkedList;

import java.util.HashSet;
import java.util.Set;

// 环形链表 II
// https://leetcode.cn/problems/linked-list-cycle-ii/solutions/441131/huan-xing-lian-biao-ii-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
public class DetectCycle {
    // 找出环的位置
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
