package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class LinkedListMiddle {
    public ListNode middleNode(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr.next!=null && fastPtr.next.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        if(fastPtr.next!=null){
            return slowPtr.next;
        }
        return slowPtr;
    }
}
