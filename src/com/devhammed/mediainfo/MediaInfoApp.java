package com.devhammed.mediainfo;

import javax.microedition.media.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MediaInfoApp
        extends MIDlet
        implements CommandListener {
    private Display display;
    private Form mainScreen;
    private Command exitCommand;

    public void startApp() {
        // Get display for MIDlet
        display = Display.getDisplay(this);

        // Build UI
        if (mainScreen == null) {
            mainScreen = new Form("Media Information App");

            exitCommand = new Command("Exit", Command.EXIT, 0);

            String[] contentTypes = Manager.getSupportedContentTypes(null);

            for (int i = 0; i < contentTypes.length; i++) {
                String[] protocols = Manager.getSupportedProtocols(contentTypes[i]);

                for (int j = 0; j < protocols.length; j++) {
                    StringItem si = new StringItem(contentTypes[i] + ": ", protocols[j]);

                    si.setLayout(Item.LAYOUT_NEWLINE_AFTER);

                    mainScreen.append(si);
                }
            }

            mainScreen.addCommand(exitCommand);

            mainScreen.setCommandListener(this);
        }

        // Display the main screen
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
