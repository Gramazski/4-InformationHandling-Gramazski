package com.gramazski.handling.parser;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.factory.AbstractComponentFactory;
import com.gramazski.handling.composite.storage.StorageTable;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by gs on 17.01.2017.
 */
public abstract class AbstractTextHandler {
    protected AbstractTextHandler successor;
    protected TextPartType textType;
    protected Logger logger = LogManager.getLogger(AbstractTextHandler.class);

    //Can be boolean for getting success or not handling
    public void handleRequest(String data, IComponent compositeText){
        String[] decomposingText = decomposeText(data, compositeText);

        chain(decomposingText, compositeText);
    }

    protected abstract String[] decomposeText(String data, IComponent compositeText);

    private void chain(String[] decomposingText, IComponent compositeText) {
        StorageTable storageTable = new StorageTable();
        for (int i = 0; i < decomposingText.length; i++){
            //Add regexp for finding syntax letters
            logger.log(Level.DEBUG, "Text part - " + decomposingText[i]);
            AbstractComponentFactory componentFactory = storageTable.getComponentFactory(textType);
            IComponent textComponent = componentFactory.getComponent(textType, "");
            textComponent.setValue(decomposingText[i]);
            compositeText.add(textComponent);
            if (successor != null){
                successor.handleRequest(decomposingText[i], textComponent);
            }
        }
    }
}
