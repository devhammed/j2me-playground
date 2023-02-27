package com.devhammed.sysinfo;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class SysInfoApp extends MIDlet implements CommandListener {
    private Display display;
    private Form mainScreen;
    private Command exitCommand;

    public void startApp() throws MIDletStateChangeException {
        // Get the Display object for the MIDlet
        display = Display.getDisplay(this);

        // Build UI if needed
        if (mainScreen == null) {
            // Create the main screen form
            mainScreen = new Form("System Info App");

            // Create the Exit command
            exitCommand = new Command("Exit", Command.EXIT, 2);

            // Obtain the current time
            Calendar calendar = Calendar.getInstance();
            String time = Integer.toString(calendar.get(Calendar.HOUR)) + ":" +
                    Integer.toString(calendar.get(Calendar.MINUTE)) + ":" +
                    Integer.toString(calendar.get(Calendar.SECOND));

            // Obtain the total and free memory, and convert them to strings
            Runtime runtime = Runtime.getRuntime();
            String totalMem = Long.toString(runtime.totalMemory());
            String freeMem = Long.toString(runtime.freeMemory());

            // Obtain the display properties
            String isColor = display.isColor() ? "Yes" : "No";
            String numColors = Integer.toString(display.numColors());

            // Create string items and add them to the screen
            mainScreen.append(new StringItem("", "Time: " + time + "\n"));
            mainScreen.append(new StringItem("", "Total mem: " + totalMem + "\n"));
            mainScreen.append(new StringItem("", "Free mem: " + freeMem + "\n"));
            mainScreen.append(new StringItem("", "Color: " + isColor + "\n"));
            mainScreen.append(new StringItem("", "Number of colors: " + numColors + "\n"));

            // Set the Exit command
            mainScreen.addCommand(exitCommand);
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
