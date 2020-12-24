/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithm.heap_datastructure.using_array;

import java.util.Arrays;

/**
 *
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
    
    private boolean isLeaf(int pos){
        if(pos >= (size/2) +1 && pos <= size){
            System.out.println("pos :"+pos +" size: "+size);
            System.out.println(Heap[pos]);
            return true;
        }
        return false;
    }
    
    public void minHeapify(int pos){
        System.out.println(Heap[pos]);
        if(isLeaf(pos)){
            return;
        }
        if(Heap[pos] > Heap[leftChild(pos)]
                || Heap[pos] > Heap[rightChild(pos)]){
            if(Heap[leftChild(pos)] < Heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            }else{
                swap(rightChild(pos), pos);
                minHeapify(rightChild(pos));
            }
        }
    }
    
    public int extractMin(){
        int popped = this.Heap[1];
        swap(1, size);
        size--;
        minHeapify(1);
        return popped;
    }
    
    public int [] getHeap(){
        return this.Heap;
    }
    
    public static void main(String[] args) {
        MinHeapArray minHeap = new MinHeapArray(15);
//        minHeap.insert(5); 
//        minHeap.insert(3); 
//        minHeap.insert(17); 
//        minHeap.insert(10); 
//        minHeap.insert(84); 
//        minHeap.insert(19); 
//        minHeap.insert(6); 
//        minHeap.insert(22); 
//        minHeap.insert(9);

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(30);
        
        int min = minHeap.extractMin();
        System.out.println("minimum value is : "+min);
       
        System.out.println(Arrays.toString(minHeap.getHeap()));
    }
    
}
