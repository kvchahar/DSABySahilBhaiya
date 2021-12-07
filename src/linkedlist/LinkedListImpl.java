package linkedlist;

public class LinkedListImpl {

    private Node head;

    public void add(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void createNodes() {
        Node node1 = new Node(34);
        Node node2 = new Node(11);
        Node node3 = new Node(84);
        Node node4 = new Node(10);
        Node node5 = new Node(55);

        head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
    }

    public Node array() {
        Node current = head;
        int[] arr = {7, 1, 35, 33, 45};
        Node dummyNode = new Node(-1);
//        head = new Node();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            Node newNode = new Node(value);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
        }
        return dummyNode.next;
    }

    public Node addNodeAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public Node addNodeInetweenTwoNodes(Node newNode, Node n1, Node n2) {
        n1.next = newNode;
        newNode.next = n2;
        return head;
    }

    public Node addNodeAtEnd(Node newNode) {
        Node current = head;

        if (current == null) {
            return newNode;
        }
        while (current != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public Node addNodeAfterNode(Node newNode, Node n1) {
        Node current = head;

        while (current != null && current != n1) {
            current = current.next;
        }

        Node tempNode = current.next;
        current.next = newNode;
        newNode.next = tempNode;
        return head;
    }

    public Node deleteAtFront() {

        if (head == null) {
            return head;
        }
        Node tempNode = head.next;
        head.next = null;
        head = tempNode;
        return head;
    }

    public Node deleteFromEnd() {

        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node prev = dummyNode;
        Node current = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        return dummyNode.next;
    }
}
