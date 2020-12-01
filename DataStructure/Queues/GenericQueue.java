/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Queues;

import java.util.ArrayList;


/**
 *
 * @author promise
 */
public class GenericQueue<E> {
    private ArrayList<E> queue;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 20;
    
    public GenericQueue(){
        this(DEFAULT_CAPACITY);
    }
    public GenericQueue(int capacity){
        this.queue = new ArrayList<>(capacity);
        this.front = 0;
        this.rear = 0;
    }
    
    public void enqueue(E val){
        this.queue.add(val);
    }
    
    public E dequeue(){
        if(queue.isEmpty()){
            throw new NullPointerException("queue is empty!!!");
        }else{
            return this.queue.get(front++);
        }
    }
    
    public E peek(){
        if(isEmpty()){
            throw new NullPointerException("no node exits in the tree");
        }
        return this.queue.get(front);
    }
    
    public boolean isEmpty(){
        return this.front == this.queue.size();
    }
    
    public int getSize(){
        return this.queue.size();
    }
    
    public void display(){
        if(isEmpty()) {
            System.out.println("queue is emtpy");
            return;
        }
        for(int i = front; i<this.queue.size();i++){
            Node n = (Node) this.queue.get(i);
            System.out.print(n.val + " ");
        }
        System.out.println("");
    }
    
    
    public static void main(String[] args) {
        GenericQueue<Node> queue = new GenericQueue<>();
        queue.enqueue(new Node(10));
        queue.enqueue(new Node(20));
        queue.enqueue(new Node(30));
        
        queue.display();
        
        queue.dequeue();
        queue.display();
        Node n = queue.peek();
        System.out.println("peek is "+ n.val);
    }
}

class Node{
    int val;
    Node left,right;
    public Node(int val){
        this.val = val;
        this.left = this.right = null;
    }
}
