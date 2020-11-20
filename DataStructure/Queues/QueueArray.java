/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Queues;


/**
 *
 * @author promise
 */
public class QueueArray {

    private int front;
    private int rear;
    private int size;
    private int maxSize;
    private static final int DEFAULT_CAPACITY = 5;
    private int[] queue;

    public QueueArray(){
        this(DEFAULT_CAPACITY);
    }
    public QueueArray(int maxSize){
        this.maxSize = maxSize;
        this.queue = new int[this.maxSize];
        front = 0;
        rear = 0;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (isEmpty()) {
            this.queue[rear++ % this.maxSize] = this.queue[front % this.maxSize] = value;
            size++;
            return;
        }

        if (isFull()) {
            System.out.println("queue is full");
            return;
        }

        this.queue[rear++ % this.maxSize] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty");
        }
        size--;
        return this.queue[front++ % this.maxSize];
    }

    public int front() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty!");
        }
        return this.queue[front % this.maxSize];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isFull() {
        return (rear % this.maxSize) == (front % this.maxSize);
    }
    
    public void clean(){
        this.front = this.rear = 0;
        this.size = 0;
        this.queue = new int[DEFAULT_CAPACITY];
        this.maxSize = DEFAULT_CAPACITY;
    }

    public void display() {
        if (isEmpty()) {
//            throw new NullPointerException("queue is empty");
            System.out.println("empty list");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.print(this.queue[i % this.maxSize] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray();

        System.out.println("adding vlaue");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.isFull());

        queue.display();
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());

        System.out.println("adding value");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println("front value is : " + queue.front());

        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());

        queue.display();
        System.out.println("size of the queue: " + queue.size());
    }
}
