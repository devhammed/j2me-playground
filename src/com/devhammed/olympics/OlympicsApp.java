package com.devhammed.olympics;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class OlympicsApp extends MIDlet {
    private Display display;
    private OlympicsCanvas mainScreen;

    public void startApp() throws MIDletStateChangeException {
        // Get the Display object for the MIDlet
        display = Display.getDisplay(this);

        // Build UI if needed
        if (mainScreen == null) {
            mainScreen = new OlympicsCanvas(this);
        }

        // Set the current display to the screen
        display.setCurrent(mainScreen);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {

    }
}
