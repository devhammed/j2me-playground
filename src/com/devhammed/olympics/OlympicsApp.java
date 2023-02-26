package com.devhammed.olympics;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class OlympicsApp extends MIDlet implements CommandListener {
    private Display display;
    private Command exitCommand;
    private OlympicsCanvas mainScreen;

    public OlympicsApp() {
        // Get the Display object for the MIDlet
        display = Display.getDisplay(this);

        // Create the Exit command
        exitCommand = new Command("Exit", Command.EXIT, 2);

        // Create the main screen form
        mainScreen = new OlympicsCanvas();

        // Set the Exit command
        mainScreen.addCommand(exitCommand);
        mainScreen.setCommandListener(this);
    }

    public void startApp() throws MIDletStateChangeException {
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
