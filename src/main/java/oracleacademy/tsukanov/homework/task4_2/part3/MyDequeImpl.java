package oracleacademy.tsukanov.homework.task4_2.part3;

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

    public ListIterator<E> listIterator() { return new ListIteratorImpl(); }

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
        private boolean ispreviousCalled = false;
        private boolean isSetCalled = false;

        public boolean hasNext() {
            if(current != null){
                return true;
            }
            else {
                current = lastReturned;
                return false;
            }
        }

        public E next() {
            isnextCalled = true;
            ispreviousCalled = true;
            isSetCalled = false;
            isremoveCalled = false;
            lastReturned = current;
            current = current.next;
            return lastReturned.element;
        }

        public void remove() {
            if(!isnextCalled || !ispreviousCalled || isremoveCalled){
                throw new IllegalStateException();
            }
            if(lastReturned.prev == null && lastReturned.next == null){
                first = null;
            }
            if(lastReturned.prev != null){
                lastReturned.prev.setNext(lastReturned.next);
            }
            else{
                first = lastReturned.next;
            }
            if(lastReturned.next != null){
                lastReturned.next.setPrev(lastReturned.prev);
            }
            else {
                last = lastReturned.prev;
            }
            isremoveCalled = true;
            size--;
        }
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator<E> {

        @Override
        public boolean hasNext() {
            return super.hasNext();
        }

        @Override
        public E next() {
            return super.next();
        }

        @Override
        public void remove() {
            super.remove();
        }

        @Override
        public boolean hasPrevious() {
            if(super.current != null){
                return true;
            }
            else {
                super.current = super.lastReturned;
                return false;
            }
        }

        @Override
        public E previous() {
            super.ispreviousCalled = true;
            super.isnextCalled = true;
            super.isSetCalled = false;
            super.isremoveCalled = false;
            super.lastReturned = super.current;
            super.current = super.current.prev;
            return super.lastReturned.element;
        }

        @Override
        public void set(E e) {
            if(!super.ispreviousCalled || !super.isnextCalled || super.isSetCalled){
                throw new IllegalStateException();
            }
            super.lastReturned.element = e;
            super.isSetCalled = true;
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
        for (Node<E> s = first; s != null;) {
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
