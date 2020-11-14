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
public interface IDoublyFeatures{
    void insertHead(int value);
    void insertTail(int value);
    void insertNth(int index,int value);
    void insertOrdered(int value);
    void deleteHead();
    void deleteTail();
    void deleteNth(int index);
    void deleteValue(int value);
    int getValue(int index);
    int getHead();
    int getTail();
    int size();
    boolean isEmpty();
    void clearList();
}
