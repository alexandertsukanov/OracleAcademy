package oracleacademy.tsukanov.homework.task4_2.part1;

public interface MyDeque<E> {

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
