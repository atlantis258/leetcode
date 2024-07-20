package com.atlantis.linkedList;

// 2.两数相加
// https://leetcode.cn/problems/add-two-numbers/solutions/435246/liang-shu-xiang-jia-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) { // 首次进入
                head = tail = new ListNode(sum % 10); // 生成节点
            } else { // 除了首次，后续都会进入
                tail.next = new ListNode(sum % 10); // 生成节点
                tail = tail.next;
            }
            carry = sum / 10; // carry则表示未发生 进一；carry=1，则表示发生了 进一，下一轮循环会参与计算

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) { // 如果循环结束，carry仍然有进1，则说明最大位的值为1
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
