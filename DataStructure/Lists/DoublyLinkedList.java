/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Lists;

/**
 *
 * @author promise
 */
public class DoublyLinkedList implements IDoublyFeatures {

    class Node {

        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

    }

    private int size;
    private Node head;
    private Node tail;

    @Override
    public void insertHead(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            head.prev = tail.next = null;
            size++;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = null;
        head = newNode;
        size++;
    }

    @Override
    public void insertTail(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            insertHead(value);
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;
        size++;
    }

    @Override
    public void insertNth(int index, int value) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " size: " + size());
        }
        if (index == 0) {
            insertHead(value);
            return;
        } else if (index == size()) {
            insertTail(value);
            return;
        }
        Node newNode = new Node(value);
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        cur.next.next.prev = cur;
        size++;
    }

    @Override
    public void insertOrdered(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteHead() {
        if(head == null) {
            throw  new NullPointerException("empty list");
        }
        head = head.next;
        if(head == null){
            tail = null;
        }else{
            head.prev = null;
        }
        size--;
    }

    @Override
    public void deleteTail() {
        if(isEmpty()) throw new NullPointerException("Empty list! ");
        tail = tail.prev;
        if(tail == null){
            head = null;
        }else {
            tail.next = null;
        }
        size--;
    }

    @Override
    public void deleteNth(int index) {
        if(index >=size() || index < 0){
            throw new IndexOutOfBoundsException("input index is not in range of the list");
        }
        if(index == 0){
            deleteHead();
            return;
        }else if(index == size()-1){
            deleteTail();
            return;
        }
        Node cur = head;
        for(int i = 0;i<index-1;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        cur.next.prev = cur;
        size--;
    }

    @Override
    public void deleteValue(int searchValue) {
        Node cur = head;
        
        while(cur.value != searchValue){
            if(cur != tail){
                cur = cur.next;
            }else{
                throw new RuntimeException("the element is not found in the list");
            }
        }
        
        if(cur == head) deleteHead();
        else if (cur == tail) deleteTail();
        else{
            cur.prev.next = cur.next;
            cur.prev = cur;
            size--;
        }
       
        
    }

    @Override
    public int getValue(int index) {
        Node cur = head;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur.value;
    }

    @Override
    public int getHead() {
        if(!isEmpty()){
            return head.value;
        }
        throw new NullPointerException("empty list");
    }

    @Override
    public int getTail() {
        if(!isEmpty()){
            return tail.value;
        }
        throw new NullPointerException("Empty list");
    }

    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public void clearList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head != null) {
            Node cur = head;
            while (cur != null) {
                sb.append(cur.value).append("->");
                cur = cur.next;
            }
            return sb.replace(sb.length() - 2, sb.length(), "").toString();
        }
        return "list is empty";
    }

    public String reversePrint() {
        StringBuilder sb = new StringBuilder();
        Node cur = tail;
        if (head != null) {
            while (cur != null) {
                sb.append(cur.value).append("->");
                cur = cur.prev;
            }
            return sb.replace(sb.length() - 2, sb.length(), "").toString();
        }
        return "list is empty";
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        dll.insertHead(20);
        dll.insertHead(30);
        dll.insertTail(40);
        dll.insertNth(3, 10);
        System.out.println(dll.toString());
        //dll.deleteHead();
        //dll.deleteHead();
        //dll.deleteHead();
        //dll.deleteHead();
       // dll.deleteTail();
        //dll.deleteTail();
       
       // dll.deleteNth(0);
        //dll.deleteNth(0);
        //dll.deleteNth(0);
        //dll.deleteNth(0);
        dll.deleteValue(10);
        dll.deleteValue(30);
        dll.deleteValue(20);
        //dll.deleteValue(40);
        System.out.println(dll.getHead());
        System.out.println(dll.getTail());
        System.out.println("size of the list: "+dll.size());
        
        System.out.println(dll.toString());
        System.out.println(dll.reversePrint());
        
        
        
        
    }
}
