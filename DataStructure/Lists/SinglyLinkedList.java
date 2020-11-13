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
public class SinglyLinkedList implements ISinglyFeatures {

    class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void insertHead(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void insertTail(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    @Override
    public void insertNth(int value, int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("position: " + index + " size: " + size());
        }

        Node newNode = new Node(value);
        if (index == 0) {
            insertHead(value);
            return;
        } else if (index == size()) {
            insertTail(value);
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    @Override
    public void deleteHead() {
        if (isEmpty()) {
            throw new NullPointerException("list is empty");
        }
        head = head.next;
        size--;
    }

    @Override
    public void deleteTail() {
        if (isEmpty()) {
            throw new NullPointerException("the list is empty");
        }
        Node cur = head;
        for (int i = 0; i < size() - 2; i++) {
            cur = cur.next;
        }
        cur.next = null;
        size--;
    }

    @Override
    public void deleteNth(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index : " + index + " size: " + size());
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
        cur.next =cur.next.next;
        size--;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean search(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int getNthValue(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " size: " + size());
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        if (!isEmpty()) {
            while (cur != null) {
                sb.append(cur.value).append("->");
                cur = cur.next;
            }
            return sb.replace(sb.length() - 2, sb.length(), "").toString();
        }
        return "empty list";
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertHead(10);
        sll.insertHead(20);
        sll.insertTail(30);
        sll.insertNth(40, 1);
        System.out.println(sll.toString());
        System.out.println("size: " + sll.size());

        sll.deleteTail();
        sll.deleteNth(2);
        System.out.println(sll.toString());
        sll.clear();

        System.out.println(sll.toString());

    }
}
