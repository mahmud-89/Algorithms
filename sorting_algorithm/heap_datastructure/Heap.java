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
public interface Heap {
    HeapElement getElement() throws EmptyHeapException;
    void insertElement(HeapElement element);
    void deleteElement(int elementIndex);
}

