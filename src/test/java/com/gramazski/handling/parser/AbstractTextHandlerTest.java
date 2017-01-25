package com.gramazski.handling.parser;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.impl.TextComposite;
import com.gramazski.handling.exception.DataReaderException;
import com.gramazski.handling.parser.impl.ParagraphHandler;
import com.gramazski.handling.reader.AbstractReader;
import com.gramazski.handling.reader.file.TextFileReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 17.01.2017.
 */
public class AbstractTextHandlerTest {
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
    public void decomposeText(){
        String expectedData = "It has survived not only five centuries, but also the leap into 13.141120008059866" +
                " electronic -1.0 typesetting, remaining 8.0 essentially -3.0 unchanged. It was popularised in the -96.0" +
                " with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop" +
                " publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when" +
                " looking at its layout. The point of usg -0.2549327819483933 Ipsum is that it has a more-or-less normal" +
                " distribution of letters, as opposed to usg 'Content here, content here', making it look like readable" +
                " English. \n" +
                "It is a 1200.0 established fact that a reader will be of a page when looking at its layout. \n" +
                "Bye. \n";
        String actualData = compositeText.toString();

        Assert.assertEquals(actualData, expectedData);
    }
}