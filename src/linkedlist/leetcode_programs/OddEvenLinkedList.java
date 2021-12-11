package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        boolean isOdd = true;
        ListNode oddDummyNode = new ListNode(-1);
        ListNode evenDummyNode = new ListNode(-1);

        ListNode current = head;
        ListNode current1 = oddDummyNode;
        ListNode current2 = evenDummyNode;

        while(current!=null){
            if (isOdd){
                ListNode newNode = new ListNode(current.val);
                current1.next = newNode;
                current1 = current1.next;
                isOdd = false;
            }else{
                ListNode newNode = new ListNode(current.val);
                current2.next = newNode;
                current2 = current2.next;
                isOdd = true;
            }
            current = current.next;
        }
        current1.next = evenDummyNode.next;

        return oddDummyNode.next;
    }
}
