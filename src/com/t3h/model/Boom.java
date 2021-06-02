package com.t3h.model;

import com.t3h.utils.ImageLoader;
import com.t3h.utils.SoundLoader;

import javax.sound.sampled.Clip;
import java.awt.*;

public class Boom {
    private int x, y, time = 450;
    private Clip clip;
    private int index;
    private Image[] image = {ImageLoader.getImage("boom_01.PNG", getClass()),
            ImageLoader.getImage("boom_02.PNG", getClass()),
            ImageLoader.getImage("boom_03.PNG", getClass()),
            ImageLoader.getImage("boom_04.PNG", getClass()),
            ImageLoader.getImage("boom_05.PNG", getClass()),
            ImageLoader.getImage("boom_06.PNG", getClass()),
            ImageLoader.getImage("boom_07.PNG", getClass()),
            ImageLoader.getImage("boom_08.PNG", getClass()),
            ImageLoader.getImage("no1.png", getClass()),
            ImageLoader.getImage("no2.png", getClass()),
            ImageLoader.getImage("no3.png", getClass()),
            ImageLoader.getImage("no4.png", getClass())
    };

    public Boom(int x, int y) {
        this.x = x - image[index].getWidth(null) / 2;
        this.y = y - image[index].getHeight(null) / 2;
    }

    public int getIndex() {
        return index;
    }

    public boolean draw(Graphics2D g2d) {
        time--;
        if (time <= 0) {
            return true;
        }
        if (time ==40){  clip = SoundLoader.play("boom_bang.wav");}
        if (time <= 20) {
            index = 11;
        } else if (time <= 40) {
            index = 10;
        } else if (time <= 60) {
            index = 9;
        } else if (time <= 80) {
            index = 8;
        } else if (time <= 100) {
            index = 7;
        } else if (time <= 120) {
            index = 6;
        } else if (time <= 140) {
            index = 5;
        } else if (time <= 160) {
            index = 4;
        } else if (time <= 180) {
            index = 3;
        } else if (time <= 200) {
            index = 2;
        } else if (time <= 220) {
            index = 1;
        } else if (time <= 240) {
            index = 7;
        } else if (time <= 260) {
            index = 6;
        } else if (time <= 280) {
            index = 5;
        } else if (time <= 300) {
            index = 4;
        } else if (time <= 320) {
            index = 3;
        } else if (time <= 340) {
            index = 2;
        } else if (time <= 360) {
            index = 1;
        } else if (time <= 380) {
            index = 7;
        } else if (time <= 400) {
            index = 6;
        } else if (time <= 420) {
            index = 5;
        } else if (time <= 440) {
            index = 4;
        } else if (time <= 450) {
            index = 3;
        } else {
            index = 0;
        }
        if (index >= 0 && index <= 7) {
            g2d.drawImage(image[index], x, y, null);
        } else {
            g2d.drawImage(image[index], x - 35, y - 20, null);
        }
//        int w = image[index].getWidth(null);
//        int h = image[index].getHeight(null);
//        int xR = x - 35 + w/2 -5;
//        int yR = y - 20 + h/2 - 5;
//        g2d.drawRect(xR, y -20, 10, h);
//        g2d.drawRect(x-35, yR, w, 10);
        return false;
    }

    public boolean checkRect(Rectangle rect) {
        int w = image[index].getWidth(null);
        int h = image[index].getHeight(null);
        int xR = x - 35 + w/2 - 5;
        int yR = y  -20+ h/2 - 5;

        Rectangle r = new Rectangle(xR, y -20, 10, h);
        if (r.intersection(rect).isEmpty() == false) {
            return false;
        }
        r = new Rectangle(x-35, yR, w, 10);
        if (r.intersection(rect).isEmpty() == false) {
            return false;
        }
        return true;
    }
}
