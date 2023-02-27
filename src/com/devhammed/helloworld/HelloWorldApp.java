package com.devhammed.helloworld;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class HelloWorldApp extends MIDlet implements CommandListener {
    private Display display;
    private Form mainScreen;
    private Command exitCommand;

    public void startApp() throws MIDletStateChangeException {
        // Get the Display object for the MIDlet
        display = Display.getDisplay(this);

        // Build MIDlet UI
        if (mainScreen == null) {
            // Create a new form
            mainScreen = new Form("Hello World App");

            // Create the Exit command
            exitCommand = new Command("Exit", Command.EXIT, 2);

            // Add StringItem to form
            mainScreen.append(new StringItem("", "Hello, partner!"));

            // Set the Exit command
            mainScreen.addCommand(exitCommand);

            // Set MIDlet as command listener
            mainScreen.setCommandListener(this);
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
