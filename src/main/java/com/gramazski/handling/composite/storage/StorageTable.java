package com.gramazski.handling.composite.storage;

import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.factory.AbstractComponentFactory;
import com.gramazski.handling.composite.factory.impl.CompositeFactory;
import com.gramazski.handling.composite.factory.impl.LeafFactory;
import com.gramazski.handling.exception.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gs on 18.01.2017.
 */
public class StorageTable {
    private Map<TextPartType, AbstractComponentFactory> componentMap;

    public StorageTable(){
        componentMap = new HashMap<TextPartType, AbstractComponentFactory>();
        componentMap.put(TextPartType.TEXT, new CompositeFactory());
        componentMap.put(TextPartType.PARAGRAPH, new CompositeFactory());
        componentMap.put(TextPartType.SENTENCE, new CompositeFactory());
        componentMap.put(TextPartType.WORD, new CompositeFactory());
        componentMap.put(TextPartType.LETTER, new LeafFactory());
    }

    public AbstractComponentFactory getComponentFactory(TextPartType textType) throws KeyNotFoundException{
        if (componentMap.containsKey(textType)){
            return componentMap.get(textType);
        }

        throw new KeyNotFoundException("Key not exist");
    }
}
