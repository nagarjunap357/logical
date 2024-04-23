package org.example.ds.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    int length = 0;

    public LinkedList() {
    }

    public LinkedList(int val) {
        Node node = new Node(val);
        head = node;
        tail = node;
        length++;
    }

    public void add(int val) {
        Node newNode = new Node(val);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {

            tail.next = newNode;
            tail = newNode;
//            tail.random = getNodeByIndex((int) (Math.random() * length));
        }
        length++;
    }

    public Node getNodeByIndex(int index) {
        if (length == 0 || index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = head.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
//            if (temp.random != null) {
//                System.out.print(":" + temp.random.val);
//            }
            temp = temp.next;
            if (temp != null) {
                System.out.print(":" + temp.val);
            }
            System.out.println();

        }
    }
}
