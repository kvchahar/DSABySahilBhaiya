package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nthNode = size(head) - n + 1;
        ListNode temp = head;
        ListNode prev = null;
        int i = 1;
        if(nthNode==1){
            return temp.next;
        } else {
            while(i<nthNode){
                prev = temp;
                temp = temp.next;
                i++;
            }
            prev.next = temp.next;
            return head;
        }
    }

    public int size(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}
