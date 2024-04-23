package org.example.leetcode.list;

public class ListQuickSort {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(4);

        Node n = list.head;
        while (n.next != null) {
            n = n.next;
        }
        System.out.println("Linked List before sorting");
        list.printList();
        sort(list.head, n);
        System.out.println("\nLinked List after sorting");
        list.printList();
    }


    static Node partitionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.val;

        // Iterate till pen-ultimate node, since the last node is the PIVOT

        while (start != end) {
            System.out.println("start: "+ start.val);
            if (start.val < pivot) {
                System.out.println("start.val lessThan pivot: " +start.val+"<"+pivot);
                pivot_prev = curr;
                int temp = curr.val;
                curr.val = start.val;
                start.val = temp;
                curr = curr.next;
            }
            start = start.next;
        }

// swap whichever is following suitable index and pivot

        int temp = curr.val;
        curr.val = pivot;
        end.val = temp;

        return pivot_prev;
    }

    static void sort(Node start, Node end)
    {
        if(start == null || start == end|| start == end.next )
            return;

        // split list and partition recurse

        Node pivot_prev = partitionLast(start, end);
        sort(start, pivot_prev);

        // If PIVOT = START, we pick from next of PIVOT.

        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

            // If PIVOT is still in between the list, start from next to pivot since we have pivot_prev, so we move two nodes.

        else if (pivot_prev != null
                && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }
}
