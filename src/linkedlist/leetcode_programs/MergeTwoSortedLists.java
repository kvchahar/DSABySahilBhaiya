package linkedlist.leetcode_programs;


import linkedlist.leetcode_programs.node.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummyNode = new ListNode(-101);
        ListNode head = dummyNode;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                ListNode newNode = new ListNode(list1.val);
                dummyNode.next = newNode;
                list1 = list1.next;
            } else {
                ListNode newNode = new ListNode(list2.val);
                dummyNode.next = newNode;
                list2 = list2.next;
            }
            dummyNode = dummyNode.next;
        }
        if (list1 != null) {
            dummyNode.next = list1;
        }
        if (list2 != null) {
            dummyNode.next = list2;
        }
        return head.next;
    }
}