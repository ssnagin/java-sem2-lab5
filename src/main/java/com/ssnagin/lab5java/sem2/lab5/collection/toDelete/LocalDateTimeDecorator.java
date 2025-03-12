/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection.toDelete;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author developer
 */
public class LocalDateTimeDecorator<T> implements Collection<T> {
    private LocalDateTime localDateTime;
    private Collection<T> base;
    
    public LocalDateTimeDecorator(Collection<T> base) {
        this.base = base;
    }

    @Override
    public int size() {
        return this.base.size();
    }

    @Override
    public boolean isEmpty() {
        return this.base.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.base.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.base.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.base.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return this.base.toArray(ts);
    }

    @Override
    public boolean add(T e) {
        return this.base.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return this.base.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        return this.base.containsAll(clctn);
    }

    @Override
    public boolean addAll(Collection<? extends T> clctn) {
        return this.base.addAll(clctn);
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        return this.base.removeAll(clctn);
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        return this.removeAll(clctn);
    }

    @Override
    public void clear() {
        this.base.clear();
    }
    
    
}
