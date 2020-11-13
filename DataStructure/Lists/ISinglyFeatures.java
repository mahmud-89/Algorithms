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
public interface ISinglyFeatures {
    void insertHead();
    void insert(); //to tail
    void insertNth(int data,int position);
    void deleteHead();
    void delete(); //from tail
    void deleteNth(int position);
    void clear();
    boolean isEmpty();
    int size();
    Node getHead();
    boolean search(int key);
    int getNth(int index);
    
    @Override
    String toString();
   
}
