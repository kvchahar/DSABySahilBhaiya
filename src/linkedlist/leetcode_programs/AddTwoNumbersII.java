package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        int carry = 0;
        int sum = 0;

        while(l1!=null && l2!=null){
            int firstValue = l1.val;
            int secondValue = l2.val;
            sum = firstValue + secondValue + carry;
            carry = sum / 10;
            sum %= 10;

            ListNode newNode = new ListNode(sum);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            sum = l1.val + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l1 = l1.next;

        }

        while(l2!=null){
            sum = l2.val + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
            l2 = l2.next;
        }
        if(carry==1){
            ListNode newNode = new ListNode(1);
            dummyNode.next = newNode;
        }
        return reverseList(head.next);
    }


    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
