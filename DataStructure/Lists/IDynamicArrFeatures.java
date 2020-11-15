/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Lists;

/**
 *
 * @author promise
 * @param <E>
 */
public interface IDynamicArrFeatures<E> {

    int newCapacity();

    void add(final E element);

    void put(final int index, E element);

    E get(final int index);

    E remove(final int index);

    int getSize();

    boolean isEmpty();
}
