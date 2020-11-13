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
public class DoublyLinkedList {

    class Link {

        int value;
        Link next;
        Link prev;

        public Link() {
        }

        public Link(int value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    private Link head;
    private Link tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * ----------------- Insert operation -----------------------------
     *
     * @param value
     */
    public void insertHead(int value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            head = tail = newLink;
            head.prev = null;
            tail.next = null;
            size++;
            return;
        }
        head.prev = newLink;
        newLink.next = head;
        newLink.prev = null;
        head = newLink;
        size++;
    }

    public void insertTail(int value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            insertHead(value);
            return;
        }
        tail.next = newLink;
        newLink.prev = tail;
        newLink.next = null;
        tail = newLink;
        size++;
    }

    public void insertNth(int index, int value) {
        if (index > size() || index <= 0) {
            throw new IndexOutOfBoundsException("index: " + index + " size: " + size());
        }
        if (index == 0) {
            insertHead(value);
            return;
        } else if (index == size()) {
            insertTail(value);
            return;
        }
        Link newLink = new Link(value);
        Link cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newLink.prev = cur;
        newLink.next = cur.next;
        cur.next.prev = newLink;
        cur.next = newLink;
        size++;
    }

    public void insertOrdered(int value) {
        Link cur = head;
        int counter = -1;
       
        
    }

    /**
     * ------------------ Delete operation---------------------------
     *
     * @return
     */
    public void deleteHead() {
        if (isEmpty()) {
            throw new NullPointerException("no element available in the list");
        }
        System.out.println(String.format("%d is deleted from head", head.value));
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteTail() {
        if (isEmpty()) {
            throw new NullPointerException("no element available in the list");
        }
        System.out.println(String.format("%d is deleted from tail", tail.value));
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteNth(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " size" + size());
        }

        if (index == 0) {
            deleteHead();
            return;
        } else if (index == size() - 1) {
            deleteTail();
            return;
        }
        Link cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }

    public void deleteValue(int value) {
        if (head.value == value) {
            deleteHead();
            return;
        } else if (tail.value == value) {
            deleteTail();
            return;
        }
        Link cur = head;
        boolean flag = false;
        while (cur.next != null) {
            if (cur.next.value == value) {
                cur.next.next.prev = cur;
                cur.next = cur.next.next;
                size--;
                flag = true;
            }
            cur = cur.next;
        }
        if (!flag) {
            System.out.println("the value is not in the list");
        }
    }

    /**
     * ------------- Utility methods --------------------
     *
     * @return
     */
    public int getValue(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " size:" + size());
        }
        if (index == 0) {
            return getHead();
        } else if (index == size() - 1) {
            return getTail();
        }
        Link cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public int getHead() {
        return this.head.value;
    }

    public int getTail() {
        return this.tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Link cur = head;
        while (cur != null) {
            sb.append(cur.value).append("->");
            cur = cur.next;
        }
        return sb.replace(sb.length() - 2, sb.length(), "").toString();
    }

    public void display() {
        Link cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("");
        cur = head;
    }

    public static void main(String[] s) {
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println("\n\nInsert operation:");
        System.out.println("insert value in head: ");
        dll.insertHead(10);
        dll.insertHead(20);
        dll.insertHead(30);
        System.out.println(dll.toString());

        System.out.println("size of the list: " + dll.size());
        System.out.println("extracting head value:" + dll.getHead());
        System.out.println("extracting value with index :" + dll.getValue(2));

        System.out.println("insert value in tail: ");
        dll.insertTail(100);
        dll.insertTail(200);
        dll.insertTail(300);
        System.out.println(dll.toString());
        System.out.println("size of the list: " + dll.size());

//        System.out.println("extracting tail value: " + dll.getTail());
//
//        int index = dll.size()-1;
//        System.out.printf("inserting value at position %d\n", index);
//        dll.insertNth(index, 2);
//        System.out.println(dll.toString());
//
//        System.out.println("size of the list is " + dll.size());
//
//        System.out.println("\nDelete operation:");
//        System.out.println(dll.toString());
//        dll.deleteHead();
//        System.out.println(dll.toString());
//        System.out.println(dll.size());
//        
//        
//        System.out.println("tail of list is : " + dll.getTail());
//
//        dll.deleteTail();
//        dll.deleteHead();
//        System.out.println(dll.toString());
//        System.out.println("size of the list is " + dll.size());
//
//        System.out.println("\ndeleting nTh position: ");
//        System.out.println(dll.toString());
//        dll.deleteNth(2);
//        System.out.println(dll.toString());
//        System.out.println("size of the list: "+dll.size());
//        
//        System.out.println("deleting specific value from list:");
//        dll.deleteValue(20);
//        System.out.println(dll.toString());
//        System.out.println("size of the list: "+ dll.size());
        
        

    }
}
