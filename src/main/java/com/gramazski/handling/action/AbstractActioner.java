package com.gramazski.handling.action;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;

/**
 * Created by gs on 23.01.2017.
 */
//How to return result?
public abstract class AbstractActioner {
    public void handle(IComponent rootComponent){
        for (IComponent component : rootComponent.getInnerList()){
            if (component.getComponentType().equals(TextPartType.SENTENCE)){
                processSentence(component);
            }
            else{
                handle(component);
            }
        }
    }

    protected abstract void processSentence(IComponent sentence);
}
