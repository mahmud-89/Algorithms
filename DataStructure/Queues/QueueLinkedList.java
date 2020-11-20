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
public class QueueLinkedList {
    class Node{
        int value;
        Node next;
        
        public Node(int value){
            this.value = value;
        }
    }
    
    private Node front;
    private Node rear;
    private int size;
    
    public QueueLinkedList(){
        this.size = 0;
    }
    
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            rear = newNode;
            front = rear;
            size++;
            return;
        }
        
        while(rear.next!=null){
            rear = rear.next;
        }
        rear.next = newNode;
        size++;
    }
    
    public int dequeue(){
       if(isEmpty()){
           throw new NullPointerException("queue is empty!!");
       } 
       int data = front.value;
       front = front.next;
       size--;
       return data;
    }
    
    public int front(){
        return front.value;
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public void clear(){
        this.rear = this.front = null;
        this.size = 0;
    }
    
    public void display(){
        if(isEmpty()){
            throw new NullPointerException("queue is empty!!");
        }
        Node cur = front;
        while(cur!= null){
            System.out.print(cur.value +" ");
            cur = cur.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        System.out.println("adding value...");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println("front value is: "+ queue.front());
        System.out.println("size of the queue: "+queue.size());
        
        System.out.println("Dequeue: "+queue.dequeue());
        System.out.println("Dequeue: "+queue.dequeue());
        System.out.println("Dequeue: "+queue.dequeue());
        System.out.println("size of the queue: "+queue.size());
        
        System.out.println("adding value...");
        queue.enqueue(10);
        queue.display();
        
        System.out.println("size of the queue: "+queue.size());
    }
}
