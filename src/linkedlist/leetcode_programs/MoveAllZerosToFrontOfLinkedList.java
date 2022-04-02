package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class MoveAllZerosToFrontOfLinkedList {
    public ListNode moveZeroes(ListNode head) {
        ListNode zeros = new ListNode(-1);
        ListNode zero = zeros;
        ListNode nonZeros = new ListNode(-1);
        ListNode nonZero = nonZeros;

        ListNode current = head;
        while (current != null) {
            if (current.val == 0) {
                ListNode newNode = new ListNode(current.val);
                zero.next = newNode;
                zero = zero.next;
            } else {
                ListNode newNode = new ListNode(current.val);
                nonZero.next = newNode;
                nonZero = nonZero.next;
            }
            current = current.next;
        }
        zero.next = nonZeros.next;

        return zeros.next;
    }
}
