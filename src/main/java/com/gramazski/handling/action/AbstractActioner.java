package com.gramazski.handling.action;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;

/**
 * Created by gs on 23.01.2017.
 */
public abstract class AbstractActioner {
    public void handle(IComponent rootComponent){
        for (IComponent component : rootComponent.getInnerList()){
            if (TextPartType.SENTENCE.equals(component.getComponentType())){
                processSentence(component);
            }
            else{
                handle(component);
            }
        }
    }

    public abstract IComponent getResult();
    protected abstract void processSentence(IComponent sentence);
}
