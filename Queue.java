import java.util.Scanner;

/**
 * Created by Pankaj on 08-03-2017.
 */

public class Queue {
    // A linked list implementation of queue
    private Node head;   // The head element of queue
    private Node rear;   // The rear element of queue

    private class Node{
        // Node defines a particular element of the queue
        int data;
        Node next;   // The next element in queue
        Node( int data){
            this.data = data;
            next = null;
        }

    }

    public boolean isEmpty(){
        // To Check if the queue is Empty to avoid null pointer errors
        if(head != null) return false;
        return true;
    }
    public void enqueue(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            head = temp;
            rear = temp;
        }
        else {
            rear.next = temp;
            rear = temp;
        }
    }
    public int dequeue() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        int data = head.data;
        head = head.next;
        if(head == null) rear = null;
        return data;
    }
    public int peek() throws EmptyQueueException{
        if(isEmpty()){
            throw  new EmptyQueueException();
        }
        return head.data;
    }


    private class EmptyQueueException extends Exception {
        // Implementation not required as the problem statement doesn't specify the action in case of empty queue
    }
    Queue(){
        head = null;
        rear = null;
    }


    // Demo of the implementation of queue according to specification provide in the problem statement
    public static void main(String[] args){
        Queue work_queue = new Queue();
        Scanner in = new Scanner(System.in);
        int ops = in.nextInt();     //Total number of operations
        int opcode;
        int data;
        for(int i = 0; i<ops; i++){
            opcode = in.nextInt();
            switch (opcode){
                case 1 :    // Enqueue operation
                {
                    data = in.nextInt();
                    work_queue.enqueue(data);
                    break;
                }
                case 2 :    // Dequeue operation
                {
                    try {
                        work_queue.dequeue();
                    } catch (EmptyQueueException e) {
                        System.err.println("Error : Can't perform dequeue. The queue is empty");
                    }
                    break;
                }
                case 3 :    // Peek operation
                {
                    try {
                        data = work_queue.peek();
                        System.out.println(data);
                    } catch (EmptyQueueException e) {
                        System.err.println("Error : Can't perform peek. The queue is empty");
                    }
                    break;
                }
            }
        }
    }
}