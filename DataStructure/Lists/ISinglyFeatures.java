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
    void insertHead(int value);
    void insertTail(int vlaue); //to tail
    void insertNth(int value,int index);
    void deleteHead();
    void deleteTail(); //from tail
    void deleteNth(int index);
    void clear();
    boolean isEmpty();
    int size();
    boolean search(int key);
    int getNthValue(int index);
}
