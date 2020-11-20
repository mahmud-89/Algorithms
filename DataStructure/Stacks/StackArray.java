/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Stack;

/**
 *
 * @author promise
 */
public class StackArray {

    private int size;
    private int[] stack;
    private static final int DEFAULT_CAPACITY = 5;
    private int maxSize;
    private int top;

    
    
    public StackArray() {
        this(DEFAULT_CAPACITY);
    }
    
    public StackArray(int maxSize){
        this.size = 0;
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }
    
    

    public void resizeArray(int newSize) {
        this.maxSize = newSize;
        int temp[] = new int[this.maxSize];
        for (int i = 0; i < this.size(); i++) {
            temp[i] = stack[i];
        }
        this.stack = temp;
    }

    public void push(int value) {
        if (this.size == this.maxSize) {
            resizeArray(maxSize * 2);
            System.out.println("size increased! cur size : " + this.maxSize);
        }
        this.stack[++top] = value;
        ++this.size;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NullPointerException("element does not exist in the list");
        }

        if (this.maxSize / 4 >= this.size) {
            resizeArray(this.maxSize / 2);
            System.out.println("size decreased! cur size: " + this.maxSize);
        }

        int data = stack[top];
        stack[top] = 0;
        --top;
        --size;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NullPointerException("element does not exist in the list");
        }
        return this.stack[top];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear(){
        this.size = 0;
        this.top = -1;
        this.stack = new int[DEFAULT_CAPACITY];
        this.maxSize = DEFAULT_CAPACITY;
    }

    public int size() {
        return this.size;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(top == -1){
            throw new NullPointerException("element does not exists in the list!!");
        }
        int temp = top;
        while(temp>=0){
            sb.append(this.stack[temp]).append("->");
            temp--;
        }
        return sb.replace(sb.length()-2, sb.length(), "").toString();
    }
    
    public void displayStackElements(){
        for(int i =0 ;i<this.maxSize;i++){
            System.out.print(this.stack[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] ar) {
        StackArray sad = new StackArray();
        sad.push(10);
        sad.push(20);
        sad.push(30);
        sad.push(40);
        sad.push(50);
        sad.push(60);
        System.out.println(sad.toString());

        System.out.println("size of the list: " + sad.size());
        System.out.println("peek or top value is: " + sad.peek());

        System.out.println("Pop: " + sad.pop());
        System.out.println("Pop: " + sad.pop());
        System.out.println("Pop: " + sad.pop());
        System.out.println("Pop: " + sad.pop());
        System.out.println("Pop: " + sad.pop());
        
        System.out.println("showing list elements...");
        sad.displayStackElements();
        System.out.println("size of the list: " + sad.size());
        
        System.out.println("clearing list..");
        sad.clear();
        sad.displayStackElements();
        System.out.println(sad.size());

    }
}