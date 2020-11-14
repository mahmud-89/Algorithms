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

public class CircularLinkedList implements ICircularSinglyFeatures {

    class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private int size;
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void insert(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.next = head;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
        size++;
    }

    @Override
    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            insert(value);
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
        size++;
    }

    @Override
    public void deleteNode(int valueToDelete) {
        if (head == null) {
            throw new NullPointerException("empty list");
        } else if (head.value == valueToDelete) {
            deleteFirst();
            return;
        } else if (tail.value == valueToDelete) {
            deleteLast();
            return;
        }

        Node cur = head;
        boolean flag = false;
        do {
            if (cur.next.value == valueToDelete) {
                flag = true;
                break;
            }
            cur = cur.next;
        } while (cur != head);
        if (flag) {
            cur.next = cur.next.next;
            size--;
        }else{
            System.out.println("value in not exists in the list");
        }
    }

    @Override
    public void deleteFirst() {
        if (!isEmpty()) {
            head = head.next;
            if (head == tail.next) {
                head = null;
                tail = null;
            } else {
                tail.next = head;
            }
            size--;
        } else {
            throw new NullPointerException("empty list");
        }
    }

    @Override
    public void deleteLast() {
        if (head == null) {
            throw new NullPointerException("list is empty");
        }
        if (head.next == head) {
            head = tail = null;
            size--;
            return;
        }
        Node cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }
        tail = cur;
        tail.next = head;
        size--;
    }

    @Override
    public int getTail() {
        if (!isEmpty()) {
            return tail.value;
        }
        return -1;
    }

    @Override
    public int getHead() {
        if (!isEmpty()) {
            return head.value;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean containsNode(int searchValue) {
        Node cur = head;
        do {
            if (cur.value == searchValue) {
                return true;
            }
            cur = cur.next;
        } while (cur != head);
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        if (head != null) {
            do {
                sb.append(cur.value).append("->");
                cur = cur.next;
            } while (cur != head);
            return sb.replace(sb.length() - 2, sb.length(), "").toString();
        }
        return "list is empty";
    }

    public void display() {
        Node cur = head;
        if (!isEmpty()) {
            do {
                System.out.print(cur.value + " ");
                cur = cur.next;
            } while (cur != head);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(10);
        cll.insert(20);
        cll.insertFirst(100);
        cll.insertFirst(200);
        System.out.println(cll.toString());
        System.out.println(cll.containsNode(200));
        System.out.println("size of the list: " + cll.size());
        cll.deleteLast();
        //cll.deleteLast();
        System.out.println(cll.toString());
        System.out.println("size of the list: " + cll.size());

        cll.deleteNode(100);
        cll.deleteNode(200);
        cll.deleteNode(1000);
        System.out.println("size: " + cll.size());
        System.out.println(cll.toString());

    }

}
