package com.devhammed.mediainfo;

import javax.microedition.media.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MediaInfoApp
        extends MIDlet
        implements CommandListener {
    private Display display;
    private Command exitCommand;
    private Form mInformationForm;

    public MediaInfoApp() {
        display = Display.getDisplay(this);

        exitCommand = new Command("Exit", Command.EXIT, 0);

        mInformationForm = new Form("Content types and protocols");

        String[] contentTypes = Manager.getSupportedContentTypes(null);

        for (int i = 0; i < contentTypes.length; i++) {
            String[] protocols = Manager.getSupportedProtocols(contentTypes[i]);

            for (int j = 0; j < protocols.length; j++) {
                StringItem si = new StringItem(contentTypes[i] + ": ",
                        protocols[j]);

                si.setLayout(Item.LAYOUT_NEWLINE_AFTER);

                mInformationForm.append(si);
            }
        }

        mInformationForm.addCommand(exitCommand);

        mInformationForm.setCommandListener(this);
    }

    public void startApp() {
        display.setCurrent(mInformationForm);
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
