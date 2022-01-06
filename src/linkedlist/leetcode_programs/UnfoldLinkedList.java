package linkedlist.leetcode_programs;

import java.util.*;

public class UnfoldLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {

        ListNode firstHead = head;
        ListNode secondHead = head.next;

        ListNode firstPrevious = firstHead;
        ListNode secondPrevious = secondHead;

        while (secondPrevious != null && secondPrevious.next != null) {
            ListNode forward = secondPrevious.next;

            firstPrevious.next = forward;
            secondPrevious.next = forward.next;

            firstPrevious = firstPrevious.next;
            secondPrevious = secondPrevious.next;
        }
        firstPrevious.next = null;
        secondHead = reverse(secondHead);

        firstPrevious.next = secondHead;
    }

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}