package it.sevenbits.workshop.queue;

import java.util.*;

public class DoubleEndedQueue<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;

    public DoubleEndedQueue() {
        head = null;
        tail = null;
    }

    public T getHead(){
        return head.getInfo();
    }

    public T getTail(){
        return tail.getInfo();
    }

    public void addStart(T element) {
        Node<T> toChange = new Node<T>(element, null, head);
        if(isEmpty())
            head = tail = toChange;
        else {
            head.setNext(toChange);
            head = toChange;
        }
    }


    public void addEnd(T element) {
        Node<T> toChange = new Node<T>(element, tail, null);
        if(isEmpty())
            tail = head = toChange;
        else {
            tail.setPrev(toChange);
            tail = toChange;
        }
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                final T resultValue = current.getInfo();
                current = current.getPrev();
                return resultValue;
            }
        };
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Iterator<T> iterator = iterator();

        while (iterator.hasNext())
            stringBuilder.append(iterator.next()).append('\n');

        return stringBuilder.toString();
    }
}
