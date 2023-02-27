package com.devhammed.olympics;

import javax.microedition.lcdui.*;

class OlympicsCanvas extends Canvas {
    private OlympicsApp app;

    public OlympicsCanvas(OlympicsApp app) {
        // Setup super class
        super();

        // Set application
        this.app = app;

        // Set full screen mode.
        setFullScreenMode(true);
    }

    public void paint(Graphics g) {
        // Get dimensions
        int w = getWidth();
        int h = getHeight();

        // Clear canvas
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, w, h);

        // Draw the first row of circles
        g.setColor(0, 0, 255); // Blue
        g.drawArc(5, 5, 25, 25, 0, 360);
        g.setColor(0, 0, 0); // Black
        g.drawArc(35, 5, 25, 25, 0, 360);
        g.setColor(255, 0, 0); // Red
        g.drawArc(65, 5, 25, 25, 0, 360);

        // Draw the second row of circles
        g.setColor(255, 255, 0); // Yellow
        g.drawArc(20, 20, 25, 25, 0, 360);
        g.setColor(0, 255, 0); // Green
        g.drawArc(50, 20, 25, 25, 0, 360);

        // Add "Exit" button
        g.setColor(0, 0, 0);
        g.drawString("Exit", w - 2, h - 2, Graphics.BOTTOM | Graphics.RIGHT);
    }

    protected void keyPressed(int keyCode) {
        switch (keyCode) {
            case -7:
                app.destroyApp(false);
                app.notifyDestroyed();
                break;
            default:
                super.keyPressed(keyCode);
                break;
        }
    }
}
