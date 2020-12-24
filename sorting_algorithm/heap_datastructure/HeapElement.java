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
public class HeapElement {
    private double key;
    private Object additionalInfo;
    
    public HeapElement(double key,Object info){
        this.key = key;
        this.additionalInfo = info;
    }
    
    public HeapElement (int key,Object info){
        this.key = key;
        this.additionalInfo = info;
    }
    
    public HeapElement (Integer key,Object info){
        this.key = key;
        this.additionalInfo = info;
    }
    
    public HeapElement(Double key,Object info){
        this.key = key;
        this.additionalInfo = info;
    }
    
    public HeapElement(double key){
        this.key = key;
        this.additionalInfo = null;
    }
    
    public HeapElement(int key){
        this.key = key;
        this.additionalInfo = null;
    }
    
    public HeapElement(Integer key){
        this.key = key;
        this.additionalInfo = null;
    }
    
    public HeapElement(Double key){
        this.key = key;
        this.additionalInfo = null;
    }
    
    //utilities...
    public Object getInfo(){
        return this.additionalInfo;
    }
    
    public double getKey(){
        return this.key;
    }
    
    @Override
    public String toString(){
        return this.key +" - "+this.additionalInfo;
    }
   
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o instanceof HeapElement) return false;
        HeapElement temp = (HeapElement) o;
        return (temp.key == this.key
                && temp.additionalInfo == this.additionalInfo);
    }
    
    @Override
    public int hashCode(){
        int result = 0;
        result = 31* result + (int) this.key;
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        return result;
    }
    
}
