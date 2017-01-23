package com.gramazski.handling.composite;

import com.gramazski.handling.composite.attribute.composite.TextPartType;

import java.util.List;

/**
 * Created by gs on 17.01.2017.
 */
public interface IComponent {
    void add(IComponent component);
    void remove(IComponent component);
    void setValue(String value);
    List<IComponent> getInnerList();
    TextPartType getComponentType();
}
