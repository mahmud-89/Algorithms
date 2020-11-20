/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Stack;

import java.util.ArrayList;

/**
 *
 * @author promise
 * @param <T> type of Stack
 */
public class StackArrayList<T> {

    private ArrayList<T> stack;

    public StackArrayList() {
        this.stack = new ArrayList<>();
    }

    public void push(T value) {
        this.stack.add(value);
    }

    public T peek() {
        if (isEmpty()) {
            throw new NullPointerException("empty list");
        }
        return this.stack.get(this.stack.size() - 1);
    }

    public T pop() {
        T value = this.stack.get(getSize() - 1);
        this.stack.remove(getSize() - 1);
        return value;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public int getSize() {
        return this.stack.size();
    }
    
    public void clean(){
        this.stack = new ArrayList<>();
    }

    public void display() {
        if (isEmpty()) {
            throw new NullPointerException("empty list");
        }
        for (T value : stack) {
            System.out.print(value + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        StackArrayList<Integer> stack = new StackArrayList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("peek value : " + stack.peek());

        stack.pop();
        stack.pop();
        System.out.println("peek value : " + stack.peek());
        stack.display();
    }

}
