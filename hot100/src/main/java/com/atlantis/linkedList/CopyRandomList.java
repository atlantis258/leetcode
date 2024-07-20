package com.atlantis.linkedList;

import java.util.HashMap;
import java.util.Map;

// 138.复制带随机指针的链表
// https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/889166/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/?envType=study-plan-v2&envId=top-100-liked
public class CopyRandomList {
    Map<Node, Node> cachedNode = new HashMap<>(); // key存储当前节点，value存储当前节点的值、next、random

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
