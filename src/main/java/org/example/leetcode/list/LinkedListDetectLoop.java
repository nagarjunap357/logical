package org.example.leetcode.list;

public class LinkedListDetectLoop {

    //    1->5->2->8->3
    //          |7<-4<-


    //detect if the loop exists
    static boolean detectLoop(Node head) {

        Node slowPointer = head, fast_pointer = head;

        while (slowPointer != null && fast_pointer != null && fast_pointer.next != null) {

            slowPointer = slowPointer.next;
            fast_pointer = fast_pointer.next.next;

            if (slowPointer == fast_pointer) {
                return true;
            }
        }
        return false;
    }

    //return length of the loop if loop exist
    static int getLoopLength(Node head) {
        Node slowPointer = head, fast_pointer = head;

        while (slowPointer != null && fast_pointer != null & fast_pointer.next != null) {

            slowPointer = slowPointer.next;
            fast_pointer = fast_pointer.next.next;

            if (slowPointer == fast_pointer) {
                return countLoopLength(slowPointer);
            }
        }

        return 0;
    }

    static int countLoopLength(Node node) {
        Node temp = node;
        int count = 1;
        while (temp.next != node) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
