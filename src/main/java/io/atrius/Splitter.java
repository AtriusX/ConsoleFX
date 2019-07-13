package io.atrius;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter extends PrintStream {

    private List<PrintStream> streams = new ArrayList<>();

    public Splitter(PrintStream oldStream, PrintStream... streams) {
        super(oldStream);
        this.streams.addAll(Arrays.asList(streams));
    }

    @Override
    public void println(Object x) {
        super.println(x);
        streams.forEach(s -> s.println(x));
    }

    public void addStream(PrintStream stream) {
        streams.add(stream);
    }
}
