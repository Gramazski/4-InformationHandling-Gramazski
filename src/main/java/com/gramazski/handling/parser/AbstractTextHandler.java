package com.gramazski.handling.parser;

import com.gramazski.handling.composite.IComponent;

/**
 * Created by gs on 17.01.2017.
 */
public abstract class AbstractTextHandler {
    protected AbstractTextHandler successor;

    //Can be boolean for getting success or not handling
    public void handleRequest(String data, IComponent compositeText){
        String[] decomposingText = decomposeText(data, compositeText);

        chain(decomposingText, compositeText);
    }

    protected abstract String[] decomposeText(String data, IComponent compositeText);
    protected abstract void chain(String[] decomposingText, IComponent compositeText);
}
