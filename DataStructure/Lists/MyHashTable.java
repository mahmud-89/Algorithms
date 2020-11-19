/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Lists;

/**
 *
 * @author promise
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * what is Load factor?
 * -If n be the total number of buckets we decided to fill initially say 10 and let’s say 7 of them got 
 * filled now, so the load factor is 7/10 = 0.7.
 * 
 * what technique used for collision?
 * -Separate Chaining through LinkedList
 * 
 * @author promise
 */
class HashNode<K, V> {

    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void show() {
        System.out.println("key is : " + this.key);
        System.out.println("value is : " + this.value);
    }
}

class MyMap<K, V> {

    int numBuckets;
    int size;
    ArrayList<HashNode<K, V>> bucketArray;

    public MyMap() {
        this.numBuckets = 5;
        this.size = 0;
        this.bucketArray = new ArrayList<>(numBuckets);

        for (int i = 0; i < numBuckets; i++) {
            this.bucketArray.add(null);
        }
    }

    public int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        //System.out.println(index);
        return index;
    }
    
    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> head = bucketArray.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        throw new NullPointerException(" key does not exist in the list!! ");
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        
        //same line twice?? why??? think about it(***)!!!
        head = bucketArray.get(bucketIndex);
        
        HashNode<K, V> newNode = new HashNode<>(key, value);
        //always inserting at head 
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        size++;
        
        if( (this.size/numBuckets) >= .7 ){
            System.out.println("hashtable extended ...");
            
            ArrayList<HashNode<K,V>> temp = bucketArray;
            this.numBuckets *= 2;
            this.size = 0;
            this.bucketArray = new ArrayList<>();
            
            for(int i = 0;i<this.numBuckets;i++){
                this.bucketArray.add(null);
            }
            
            for(HashNode<K,V> headNode: temp){
                while(headNode!=null){
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
        

    }
    
    public void remove(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> head = bucketArray.get(bucketIndex);
        if(head.key.equals(key)){
            head = head.next;
            bucketArray.set(bucketIndex, head);
            return;
        }else{
            while(head != null){
                if(head.next.key.equals(key)){
                    head.next = head.next.next;
                    return;
                }
                head = head.next;
            }
        }
        
        throw new NoSuchElementException("key does not exist in the list");
        
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void traverse(int index){
        HashNode<K,V> head = bucketArray.get(index);
        if(head == null){
            throw new NullPointerException("empty list");
        }
        while(head != null){
            System.out.println("traverse: "+ head.value);
            head = head.next;
        }
    }

}

class Runner {

    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyMap<>();
        map.add(10, "promise");
        map.add(20, "pranti");
        map.add(30, "shakil");
        map.add(40, "sazeeb");
        map.add(50, "prinon");
        map.remove(10);
        map.remove(20);
        map.traverse(0);
       
        //System.out.println(map.get(30));
       
    }
}
