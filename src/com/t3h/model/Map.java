package com.t3h.model;

import com.t3h.utils.ImageLoader;

import java.awt.*;
import java.util.ArrayList;

public class Map {
    private int x;
    private int y;
    private int bit;

    private Image[] images = {ImageLoader.getImage("map_00.PNG", getClass()),
            ImageLoader.getImage("map_01.PNG", getClass()),
            ImageLoader.getImage("map_02.PNG", getClass()),
            ImageLoader.getImage("map_03.PNG", getClass()),
            ImageLoader.getImage("map_04.PNG", getClass()),
            ImageLoader.getImage("map_05.PNG", getClass()),
            ImageLoader.getImage("map_06.PNG", getClass())
    };

    public Map(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public void draw(Graphics2D g2d) {
        if (bit == 5 || bit == 6) {
            g2d.drawImage(images[bit - 1], x, y+10, 109, 80, null);
            return;
        }
        g2d.drawImage(images[bit - 1], x, y, null);
//        int w = images[bit - 1].getWidth(null)-14;
//        int h = images[bit - 1].getHeight(null)-30;
//        g2d.drawRect(x+7, y+25, w, h);
    }

    public int getBit() {
        return bit;
    }

    public Rectangle getRect() {
        int w = images[bit - 1].getWidth(null)-14;
        int h = images[bit - 1].getHeight(null) -30;
        return new Rectangle(x+7, y+25, w, h);
    }
}
