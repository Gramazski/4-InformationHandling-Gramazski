package com.gramazski.handling.parser;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.impl.TextComposite;
import com.gramazski.handling.exception.DataReaderException;
import com.gramazski.handling.parser.impl.ParagraphHandler;
import com.gramazski.handling.reader.AbstractReader;
import com.gramazski.handling.reader.file.TextFileReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gs on 17.01.2017.
 */
public class AbstractTextHandlerTest {

    @Test
    public void decomposeText(){
        AbstractReader reader = new TextFileReader();
        String data = "";

        try {
            data = reader.read("src/main/resources/data/text.txt");
        } catch (DataReaderException e) {
            e.printStackTrace();
        }

        IComponent compositeText = new TextComposite(TextPartType.TEXT, "");
        AbstractTextHandler textHandler = new ParagraphHandler();

        textHandler.handleRequest(data, compositeText);

        String actualData = compositeText.toString();

        Assert.assertEquals(actualData, data);
    }
}