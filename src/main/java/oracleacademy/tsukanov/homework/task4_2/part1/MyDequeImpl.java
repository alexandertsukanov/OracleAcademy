package oracleacademy.tsukanov.homework.task4_2.part1;

public class MyDequeImpl<E> implements MyDeque<E> {


   private Node<E> first;

   private Node<E> last;

   private int size = 0;
   private int lasttoString = 0;


    private static class Node<E> {

        E element;
        Node<E> prev;
        Node<E> next;
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void addFirst(E e) {

       if(first == null){
           first = new Node<>(e, null, null);
           last = first;
       }
       else{
           first.prev = new Node<>(e, null, first);
           first = first.prev;
       }
        size++;

    }

    @Override
    public void addLast(E e) {

        if(last == null){
            last = new Node<>(e, null, null);
            first = last;
        }
        else{
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
            if(o.equals(s.element)){
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
        for (Node<E> s = first; s != null ; s = s.next) {
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

        for (Node<E> s = first; s != null;s = s.next) {
            if(!deque.contains(s.element)){
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
