package org.example.ds.queue;

public class Queue {

    QNode front;
    QNode rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int val) {

        QNode node = new QNode(val);
        if (front == null) {
            front = node;
            rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public void dequeue() {
        if (front == null) return;

        QNode node = front.next;
        front.next = null;
        front = node;
        if (front == null) {
            rear = null;
        }
    }

    public void printQueue(){
        if(front == null){
            System.out.print("[]");
            return;
        }
        QNode temp = front;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.val);
            temp = temp.next;
            if(temp != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
