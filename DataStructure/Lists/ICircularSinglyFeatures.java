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
public interface ICircularSinglyFeatures{
    void insert();
    void insertFirst();
    void deleteNode(int valueToDelete);
    void deleteFirst();
    void deleteLast();
    int getTail();
    int getHead();
    CircularLinkedList creaCircularLinkedList();
    int size();
    boolean containsNode(int searchValue);
    @Override
    String toString();
}
