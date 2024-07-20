package com.atlantis.linkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
