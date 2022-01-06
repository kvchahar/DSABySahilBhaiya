package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        ListNode midNode = midNode(head);
        ListNode newHead = midNode.next;
        midNode.next = null;
        newHead = reverse(newHead);

        ListNode current1 = head;
        ListNode current2 = newHead;

        ListNode forward1 = null;
        ListNode forward2 = null;

        while (current2 != null) {
            forward1 = current1.next;
            forward2 = current2.next;

            current1.next = current2;
            current2.next = forward1;

            current1 = forward1;
            current2 = forward2;
        }

    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }

        return prev;
    }

    public ListNode midNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }
}
