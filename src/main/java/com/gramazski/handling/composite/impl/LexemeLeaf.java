package com.gramazski.handling.composite.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 17.01.2017.
 */
public class LexemeLeaf implements IComponent, Cloneable {
    private Character lexeme;
    private TextPartType lexemeType;

    public LexemeLeaf(TextPartType lexemeType){
        this.lexemeType = lexemeType;
    }

    public void add(IComponent component) {
        //Doing nothing
    }

    public void setValue(String value) {
        lexeme = value.charAt(0);
    }

    public void remove(int index) {
        //Doing nothing
    }

    public List<IComponent> getInnerList() {
        //Not realized
        return new ArrayList<IComponent>();
    }

    public TextPartType getComponentType() {
        return lexemeType;
    }

    public void setInnerList(ArrayList<IComponent> innerList) {
        //Doing nothing
    }

    @Override
    public IComponent clone() throws CloneNotSupportedException {
        return (IComponent) super.clone();
    }

    @Override
    public String toString(){
        return String.valueOf(lexeme);
    }
}
