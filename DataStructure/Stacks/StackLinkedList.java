/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Stack;


import java.util.EmptyStackException;

/**
 *
 * @author promise
 */
public class StackLinkedList<T> {
   class Node<T>{
       T value;
       Node<T> next;
       public Node(T value){
          this.value = value;
       }
   }
   
   private Node<T> head;
   private int size;
   
   public StackLinkedList(){
       this.size = 0;
   }
   
   public void push(T value){
       Node<T> newNode = new Node<>(value);
       newNode.next = head;
       head = newNode;
       size++;
   }
   
   public T peek(){
       if(head == null){
           throw new EmptyStackException();
       }
       return head.value;
   }
   
   public T pop(){
       if(head == null){
           throw new EmptyStackException();
       }
       T data = head.value;
       head = head.next;
       size--;
       return data;
   }
   
   public int size(){
       return this.size;
   }
   
   public boolean isEmpty(){
       return this.size == 0;
   }
   
   public void clean(){
       this.head = null;
       this.size = 0;
   }
   
   public void traverse(){
       if(head == null){
           throw new EmptyStackException();
       }
       Node<T> cur = head;
       while(cur != null){
           System.out.print(cur.value+" ");
           cur = cur.next;
       }
       System.out.println("");
   }
   
    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        stack.traverse();
        System.out.println("peek value: "+ stack.peek());
        System.out.println("pop: "+stack.pop());
        stack.traverse();
        System.out.println("size of the list: "+stack.size());
        
        stack.clean();
        
    }
}
