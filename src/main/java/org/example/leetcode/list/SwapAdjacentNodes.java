package org.example.leetcode.list;

public class SwapAdjacentNodes {
    public static void main(String[] args) {

        Node l11 = new Node(1);
        Node l12 = new Node(4);
        Node l13 = new Node(5);
        l11.next = l12;
        l12.next = l13;

        Node l21 = new Node(1);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l24 = new Node(7);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        Node l31 = new Node(2);
        Node l32 = new Node(6);
        l31.next = l32;

        //swap nodes
        Node swapAdjacentNodes = swapAdjacentNodes(l21);
        Node.printNode(swapAdjacentNodes);

    }

    public static Node swapAdjacentNodes(Node head) {

        Node prevNode = new Node(0);    //Node situated before the two to-be-swapped nodes
        prevNode.next = head; //01347                  //Starting before head
        Node newHead = prevNode; // 01347           //Storing a reference for returning

        while (prevNode.next != null && prevNode.next.next != null) {

            //Declare                                           // ...[prev]-->[node1]-->[node2]-->[next]...
            Node node1 = prevNode.next; //1347
            Node node2 = node1.next; // 347
            Node nextNode = node2.next; // 47

            //Swap
            prevNode.next = node2; //0347                             // ...[prev]-->[node2]<--[node1]   [next]...
            node2.next = node1; // 31347                               // ...[prev]-->[node2]<-->[node1]  [next]...
            node1.next = nextNode; // 147                             // ...[prev]-->[node2]-->[node1]-->[next]...

            //Move
            prevNode = node1; //147                                   // ...[...]-->[node2]-->[node1/prev]-->[next]...
        }

        return newHead.next;
    }
}
