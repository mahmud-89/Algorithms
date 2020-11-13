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
public class SinglyLinkedList {

    private int size;
    private Node head;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }   

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            Node toInsert = head;
            while (toInsert.next != null) {
                toInsert = toInsert.next;
            }
            toInsert.next = newNode;
            size++;
        }
    }

    public void insertNth(int position, int value) {
        if (boundaryCheck(position)) {
            return;
        }
        System.out.println(String.format("inserting value %d at position %d", value, position));
        Node newNode = new Node(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            Node inNode = temp.next;
            temp.next = newNode;
            newNode.next = inNode;
            size++;
        }
    }

    public void deleteNth(int position) {
        if (boundaryCheck(position)) {
            return;
        }

        if (position == 1) {
            Node temp = head;
            head = head.next;
            System.out.println(String.format("%d is deleted from postion %d", temp.value, position));
            size--;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            Node destroy = temp.next;
            System.out.println(String.format("%d is deleted from postion %d", destroy.value, position));
            temp.next = temp.next.next;
        }

    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void print() {
        Node temp = head;
        if (temp == null) {
            System.out.println("there is no element in the list");
        } else {
            System.out.println("Current list elements are:");
            while (temp.next != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
            System.out.println(temp.value);
        }

        System.out.println("current size: " + size());
        System.out.println("");
    }

    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean boundaryCheck(int position) {
        if (position < 1 || position > size()) {
            System.out.println("Invalid position! please input correct position");
            return true;
        }
        return false;
    }
    
    public Node getHead(){
        return this.head;
    }
    
    public Node getNode(int position){
        validatePosition(position,0,size());
        Node cur = head;
        for(int i = 1;i<position-1;i++){
            cur = cur.next;
        }
        System.out.println(String.format("%d is found from position %d", cur.next.value,position));
        return cur.next;
    }
    
    public void validatePosition(int position,int low,int high){
        if(position<low || position>high){
            throw new IndexOutOfBoundsException(position+" ");
        }
    }
    
    @Override
    public String toString(){
        if(size == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = head;
        while(cur!=null){
            builder.append(cur.value).append("->");
            cur = cur.next;
        }
//        return builder.replace(builder.length()-2, builder.length(), "").toString();
        return builder.replace(builder.length()-1, builder.length(), "").toString();
    }
    

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(10);
        sll.insert(20);
        sll.insert(30);
        sll.insert(40);
        System.out.println(sll.toString());
        System.out.println("");
        sll.print();

        sll.deleteNth(sll.size());
        sll.print();

        sll.insertNth(sll.size(), 25);
        sll.print();

        System.out.println("isEmpty: " + sll.isEmpty());
        sll.getNode(3);

    }

}

class Node {

    int value;
    Node next;

    Node() {
    }

    Node(int value) {
        this(value, null);
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

}
