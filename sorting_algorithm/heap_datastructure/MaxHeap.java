/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithm.heap_datastructure;

/**
 *
 * @author promise
 */
import java.util.ArrayList;
import java.util.List;
public class MaxHeap implements Heap{
    private ArrayList<HeapElement> maxHeap;
    private int heapSize;
    
    public MaxHeap(List<HeapElement> listElements){
        this.maxHeap = new ArrayList<>(listElements.size());
        this.heapSize = listElements.size();
       for(HeapElement heapElement : listElements){
           if(heapElement != null) insertElement(heapElement);
           else {
               System.out.println("Null element. Not added to heap");
               this.heapSize-- ;
           }
       }
       if(maxHeap.isEmpty()) System.out.println("No element has been added, empty heap.");
    }   

    //element information from the heap
    public HeapElement getElement(int elementIndex){
        checkIndexValidity(elementIndex);
        return maxHeap.get(elementIndex);
    }
    private double getElementKey(int elementIndex){
        checkIndexValidity(elementIndex);
        return this.maxHeap.get(elementIndex).getKey();
    }
    private void checkIndexValidity(int elementIndex){
         if(elementIndex <0 || (elementIndex >= maxHeap.size())){
            throw new IndexOutOfBoundsException("Index out of heap range : "+elementIndex);
        }
    }
    
    
    private void swap(int index1,int index2){
        HeapElement temp = this.maxHeap.get(index1);
        this.maxHeap.set(index1, this.maxHeap.get(index2));
        this.maxHeap.set(index2, temp);
    }
    
    private void toggleUp(int elementIndex){
        int child = elementIndex;
        int parent = getParent(child);
        
        if(child == 0 ) return;
        
        if(getElementKey(child) > getElementKey(parent)){
            swap(child, parent);
            toggleUp(parent);
        }
        
    }
    
    @Override
    public void insertElement(HeapElement element) {
        this.maxHeap.add(element);
        toggleUp(this.maxHeap.size()-1);
    }
    
    private void toggleDown(int elementIndex){
        int left = getLeft(elementIndex);
        int right = getRight(elementIndex);
        
        if(left >= heapSize() && right >= heapSize()){
            return;
        }
        
        if(left < heapSize() && right < heapSize()){
            if(getElementKey(left) > getElementKey(right)
                    && getElementKey(left) > getElementKey(elementIndex)){
                swap(left, elementIndex);
                toggleDown(left);
            }else if(getElementKey(left) < getElementKey(right)
                    && getElementKey(right) > getElementKey(elementIndex)){
                swap(right, elementIndex);
                toggleDown(right);
            }
        }
        else if(getElementKey(left) > getElementKey(elementIndex)){
            swap(left, elementIndex);
            toggleDown(left);
        }
        
    }
    
    @Override
    public void deleteElement(int elementIndex) {
       if(heapSize()>1){
            swap(elementIndex, heapSize()-1);
            updateHeapSize();
            toggleDown(elementIndex);
       }else{
           updateHeapSize();
       }
    }
    
    private HeapElement extractMax(){
        HeapElement result = this.maxHeap.get(0);
        deleteElement(0);
        return result;
    }
    
    @Override
    public HeapElement getElement() throws EmptyHeapException {
        if(heapSize() == 0) throw new EmptyHeapException("Heap is empty!");
        return extractMax();
    }
    
    
    public ArrayList<HeapElement> getHeapArray(){
        return this.maxHeap;
    }
    
    public int heapSize(){
        return this.heapSize;
    }
    public int updateHeapSize(){
        return this.heapSize--;
    }
    
    public int getLeft(int parent){
        return (parent*2) +1;
    }
    public int getRight(int parent){
        return (parent*2) +2;
    }
    public int getParent(int child){
        return (int) Math.floor((child-1)/2);
    }

    
    
    public void displayHeap(){
        for(HeapElement val : this.maxHeap){
            System.out.print((int) val.getKey()+ " ");
        }
        System.out.println("");
    }
    public void displaySortedAscHeap() throws EmptyHeapException{
        for(int i = 0;i<this.maxHeap.size();i++){
            getElement();
        }
        System.out.print("sorted asencending order: ");
        displayHeap();
    }
    
    private static MaxHeap createHeap(){
        List<HeapElement> list = new ArrayList<>(5);
        list.add(new HeapElement(15));
        list.add(new HeapElement(10));
        list.add(new HeapElement(30));
        list.add(new HeapElement(20));
        list.add(new HeapElement(14));
        list.add(new HeapElement(50));
        list.add(new HeapElement(45));
        list.add(new HeapElement(35));
        
        MaxHeap heap = new MaxHeap(list);
        return heap;
    }
    
    public static void main(String[] args) throws EmptyHeapException {
        MaxHeap heap = MaxHeap.createHeap();
        
        System.out.print("original max heap: ");
        heap.displayHeap();
        System.out.println("");

        heap.displaySortedAscHeap();
        
    }
    
}