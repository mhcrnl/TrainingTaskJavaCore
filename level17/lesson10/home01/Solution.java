package com.javarush.test.level17.lesson10.home01;

import java.util.*;

/* Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution implements List<Long>{

    private ArrayList<Long> original = new ArrayList<Long>();

    @Override
    public synchronized int size()
    {
        return original.size();
    }

    @Override
    public synchronized boolean isEmpty()
    {
        return original.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o)
    {
        return original.contains(o);
    }

    @Override
    public synchronized Iterator iterator()
    {
        return original.iterator();
    }

    @Override
    public synchronized Object[] toArray()
    {
        return original.toArray();
    }

    @Override
    public synchronized boolean add(Long o)
    {
        return original.add(o);
    }

    @Override
    public synchronized boolean remove(Object o)
    {
        return original.remove(o);
    }

    @Override
    public synchronized boolean addAll(Collection collection)
    {
        return original.addAll(collection);
    }

    @Override
    public synchronized boolean addAll(int i, Collection collection)
    {
        return original.addAll(i, collection);
    }

    @Override
    public synchronized void clear()
    {
        original.clear();
    }

    @Override
    public synchronized Long get(int i)
    {
        return original.get(i);
    }

    @Override
    public synchronized Long set(int i, Long o)
    {
        return original.set(i, o);
    }

    @Override
    public synchronized void add(int i, Long o)
    {
        original.add(i, o);
    }

    @Override
    public synchronized Long remove(int i)
    {
        return original.remove(i);
    }

    @Override
    public synchronized int indexOf(Object o)
    {
        return original.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o)
    {
        return original.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator listIterator()
    {
        return original.listIterator();
    }

    @Override
    public synchronized ListIterator listIterator(int i)
    {
        return original.listIterator(i);
    }

    @Override
    public synchronized List subList(int i, int i2)
    {
        return original.subList(i,i2);
    }

    @Override
    public synchronized boolean retainAll(Collection collection)
    {
        return original.retainAll(collection);
    }

    @Override
    public synchronized boolean removeAll(Collection collection)
    {
        return original.remove(collection);
    }

    @Override
    public synchronized boolean containsAll(Collection collection)
    {
        return original.containsAll(collection);
    }

    @Override
    public synchronized <Long>Long[] toArray(Long[] objects)
    {
        return original.toArray(objects);
    }
}
