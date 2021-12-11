package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-101);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode current = head;
        while(current!=null){
            if(current.val==prev.val){
                prev.next = current.next;
                current = current.next;
            }else{
                prev = current;
                current = current.next;
            }
        }
        return dummyNode.next;
    }
}
