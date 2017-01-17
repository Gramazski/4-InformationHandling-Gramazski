package com.gramazski.handling.reader;

import com.gramazski.handling.exception.DataReaderException;

/**
 * Created by gs on 20.12.2016.
 */
public abstract class AbstractReader {
    public abstract String read(String sourceName) throws DataReaderException;
}
