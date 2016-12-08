package oracleacademy.tsukanov.homework.task4_2.part3;

import java.util.Iterator;


    public interface ListIterator<E> extends Iterator<E> { // java.util.Iterator

        boolean hasPrevious();

        E previous();

        void set(E e);

        void remove();

    }


