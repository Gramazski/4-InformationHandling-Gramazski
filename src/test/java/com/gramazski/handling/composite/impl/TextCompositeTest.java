package com.gramazski.handling.composite.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.exception.DataReaderException;
import com.gramazski.handling.parser.AbstractTextHandler;
import com.gramazski.handling.parser.impl.ParagraphHandler;
import com.gramazski.handling.reader.AbstractReader;
import com.gramazski.handling.reader.file.TextFileReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 25.01.2017.
 */
public class TextCompositeTest {
    private IComponent compositeText;

    @Before
    public void initComposite(){
        AbstractReader reader = new TextFileReader();
        String data = "";

        try {
            data = reader.read("src/main/resources/data/text.txt");
        } catch (DataReaderException e) {
            e.printStackTrace();
        }

        compositeText = new TextComposite(TextPartType.TEXT, "");
        AbstractTextHandler textHandler = new ParagraphHandler();

        textHandler.handleRequest(data, compositeText);
    }

    @After
    public void clearComposite(){
        compositeText = new TextComposite(TextPartType.TEXT, "");
    }

    @Test
    public void cloneTestWithReferenceComparing() throws Exception {
        IComponent clonnedComponent = compositeText.clone();

        Assert.assertFalse("Reference test failed.", clonnedComponent == compositeText);
    }

    @Test
    public void cloneTestWithContentComparing() throws Exception {
        IComponent clonnedComponent = compositeText.clone();

        Assert.assertTrue("Reference test failed.", clonnedComponent.equals(compositeText));
    }

}