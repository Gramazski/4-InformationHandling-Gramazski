package com.gramazski.handling.composite;

import com.gramazski.handling.composite.attribute.composite.TextPartType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 17.01.2017.
 */
public interface IComponent extends Cloneable {
    void add(IComponent component);
    void setValue(String value);
    List<IComponent> getInnerList();
    IComponent clone() throws CloneNotSupportedException;
    TextPartType getComponentType();
    void setInnerList(ArrayList<IComponent> innerList);
}
