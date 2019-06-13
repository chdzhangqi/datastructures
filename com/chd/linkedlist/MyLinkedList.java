package com.chd.linkedlist;

public class MyLinkedList<T> {
    private Node dummyHead;
    private int size;

    public MyLinkedList() {
        dummyHead = new Node(null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int index, T t) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        Node prev = dummyHead;
        for (int i = 0; i < index; ++i)
            prev = prev.next;
        prev.next = new Node(t, prev.next);
        size++;
    }

    public void addFirst(T t) {
        insert(0, t);
    }

    public void addLast(T t) {
        insert(size, t);
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        if (isEmpty())
            throw new IllegalArgumentException();
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = prev.next;
        prev.next = node.next;
        node.next = null;
        size--;
        return node.value;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void remove(T t) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (t.equals(prev.next.value)) {
                Node node = prev.next;
                prev.next = prev.next.next;
                node.next = null;
                size--;
                return;
            }
        }
    }

    public boolean contains(T t) {
        // TODO t may be null
        Node cur = dummyHead.next;
        while (cur != null) {
            if (t.equals(cur.value)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void set(int index, T t) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        Node cur = dummyHead.next;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        cur.value = t;
    }

    class Node {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }
    }
}
