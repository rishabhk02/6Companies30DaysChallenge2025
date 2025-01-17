package Google;

import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                q.add(lists[i]);
        }
        ListNode head = null;
        ListNode prev = null;
        while (!q.isEmpty()) {
            ListNode cur = q.poll();
            if (prev == null) {
                head = cur;
                prev = cur;
            } else {
                prev.next = cur;
                prev = cur;
            }
            if (cur.next != null) {
                q.add(cur.next);
            }
        }
        return head;
    }
}