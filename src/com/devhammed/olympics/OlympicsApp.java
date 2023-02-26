package com.devhammed.olympics;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class OlympicsApp extends MIDlet implements CommandListener {
    private Display display;
    private Command exitCommand;
    private OlympicsCanvas mainScreen;

    public OlympicsApp() {
        // Create the main screen form
        mainScreen = new OlympicsCanvas();

        // Create the Exit command
        exitCommand = new Command("Exit", Command.EXIT, 2);

        // Set the Exit command
        mainScreen.addCommand(exitCommand);
        mainScreen.setCommandListener(this);
    }

    public void startApp() throws MIDletStateChangeException {
        // Get display for MIDlet
        if (display == null) {
            display = Display.getDisplay(this);
        }

        // Set the current display to the screen
        display.setCurrent(mainScreen);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable s) {
        if (c == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
