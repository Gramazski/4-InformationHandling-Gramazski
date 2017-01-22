package com.gramazski.handling.composite.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.leaf.LexemeType;

/**
 * Created by gs on 17.01.2017.
 */
public class LexemeLeaf implements IComponent {
    private Character lexeme;
    private LexemeType lexemeType;

    //Adding type defining
    public LexemeLeaf(LexemeType lexemeType){
        //this.lexeme = lexeme;
        this.lexemeType = lexemeType;
    }

    public void add(IComponent component) {
        //Doing nothing
    }

    public void remove(IComponent component) {
        //Doing nothing
    }

    public void setValue(String value) {
        lexeme = value.charAt(0);
    }

    @Override
    public String toString(){
        return String.valueOf(lexeme);
    }
}
