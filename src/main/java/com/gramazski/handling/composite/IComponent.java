package com.gramazski.handling.composite;

/**
 * Created by gs on 17.01.2017.
 */
public interface IComponent {
    void add(IComponent component);
    void remove(IComponent component);
    void setValue(String value);
}
