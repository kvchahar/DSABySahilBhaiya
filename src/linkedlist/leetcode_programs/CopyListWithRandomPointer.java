package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.Node;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node dummyNode = new Node(-1000001);
        Node runner = dummyNode;
        Node current = head;

        HashMap<Node,Node> map = new HashMap<>();

        while(current!=null){
            Node newNode = new Node(current.val);
            runner.next = newNode;
            map.put(current,newNode);
            current = current.next;
            runner = runner.next;

        }

        current = head;
        runner = dummyNode.next;

        while(current!=null){
            if(current.random!=null){
                runner.random = map.get(current.random);
            }
            runner = runner.next;
            current = current.next;
        }

        return dummyNode.next;
    }
}
