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

public class CircularLinkedList {

    final class Node {

        int value;
        Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    
    //insert at last position of the list
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
        size++;
    }
    
    public void insertFirst(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = tail = newNode;
            newNode.next = head;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
        size++;
    }

    public void deleteNode(int valueToDelete) {
        if (head == null) {
            System.out.println("no list exits");
            return;
        } else if (head.value == valueToDelete) {
            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        Node cur = head;
        do {
            if (cur.next.value == valueToDelete) {
                cur.next = cur.next.next;
                size--;
                break;
            }
            cur = cur.next;
        } while (cur != head);
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("no list exits");
            return;
        }
        head = head.next;
        tail.next = head;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("no list exists");
            return;
        }
        Node cur = head;
        do {
            if (cur.next.value == tail.value) {
                cur.next = tail.next;
                tail = cur.next;
                size--;
                break;
            }
            cur = cur.next;
        } while (cur != head);
    }
    
    

    public int getTail() {
        return this.tail.value;
    }

    public int getHead() {
        return this.head.value;
    }

    public static CircularLinkedList createCircularLinkedList() {

        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(10);
        cll.insert(20);

        return cll;
    }

    public int size() {
        return this.size;
    }

    public boolean containsNode(int searchValue) {
        Node cur = head;
        if (head != null) {
            do {
                if (cur.value == searchValue) {
                    return true;
                }
                cur = cur.next;
            } while (cur != head);
        } else {
            System.out.println("no list exists");
        }

        return false;
    }

    @Override
    public String toString() {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        if (cur != null) {
            do {
                sb.append(cur.value).append("->");
                cur = cur.next;
            } while (cur != head);

            return sb.replace(sb.length() - 2, sb.length(), "").toString();
        }
        return "no list exits";
    }

    public static void main(String[] args) {
        CircularLinkedList cll = createCircularLinkedList();

        System.out.println(cll.toString());
        System.out.println(cll.size());

        cll.insert(30);
        System.out.println(cll.toString());
        System.out.println(cll.size());

        cll.deleteFirst();
        System.out.println(cll.toString());
        System.out.println(cll.size());

        cll.deleteLast();
        System.out.println(cll.toString());
        System.out.println(cll.size());

        System.out.println("tail: " + cll.getTail() + " head: " + cll.getHead());

        cll.insertFirst(30);
        System.out.println("tail: " + cll.getTail() + " head: " + cll.getHead());
        System.out.println(cll.toString());
        System.out.println(cll.size());

    }

}
