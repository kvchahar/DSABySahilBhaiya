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
}
