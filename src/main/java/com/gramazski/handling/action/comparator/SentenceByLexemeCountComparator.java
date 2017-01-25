package com.gramazski.handling.action.comparator;

import com.gramazski.handling.composite.IComponent;

import java.util.Comparator;

/**
 * Created by gs on 25.01.2017.
 */
public class SentenceByLexemeCountComparator implements Comparator<IComponent> {
    public int compare(IComponent firstComponent, IComponent secondComponent) {
        return firstComponent.getInnerList().size() - secondComponent.getInnerList().size();
    }
}
