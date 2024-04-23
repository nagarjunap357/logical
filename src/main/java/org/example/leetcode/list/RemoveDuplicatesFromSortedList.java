package org.example.leetcode.list;

public class RemoveDuplicatesFromSortedList {

    void removeDuplicates(Node head){

        Node curr = head;

        while(curr != null){

            Node temp = curr;

            while(temp != null && temp.val == curr.val){
                    temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;

        }
    }
}
