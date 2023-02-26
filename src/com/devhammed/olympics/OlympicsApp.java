package com.devhammed.olympics;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class OlympicsApp extends MIDlet {
    private Display display;
    private OlympicsCanvas mainScreen;

    public OlympicsApp() {
        // Get the Display object for the MIDlet
        display = Display.getDisplay(this);

        // Create the main screen form
        mainScreen = new OlympicsCanvas(this);
    }

    public void startApp() throws MIDletStateChangeException {
        // Set the current display to the screen
        display.setCurrent(mainScreen);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {

    }
}
