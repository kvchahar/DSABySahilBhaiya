package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class DeleteDuplicatesInSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyNode = new ListNode(-1);
        ListNode current = head;
        ListNode prev = dummyNode;
        dummyNode.next = head;

        boolean flag = true;

        while(current!=null && current.next!=null){
            if(current.next.val==current.val){
                prev.next = current.next.next;
                current = current.next;
                flag = false;
            }else{
                if(flag)
                    prev = prev.next;
                current = current.next;
                flag = true;
            }
        }
        return dummyNode.next;
    }
}