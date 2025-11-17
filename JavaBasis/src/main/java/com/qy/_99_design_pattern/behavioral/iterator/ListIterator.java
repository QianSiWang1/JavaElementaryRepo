package com.qy._99_design_pattern.behavioral.iterator;

// 具体迭代器
class ListIterator implements Iterator {
    private List list;
    private int index;

    public ListIterator(List list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return list.get(index++);
        }
        return null;
    }
}
