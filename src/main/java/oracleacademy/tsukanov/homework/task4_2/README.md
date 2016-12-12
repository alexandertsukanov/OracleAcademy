Homework # 4.2
--

Замечания:
1. Корневой пакет для всех классов: ua.org.oa.<JIRALOGIN>.task4_2
2. Задание состоит из нескольких частей, каждая часть независима от других; код, который относится к одной части должен располагаться в отдельном пакете.
3. Каждый тип класть в отдельный файл.
4. Целесообразно ознакомится с содержимым класса java.util.LinkedList

## Задание:
### Часть №1 (пакет ua.org.oa.<JIRALOGIN>.task4_2.part1)
* Создать generic интерфейс MyDeque (двусвязный список) следующего содержания:

```code java
public interface MyDeque<E> {
// добавить элемент в начало списка
void addFirst(E e);
// добавить элемент в конец списка
void addLast(E e);
// получить элемент из начала списка и удалить его
E removeFirst();
// получить элемент из конца списка и удалить его
E removeLast();
// получить элемент из начала списка, не удаляя его
E getFirst();
// получить элемент из конца списка, не удаляя его
E getLast();
// проверить, содержится ли объект o в списке
// (с помощью equals)
boolean contains(Object o);
// очистить список
void clear();
// вернуть массив элементов из списка
// (сохраняя упорядоченность элементов списка)
Object[] toArray();
// вернуть количество элементов в списке
int size();
// проверить, содержит ли список все элементы списка deque
boolean containsAll(MyDeque<? extends E> deque);
}
```
* 1.2. Создать generic класс контейнер MyDequeImpl, который реализует MyDeque (реализовать все методы интерфейса).

```code java
public class MyDequeImpl<E> implements MyDeque<E> {...}

Замечание: для реализации списка написать вложенный класс Node<E> следующего вида:

private static class Node<E> {

// хранимый элемент

E element;

// ссылка на следующий элемент списка

Node<E> next;

// ссылка на предыдущий элемент списка

Node<E> prev;

Node(E element, Node<E> prev, Node<E> next) {...}
}
```

* 1.3. Переопределить метод toString таким образом, чтобы результат выводился в виде:
{результат вызова toString для элемента 1, результат вызова toString для элемента 2, ... }
* 1.4. Создать класс Demo, который демонстрирует работу всех методов контейнера.
Например, так:

```java
public class Demo {
public static void main(String[] args) {
MyDeque<Number> deque = new MyDequeImpl<Number>();
deque.addFirst(433);
deque.addLast(8.88);
// демонстрация всех методов MyDeque
System.out.println("list contains 433 --> " + deque.contains(433));
// ...
}
}
```
### Часть №2 (пакет ua.org.oa.<JIRALOGIN>.task4_2.part2)
Скопировать созданные в части №1 типы в пакет part2 (изменив декларацию пакета вверху каждого типа).
* 2.1. Добавить к интерфейсу MyDeque<E> наследование интерфейса Iterable<E> (java.lang.Iterable).
public interface MyDeque<E> extends Iterable<E> {...}

Добавить в класс MyDequeImpl<E> метод, который реализует метод Iterable iterator:

```java
public Iterator<E> iterator() { return new IteratorImpl(); }

метод должен возвращает объект внутреннего класса IteratorImpl:

private class IteratorImpl implements Iterator<E> {

// проверяет, есть ли следующий элемент для выборки методом next

public boolean hasNext() { // ... }

// возвращает следующий элемент

public E next() { // ... }	}

// удаляет элемент, который был возвращен ранее методом next

public void remove() {

/*

АЛГОРИТМ:

ЕСЛИ ПЕРЕД ВЫЗОВОМ remove НЕ БЫЛ ВЫЗВАН МЕТОД next

ИЛИ ПЕРЕД ВЫЗОВОМ remove БЫЛ ВЫЗВАН remove (повторный вызов remove)

ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ (так и вставить в код):

throw new IllegalStateException();

В ДАННОМ МЕСТЕ ОПРЕДЕЛИТЬ И УДАЛИТЬ СООТВЕТСТВУЮЩИЙ ЭЛЕМЕНТ

*/

}

}
```

* 2.2. Продемонстрировать работу итератора с помощью циклов while и for each:

```java
public class Demo {

public static void main(String[] args) {

MyDeque<Number> deque = new MyDequeImpl<Number>();

deque.addFirst(433);

deque.addLast(8.88);

// ...

for (Number element : deque) { System.out.println(element); }

Iterator<Number> it = deque.iterator();

while (it.hasNext())

System.out.println(it.next());

// ...

}

}
```
### Часть №3 (пакет ua.org.oa.<JIRALOGIN>.task4_2.part3)

Скопировать созданные в части №2 типы в пакет part3 (изменив декларацию пакета вверху каждого типа).

* 3.1. Определить интерфейс ListIterator:

```java
public interface ListIterator<E> extends Iterator<E> { // java.util.Iterator

// проверяет, есть ли предыдущий элемент для выборки методом previous

boolean hasPrevious();

// возвращает предыдущий элемент

E previous();

// заменяет элемент, который на предыдущем шаге был возвращен next/previous на данный элемент

void set(E e);

// удаляет элемент, который на предыдущем шаге был возвращен next/previous

void remove();

}
```

Методы set/remove могут быть вызваны только после next/previous. Повторный вызов (подряд) set/remove должен приводить к выбросу исключения IllegalStateException

* 3.2. Создать интерфейс ListIterable: public interface ListIterable<E> { ListIterator<E> listIterator(); }

* 3.3. Добавить к интерфейсу MyDeque наследование интерфейса ListIterable:

```java
public interface MyDeque<E> extends Iterable<E>, ListIterable<E> {...}
3.4. Добавить в класс MyDequeImpl метод
public ListIterator<E> listIterator() { return new ListIteratorImpl(); }
который возвращает объект внутреннего класса ListIteratorImpl:
private class ListIteratorImpl extends IteratorImpl implements ListIterator<E> { // РЕАЛИЗОВАТЬ ВСЕ МЕТОДЫ интерфейса ListIterator }
3.5. Продемонстрировать работу итератора ListIterator.
public class Demo {
public static void main(String[] args) {
MyDeque<Number> deque = new MyDequeImpl<Number>();
deque.addFirst(433);
deque.addLast(8.88);
// ...
ListIterator<Number> listIt = deque.listIterator();
while (listIt.hasNext())
System.out.println(listIt.next());
while (listIt.hasPrevious())
System.out.println(listIt.previous());
// ...
}
}
```