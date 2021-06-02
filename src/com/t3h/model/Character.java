package com.t3h.model;

import com.t3h.gui.BoomFrame;

import java.awt.*;
import java.util.ArrayList;

public abstract class Character {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    protected int x;
    protected int y;
    protected Image[][] images;
    protected int orient;
    protected int speed = 1;
    protected int index;
    protected int count;

    public Character(int x, int y, int orient) {
        this.x = x;
        this.y = y;
        this.orient = orient;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[orient][index], x, y, null);
//        int w = images[orient][index].getWidth(null) - 30;
//        int h = images[orient][index].getHeight(null) - 35;
//        g2d.drawRect(x + 15, y + 30, w, h);
    }

    private boolean checkMap(ArrayList<Map> arr) {
        for (Map m : arr) {
            Rectangle rect = getRect().intersection(m.getRect());
            if (rect.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

    public void move(ArrayList<Map> arr) {
        int xR = x;
        int yR = y;

        switch (orient) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
        if (x <= 0 || x >= BoomFrame.W_FRAME - images[orient][index].getWidth(null) - 10) {
            x = xR;
        }
        if (y <= 0 || y >= BoomFrame.H_FRAME - images[orient][index].getHeight(null) - 37) {
            y = yR;
        }
        count++;
        if (count >= 15) {
            index++;
            if (index >= images[orient].length) {
                index = 0;
            }
            count = 0;
        }
        if (checkMap(arr) == false) {
            x = xR;
            y = yR;
        }
    }

    public Rectangle getRect() {
        int w = images[orient][index].getWidth(null) - 30;
        int h = images[orient][index].getHeight(null) - 35;
        Rectangle rect = new Rectangle(x + 15, y + 30, w, h);
        return rect;
    }
}
