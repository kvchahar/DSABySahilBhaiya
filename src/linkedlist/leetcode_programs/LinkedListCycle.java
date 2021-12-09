package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        if(head==null || head.next==null){
            return false;
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr.next!=null && fastPtr.next.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr==slowPtr){
                return true;
            }
        }
        return false;
    }
}
