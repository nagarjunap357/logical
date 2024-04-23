package org.example.leetcode.array;

public class AddTwoNumbers {

//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//            Example:
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.

    public static void main(String[] args) {

        Node l1 = new Node(2);
        Node l12 = new Node(4);
        Node l13 = new Node(3);
        l1.next = l12;
        l12.next = l13;

        Node l2 = new Node(5);
        Node l22 = new Node(6);
        Node l23 = new Node(4);
        l2.next = l22;
        l22.next = l23;

        Node result = addTwoNumbers(l1, l2);
        result.print();
    }

    static Node addTwoNumbers(Node l1, Node l2){

        Node result  = new Node(0);
        Node ptr = result;
        int carry =0;

        while (l1 != null || l2 != null){
            int sum = carry;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum/10;
            sum = sum%10;
            ptr.next= new Node(sum);
            ptr = ptr.next;
        }
        if (carry == 1) ptr.next = new Node(1);

        return result.next;
    }
}

class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    void print(){
        Node Node = this;
        while(Node != null){
            System.out.println(Node.val);
            Node = Node.next;
        }
    }
}

