package oracleacademy.tsukanov.homework.task4_2.part2;

import java.util.Iterator;

public class MyDequeImpl<E> implements MyDeque<E> {


    private Node<E> first;

    private Node<E> last;

    private int size = 0;
    private int lasttoString = 0;

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private static class Node<E> {

       private E element;
       private Node<E> prev;
       private Node<E> next;

         Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        private E getElement() {
            return element;
        }

        private void setElement(E element) {
            this.element = element;
        }

        private Node<E> getNext() {
            return next;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }

        private Node<E> getPrev() {
            return prev;
        }

        private void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private class IteratorImpl implements Iterator<E> {


        private Node<E> current = first;
        private Node<E> lastReturned = current;
        private boolean isnextCalled = false;
        private boolean isremoveCalled = false;

        public boolean hasNext() {
            return lastReturned.next != null;
        }

        public E next() {
            isnextCalled = true;
            isremoveCalled = false;
            lastReturned = current;
            current = current.next;
            return lastReturned.element;
        }

        public void remove() {
            if(!isnextCalled || isremoveCalled){
                throw new IllegalStateException();
            }
            lastReturned.prev.setNext(lastReturned.next);
            lastReturned.next.setPrev(lastReturned.prev);
            isremoveCalled = true;
            size--;
        }
    }

    @Override
    public void addFirst(E e) {

        if (first == null) {
            first = new Node<>(e, null, null);
            last = first;
        } else {
            first.prev = new Node<>(e, null, first);
            first = first.prev;
        }
        size++;

    }

    @Override
    public void addLast(E e) {

        if (last == null) {
            last = new Node<>(e, null, null);
            first = last;
        } else {
            last.next = new Node<>(e, last, null);
            last = last.next;
        }
        size++;

    }

    @Override
    public E removeFirst() {

        E element = first.element;
        first = first.next;
        if (first == null)
            last = null;
        else
            first.prev = null;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        E element = last.element;
        last = last.prev;
        if (last == null)
            first = null;
        else
            last.next = null;
        size--;
        return element;
    }

    @Override
    public E getFirst() {

        return first.element;

    }

    @Override
    public E getLast() {

        return last.element;

    }

    @Override
    public boolean contains(Object o) {
        for (Node<E> s = first; s != null; s = s.next) {
            if (o.equals(s.element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> s = first; s != null; s = s.next) {
            Node<E> next = s.next;
            s.element = null;
            s.prev = null;
            s.next = null;
            s.next = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node<E> s = first; s != null; s = s.next) {
            array[i++] = s.element;
        }
        return array;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsAll(MyDeque<? extends E> deque) {

        for (Node<E> s = first; s != null; s = s.next) {
            if (!deque.contains(s.element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return toArray()[lasttoString++].toString();
    }

}
