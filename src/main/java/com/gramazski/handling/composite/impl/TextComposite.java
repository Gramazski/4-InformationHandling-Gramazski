package com.gramazski.handling.composite.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 17.01.2017.
 */
//Add method for getting inner collection, use Iterable and Iterator<IComponent>
public class TextComposite implements IComponent {
    private ArrayList<IComponent> textComponents;
    private TextPartType textPartType;
    //Use for building text from impl parts, like \n or ' '
    private String separatingLexeme;

    public TextComposite(TextPartType textPartType, String separatingLexeme){
        this.textComponents = new ArrayList<IComponent>();
        this.textPartType = textPartType;
        this.separatingLexeme = separatingLexeme;
        //BreakFAG
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

    public void remove(IComponent component) {
        textComponents.remove(component);
    }

    public void setValue(String value) {
        //Doing nothing
    }

    //Realize clone for coping collection
    public List<IComponent> getInnerList() {
        ArrayList<IComponent> innerComponents = new ArrayList<IComponent>(textComponents.size());
        innerComponents.addAll(textComponents);
        return innerComponents;
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
}
