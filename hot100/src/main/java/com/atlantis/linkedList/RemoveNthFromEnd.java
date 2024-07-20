package com.atlantis.linkedList;

// 19.删除链表的倒数第N个节点
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-100-liked
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); // 不用特殊处理head节点
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        // for循环结束，则找到倒数第N - 1个节点
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 获取链表的长度
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
