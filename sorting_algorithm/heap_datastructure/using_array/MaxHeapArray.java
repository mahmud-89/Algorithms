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
public class MaxHeapArray {
    private int [] Heap;
    private int size;
    private int maxsize;
    
    public MaxHeapArray(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }
    
    private int parent(int pos){
        return pos/2;
    }
    
    private int leftChild(int pos){
        return (2 * pos);
    }
    
    private int rightChild(int pos){
        return (2*pos)  + 1;
    }
    
    private void swap(int index1,int index2){
        int temp = Heap[index1];
        Heap[index1] = Heap[index2];
        Heap[index2] = temp;
    }
    
    private boolean isLeaf(int pos){
        if(pos >= (size/2) +1 && pos <= size){
            return true;
        }
        return false;
    }
    
    // two of one approach applied here! another one applied in minHeapify
    //own approach
    private void maxHeapify(int pos){
        if(isLeaf(pos)){
            return;
        }
        int left = leftChild(pos);
        int right = rightChild(pos);
        
        if(left <= size && right <= size){
            if(Heap[left] > Heap[right] && Heap[left] > Heap[pos]){
                swap(left, pos);
                maxHeapify(left);
            }else if (Heap[right] > Heap[pos])  {
                swap(right, pos);
                maxHeapify(right);
            }
        }
        //complete binary tree,that's why checking only left element
        else if(left <= size){
            if(Heap[left] > Heap[pos]){
                swap(left, pos);
            }
        }
        
        
    }
    
    public void insert(int element){
        if(size >= this.maxsize){
            return;
        }
        Heap[++size] = element;
        int current = size;
        while(Heap[current] > Heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }
    
    public int extractMax(){
        int popped = Heap[1];
        swap(1, size);
        size--;
        //disble maxHeapify here due to used maxHeap() builder function.
       // maxHeapify(1);
        return popped;
    }
    
    public void print() {
        //go into every non-leaf elements in the array
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : "
                    + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
    
    // Function to remove and return the minimum 
    // element from the heap 
    public void maxHeap(){
        for(int pos = (size/2); pos>=1 ;pos-- ){
            maxHeapify(pos);
        }
    }
    
    public int [] getHeap(){
        return this.Heap;
    }
    
    public static void main(String[] args) {
        System.out.println("The Max Heap is: ");
        MaxHeapArray maxHeap = new MaxHeapArray(10);
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
        
        maxHeap.print();
        System.out.println("The max val is "+ maxHeap.extractMax());
        maxHeap.maxHeap();
        
        System.out.println(Arrays.toString(maxHeap.getHeap()));
    }
}
