package com.atlantis.linkedList;

// 24.两两交换链表中的节点
// https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/444474/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-91/?envType=study-plan-v2&envId=top-100-liked
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1; // temp指针后移两位，指向 node1
        }
        return dummyHead.next; // 返回原来的头节点 head
    }
}
