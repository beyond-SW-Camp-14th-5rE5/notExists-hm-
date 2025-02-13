package com.nohm.cinema.Stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutput extends ObjectOutputStream {

    @Override
    protected void writeStreamHeader() throws IOException {
    }

    public MyObjectOutput(OutputStream out) throws IOException {
        super(out);
    }
}
