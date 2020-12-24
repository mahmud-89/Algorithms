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
public class MinHeap implements Heap{

    private ArrayList<HeapElement> minHeap;
    private int heapSize;
    public MinHeap(List<HeapElement> listElement){
        this.minHeap = new ArrayList<>(listElement.size());
        this.heapSize = listElement.size();
        
        for(HeapElement element : listElement){
            if(element != null) insertElement(element);
            else{
                System.out.println("element was null and not inserted into heap.");
                this.heapSize--;
            }
        }
        
        if(this.minHeap.isEmpty()) System.out.println("heap is empty! "
                + "not any item has been inserted yet");
    }
    
    public void swap(int index1,int index2){
        HeapElement temp = this.minHeap.get(index1);
        this.minHeap.set(index1, this.minHeap.get(index2));
        this.minHeap.set(index2,temp);
    }
    
    public double getElementKey(int elementIndex){
        checkIndexValidity(elementIndex);
        return this.minHeap.get(elementIndex).getKey();
    }
    public HeapElement getElement(int elementIndex){
        checkIndexValidity(elementIndex);
        return this.minHeap.get(elementIndex);
    }
    
    
    public void toggleUp(int elementIndex){
        int child = elementIndex;
        int parent = getParent(elementIndex);
        if(child == 0){
            return;
        }
        if(getElementKey(child) < getElementKey(parent)){
            swap(child, parent);
            toggleUp(parent);
        }
    }

    @Override
    public void insertElement(HeapElement element) {
        this.minHeap.add(element);
        toggleUp(this.minHeap.size()-1);
    }
    
    
    
    public void toggleDown(int parent){
        int left = getLeft(parent);
        int right = getRight(parent);
        
        if(left >= heapSize() && right >= heapSize()){
            return;
        }
        
        if(left < heapSize() && right < heapSize()){
            if(getElementKey(left) < getElementKey(right)
                    && getElementKey(left) < getElementKey(parent)){
                swap(left, parent);
                toggleDown(left);
            }else if(getElementKey(right) < getElementKey(left)
                    && getElementKey(right) < getElementKey(parent)){
                swap(right, parent);
                toggleDown(right);
            }
        }else if(getElementKey(left) < getElementKey(parent)){
            swap(left, parent);
            toggleDown(left);
        }
    }

    @Override
    public void deleteElement(int elementIndex) {
        if(heapSize() > 1){
            swap(elementIndex, heapSize()-1);
            updateHeapSize();
            toggleDown(elementIndex);
        }else{
            updateHeapSize();
        }
    }
    
    public HeapElement extractMin() throws EmptyHeapException{
        HeapElement result = this.minHeap.get(0);
        deleteElement(0);
        return result;
    }
    
    @Override
    public HeapElement getElement() throws EmptyHeapException {
        if(heapSize() == 0) throw new EmptyHeapException("heap is empty!");
        return extractMin();
    }

    
    public int heapSize(){
        return this.heapSize;
    }
    public int updateHeapSize(){
        return this.heapSize--;
    }
    
    public int getLeft(int parent) {
        return (parent * 2) + 1;
    }
    public int getRight(int parent) {
        return (parent * 2) + 2;
    }
    public int getParent(int child) {
        return (int) Math.floor((child - 1) / 2);
    }

    
    private static MinHeap createHeap(){
        List<HeapElement> list = new ArrayList<>(5);
        list.add(new HeapElement(15));
        list.add(new HeapElement(10));
        list.add(new HeapElement(30));
        list.add(new HeapElement(20));
        list.add(new HeapElement(14));
//        list.add(new HeapElement(50));
//        list.add(new HeapElement(45));
//        list.add(new HeapElement(35));
        
        MinHeap heap = new MinHeap(list);
        return heap;
    }
   
     private void checkIndexValidity(int elementIndex){
         if(elementIndex <0 || (elementIndex >= minHeap.size())){
            throw new IndexOutOfBoundsException("Index out of heap range : "+elementIndex);
        }
    }
    
    
    public void displayHeap() {
        for(int i = 0;i < this.minHeap.size();i++){
            System.out.print((int) getElementKey(i)+" ");
        }
        System.out.println("");
    }
    public void displaySortedAscHeap() throws EmptyHeapException {
        int tempSize = heapSize();
        while(tempSize > 0){
            getElement();
            tempSize--;
        }
        System.out.print("Sorted Descending order: ");
        displayHeap();
    }
    
    public static void main(String[] args) throws EmptyHeapException {
        MinHeap heap = MinHeap.createHeap();
        heap.displayHeap();
        HeapElement min = heap.getElement();
        System.out.println("value of min: "+ (int) min.getKey());
        heap.displaySortedAscHeap();
        
    }
}
