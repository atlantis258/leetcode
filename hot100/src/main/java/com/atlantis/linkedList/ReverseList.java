package com.atlantis.linkedList;

// 206.反转链表
// https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // 获取后一个节点的位置
            curr.next = prev; // 链表反转
            prev = curr; // 标记当前节点的位置
            curr = next; // 当前节点指针后移
        }
        return prev;
    }
}
