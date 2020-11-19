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
    private int[] stackArray;
    private final int DEFAULT_VALUE;
    private int MaxSize;

    private int top = -1;

    public StackArray() {
        this.size = 0;
        this.DEFAULT_VALUE = 5;
        this.MaxSize = this.DEFAULT_VALUE;
        this.stackArray = new int[DEFAULT_VALUE];
    }

    public void resizeArray(int newSize) {
        this.MaxSize = newSize;
        int temp[] = new int[this.MaxSize];
        for (int i = 0; i < this.size(); i++) {
            temp[i] = stackArray[i];
        }
        this.stackArray = temp;
    }

    public void push(int value) {
        if (this.size == this.MaxSize) {
            resizeArray(MaxSize * 2);
            System.out.println("size increased! cur size : " + this.MaxSize);
        }
        this.stackArray[++top] = value;
        ++this.size;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NullPointerException("element does not exist in the list");
        }

        if (this.MaxSize / 4 >= this.size) {
            resizeArray(this.MaxSize / 2);
            System.out.println("size decreased! cur size: " + this.MaxSize);
        }

        int data = stackArray[top];
        stackArray[top] = 0;
        --top;
        --size;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NullPointerException("element does not exist in the list");
        }
        return this.stackArray[top];
    }

    public boolean isEmpty() {
        return this.size == 0;
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
            sb.append(this.stackArray[temp]).append("->");
            temp--;
        }
        return sb.replace(sb.length()-2, sb.length(), "").toString();
    }
    
    public void displayStackArray(){
        for(int i =0 ;i<this.MaxSize;i++){
            System.out.print(this.stackArray[i] + " ");
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
        
        sad.displayStackArray();
        System.out.println("size of the list: " + sad.size());

    }
}