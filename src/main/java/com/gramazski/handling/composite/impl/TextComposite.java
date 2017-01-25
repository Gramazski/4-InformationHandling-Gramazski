package com.gramazski.handling.composite.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 17.01.2017.
 */
public class TextComposite implements IComponent {
    private ArrayList<IComponent> textComponents;
    private TextPartType textPartType;
    private String separatingLexeme;
    private Logger logger = LogManager.getLogger(TextComposite.class);

    public TextComposite(TextPartType textPartType, String separatingLexeme){
        this.textComponents = new ArrayList<IComponent>();
        this.textPartType = textPartType;
        this.separatingLexeme = separatingLexeme;

        if (this.textPartType == TextPartType.WORD){
            this.separatingLexeme = " ";
        }

        if (this.textPartType == TextPartType.PARAGRAPH){
            this.separatingLexeme = "\n";
        }
    }

    public void add(IComponent component) {
        textComponents.add(component);
    }

    public void setValue(String value) {
        //Do nothing
    }

    public void remove(int index){
        textComponents.remove(index);
    }

    public List<IComponent> getInnerList() {
        ArrayList<IComponent> innerComponents = new ArrayList<IComponent>(textComponents.size());
        innerComponents.addAll(textComponents);
        return innerComponents;
    }

    public void setInnerList(ArrayList<IComponent> innerList){
        textComponents = cloneList(innerList);
    }

    public TextPartType getComponentType() {
        return textPartType;
    }

    @Override
    public String toString(){
        String result = "";

        for (IComponent component : textComponents){
            result += component.toString();
        }

        result += separatingLexeme;
        return result;
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;

        IComponent otherComponent = (IComponent) other;

        if (this.toString().equals(otherComponent.toString())){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public IComponent clone() throws CloneNotSupportedException {
        IComponent newObject = (IComponent) super.clone();
        newObject.setInnerList(cloneList(textComponents));

        return newObject;
    }

    private ArrayList<IComponent> cloneList(ArrayList<IComponent> innerList){
        ArrayList<IComponent> copiedList = new ArrayList<IComponent>(innerList.size());

        try {
            for (IComponent component : innerList){
                copiedList.add(component.clone());
            }
        }
        catch (CloneNotSupportedException ex){
            logger.log(Level.DEBUG, "Clonning list failed, course: " + ex.getMessage());
        }

        return copiedList;
    }
}
