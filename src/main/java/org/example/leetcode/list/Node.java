package org.example.leetcode.list;

public class Node {
    int val;
    Node next;
//    Node random;

    public Node(int val) {
        this.val = val;
    }

    static void printNode(Node l) {
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println();
    }
}


