package io.atrius;

import javafx.beans.property.BooleanProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableBooleanProperty;
import javafx.scene.control.Control;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Console component that allows a user to see CLI-style text output
 * inside a JavaFX scene.
 */
public class Console extends Control {
    private static Splitter splitter;

    /*
     * Sets up an output splitter for the CLI's output stream.
     */
    static {
        PrintStream out = System.out;
        // Implement a splitter instance into the system output
        if (!(out instanceof Splitter)) {
            System.setOut(new Splitter(out));
        }
        // Make the splitter available to this class
        splitter = (Splitter) System.out;
    }

    /**
     * PROPERTIES
     */
    private BooleanProperty canType = new StyleableBooleanProperty() {

        @Override
        public CssMetaData<? extends Styleable, Boolean> getCssMetaData() {
            return null;
        }

        @Override
        public Object getBean() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    };

//    private ConsoleTextStream consoleStream;
    private List<String> lines = new ArrayList<>();

    public Console() {

    }

    public void write(String s) {
        int last = lines.size() - 1;
        lines.set(last, lines.get(last) + s);
    }

    public void writeln(String s) {
        lines.add(s);
    }
}
