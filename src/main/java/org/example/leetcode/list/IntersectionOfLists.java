package org.example.leetcode.list;

public class IntersectionOfLists {

//    Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists.
//    The new list should be made with its own memory — the original lists should not be changed.

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(7);

        list2.add(1);
        list2.add(7);
        list2.add(8);
        list2.add(9);

        Node intersectionNode = getIntersection(list1.getNodeByIndex(0), list2.getNodeByIndex(0));


    }

    static Node getIntersection(Node a, Node b) {

        Node head = new Node(0);
        Node result = head;

        while (a != null && b != null) {

            if (a.val == b.val) {
                Node newNode = new Node(a.val);
                result.next = newNode;
                result = result.next;
                a = a.next;
                b = b.next;
            } else if (a.val < b.val) {
                a = a.next;
            } else if (a.val > b.val) {
                b = b.next;
            }
        }
        return head.next;
    }
}
