/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Lists;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 *
 * @author promise
 * @param <E>
 */
public class DynamicArray<E> implements Iterable<E>{

    private int capacity;
    private int size;
    private Object[] elements;
    
    public DynamicArray(final int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
    }
    public DynamicArray(){
        this.size = 0;
        this.capacity = 10;
        this.elements = new Object[this.capacity];
    
    }
    
    public int newCapacity(){
        this.capacity  *= 2;
        return this.capacity;
    }
    
    public void add(final E element){
        if(this.size == this.elements.length){
            this.elements = Arrays.copyOf(this.elements, newCapacity());
        }
        
        this.elements[this.size] = element;
        size++;
    }
   
    public void put(final int index,final E element){
        this.elements[index] = element;
    }
    
    public E get(final int index){
        return getElement(index);
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public E remove (final int index){
        final E oldElement = getElement(index);
        fastRemove(elements, index);
        
        return oldElement;
    }
    
    private void fastRemove(final Object[] elements,final int index){
        final int newSize = this.size - 1;
        if(newSize>index){
            System.arraycopy(elements, index+1, elements, index, newSize - index);
        }   
        
        elements[this.size = newSize] = null;
    }
    
    private E getElement(final int index){
        return (E) this.elements[index];
    }
    
    @Override
    public Iterator<E> iterator() {
       return new DynamicArrayIterator();
    }
    
    private class DynamicArrayIterator implements Iterator<E> {

        private int cursor;
        
        @Override
        public boolean hasNext() {
            return this.cursor != size;
        }

        @Override
        public E next() {
            if(this.cursor > DynamicArray.this.size) 
                throw new NoSuchElementException();
            
            if(this.cursor > DynamicArray.this.elements.length)
                throw new ConcurrentModificationException();
        
            final E element = DynamicArray.this.getElement(this.cursor);
            this.cursor++;
            return element;
        }

        @Override
        public void remove() {
            
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    
    public static void main(String[] s){
        DynamicArray<String> names = new DynamicArray<>();
        names.add("promise");
        names.add("mashrur");
        
        for(String name: names){
            System.out.println(name);
        }
        System.out.println("");
        
        names.remove(0);
        
        Iterator<String> itr = names.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        
    }
    
}
