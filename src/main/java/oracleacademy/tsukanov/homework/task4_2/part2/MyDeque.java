package oracleacademy.tsukanov.homework.task4_2.part2;

import java.util.Iterator;

public interface MyDeque<E> extends Iterable<E> {

    void addFirst(E e);

    void addLast(E e);

    E removeFirst();

    E removeLast();

    E getFirst();

    E getLast();

    boolean contains(Object o);

    void clear();

    Object[] toArray();

    int size();

    boolean containsAll(MyDeque<? extends E> deque);

}
