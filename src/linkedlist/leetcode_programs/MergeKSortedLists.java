package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class MergeKSortedLists {

        public ListNode mergeTwo(ListNode l1, ListNode l2){

            if(l1==null || l2 ==null){
                return l1!=null?l1:l2;
            }

            ListNode dummyNode = new ListNode(-1);
            ListNode head = dummyNode;
            ListNode current1 = l1;
            ListNode current2 = l2;

            while(current1!=null && current2!=null){
                if(current1.val<current2.val){
                    ListNode newNode = new ListNode(current1.val);
                    head.next = newNode;
                    current1 = current1.next;
                }else{
                    ListNode newNode = new ListNode(current2.val);
                    head.next = newNode;
                    current2 = current2.next;
                }
                head = head.next;
            }
            head.next = current1!=null?current1:current2;

            return dummyNode.next;

        }

        public ListNode mergeKList(ListNode[] lists, int start, int end) {
            if(start>end) return null;

            if(start==end) return lists[start];

            int mid = (start + end) / 2;

            ListNode l1 = mergeKList(lists,start,mid);
            ListNode l2 = mergeKList(lists,mid+1,end);

            return mergeTwo(l1,l2);
        }

        public ListNode mergeKLists(ListNode[] lists){
            if(lists.length==0){
                return null;
            }
            return mergeKList(lists, 0, lists.length-1);
        }

}
