package com.gramazski.handling.composite.factory.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.factory.AbstractComponentFactory;
import com.gramazski.handling.composite.impl.LexemeLeaf;

/**
 * Created by gs on 18.01.2017.
 */
public class LeafFactory extends AbstractComponentFactory {
    public IComponent getComponent(TextPartType textPartType, String separator) {
        IComponent component = new LexemeLeaf(TextPartType.LETTER);
        return component;
    }
}
