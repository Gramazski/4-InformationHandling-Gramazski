package com.gramazski.handling.composite.factory;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;

/**
 * Created by gs on 18.01.2017.
 */
public abstract class AbstractComponentFactory {
    public abstract IComponent getComponent(TextPartType textPartType, String separator);
}
