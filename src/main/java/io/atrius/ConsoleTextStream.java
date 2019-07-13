package io.atrius;

import java.io.PrintStream;

public class ConsoleTextStream extends PrintStream {

    private Console console;

    public ConsoleTextStream(Console console) {
        super(System.out);
        this.console = console;
    }


}
