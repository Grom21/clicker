package com.example.clicker;

import java.awt.*;
import java.awt.event.InputEvent;

public class ThreadMouseClicker extends Thread {
    private int x = 0;
    private int y = 0;
    private Robot bot;
    public void run() {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        while (true) {
            while (!HelloApplication.click) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            MouseInfo();
            while (true) {
                bot.mouseMove(x, y);
                bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!HelloApplication.click) {
                    break;
                }
            }
        }
    }

    public void MouseInfo() {
        PointerInfo info = MouseInfo.getPointerInfo();
        Point location = info.getLocation();
        x = (int) location.getX();
        y = (int) location.getY();
    }
}
