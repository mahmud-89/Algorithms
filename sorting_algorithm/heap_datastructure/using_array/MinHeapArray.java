/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithm.heap_datastructure.using_array;

import java.util.Arrays;

/**
 * In this solution we counting Heap index from 1. 
 * But if index from 0 then properties will be: 
 *  parent : (i-1)/2
 *  leftChild : (2*i) + 1
 *  rightChild: (2*i) + 2
 *  leaf nodes range: (n/2) to n (indexing from 0)
 *                     and ((n/2) +1 to n (indexing from 1) 
 *                     here, n is the number of nodes/elements in the array.
 *  non-leaf: index:0 --> 0 to (n/2)+1
 *            index:1 --> 1 to (n/2)
 * @author promise
 */

public class MinHeapArray {
    private int[] Heap;
    private int size;
    private int capacity;
    
    public MinHeapArray(int capacity){
        this.Heap = new int[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
        Heap[0] = Integer.MIN_VALUE;
    }
    
    public int getParent(int pos){
        return pos/2;
    }
    public int leftChild(int pos){
        return 2*pos;
    }
    public int rightChild(int pos){
        return (2*pos) + 1;
    }
    
    public void swap(int index1,int index2){
        int temp = Heap[index1];
        Heap[index1] = Heap[index2];
        Heap[index2] = temp;
    }
    
    public void insert(int element){
        Heap[++size] = element;
        int currentSize = size;
        while(Heap[currentSize] < Heap[getParent(currentSize)]){
            swap(currentSize, getParent(currentSize));
            currentSize = getParent(currentSize);
        }
    }
    
    //second approach 
    public void minHeapify(int pos){
        int left = leftChild(pos);
        int right = rightChild(pos);
        int smallest;
        if(left <= size && Heap[left] < Heap[pos]){
            smallest = left;
        }else smallest = pos;
        
        if(right <= size && Heap[right] < Heap[smallest]){
            smallest = right;
        }
        
        if(smallest != pos){
            swap(smallest, pos);
            minHeapify(smallest);
        }
    }
   
    public int extractMin(){
        int popped = this.Heap[1];
        swap(1, size);
        size--;
        //minHeapify(1);
        return popped;
    }
    
    public void print(){
        for(int i = 1;i<= size/2;i++){
            if(leftChild(i) <= size && rightChild(i) <= size){
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : "
                    + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            }else if(leftChild(i) <= size){
                
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : "
                    + Heap[2 * i]);
            }
            System.out.println("");
        }
    }
    
    // Function to remove and return the minimum 
    // element from the heap 
    public void minHeap(){
        for(int pos = size/2;pos>=1;pos--){
            minHeapify(pos);
        }
    }
    
    public int [] getHeap(){
        return this.Heap;
    }
    
    public static void main(String[] args) {
        MinHeapArray minHeap = new MinHeapArray(15);
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9);

        minHeap.print();
        
        int min = minHeap.extractMin();
        System.out.println("minimum value is : "+min);
        minHeap.minHeap();
        minHeap.print();
       
        System.out.println(Arrays.toString(minHeap.getHeap()));
    }
    
}
