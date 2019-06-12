package com.chd.dymanicArray;

import java.util.ArrayList;

public class DynamicArray<E> {
    private E[] data;
    private int size = 0;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; --i) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void insertLast(E e) {
        insert(size, e);
    }

    public void insertFirst(E e) {
        insert(0, e);
    }

    private void resize(int size) {
        E[] newData = (E[]) new Object[size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int find(E e) {
        // 要增加对e是不是null的判断，因为null没有equals方法
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        return find(e) >= 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();

        if (isEmpty())
            throw new IllegalArgumentException();

        //TODO resize
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size] = null;//memory leak
        size--;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return res;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeElement(E e) {
        int index = find(e);
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        return remove(index);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        data[index] = e;

    }

}