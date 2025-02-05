package com.qy.designpattern.behavioral.iterator;

// 具体聚合类
class List implements Aggregate {
    private Object[] elements;
    private int size;

    public List() {
        this.elements = new Object[10];
        this.size = 0;
    }

    public void add(Object element) {
        if (size < elements.length) {
            elements[size++] = element;
        }
    }

    public Object get(int index) {
        if (index < size) {
            return elements[index];
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator createIterator() {
        return new ListIterator(this);
    }
}
