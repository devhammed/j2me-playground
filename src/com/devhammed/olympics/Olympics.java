package com.devhammed.olympics;

import javax.microedition.lcdui.*;

class OlympicsCanvas extends Canvas {
    public void paint(Graphics g) {
        // Set Screen Title
        this.setTitle("Olympics App");

        // Clear canvas
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());

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
    }
}
