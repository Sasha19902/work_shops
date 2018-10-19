package it.sevenbits.workshop.queue;

class Node<T> {

    private T info;
    private Node<T> next;
    private Node<T> prev;

    private Node() {}

    public Node(T info, Node<T> next, Node<T> prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
