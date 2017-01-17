package com.gramazski.handling.composite.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;

import java.util.ArrayList;

/**
 * Created by gs on 17.01.2017.
 */
//Add method for getting inner collection, use Iterable and Iterator<IComponent>
public class TextComposite implements IComponent {
    private ArrayList<IComponent> textComponents;
    private TextPartType textPartType;
    //Use for building text from composite parts, like /n or ' '
    private String separatingLexeme;

    public TextComposite(TextPartType textPartType, String separatingLexeme){
        this.textComponents = new ArrayList<IComponent>();
        this.textPartType = textPartType;
        this.separatingLexeme = separatingLexeme;
    }

    public void add(IComponent component) {
        textComponents.add(component);
    }

    public void remove(IComponent component) {
        textComponents.remove(component);
    }

    @Override
    public String toString(){
        String result = separatingLexeme;

        for (IComponent component : textComponents){
            result += component.toString();
        }

        return result;
    }
}
