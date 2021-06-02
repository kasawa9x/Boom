package com.t3h.model;

import com.t3h.utils.ImageLoader;
import com.t3h.utils.SoundLoader;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.ArrayList;

public class Player extends Character {
    private int hp;
    private Clip clip;

    public Player(int x, int y, int hp) {
        super(x, y, DOWN);
        this.hp = hp;
        images = new Image[4][5];
        images[LEFT][0] = ImageLoader.getImage("boomber_left_02.png", getClass());
        images[LEFT][1] = ImageLoader.getImage("boomber_left_03.png", getClass());
        images[LEFT][2] = ImageLoader.getImage("boomber_left_04.png", getClass());
        images[LEFT][3] = ImageLoader.getImage("boomber_left_05.png", getClass());
        images[LEFT][4] = ImageLoader.getImage("boomber_left_06.png", getClass());

        images[RIGHT][0] = ImageLoader.getImage("boomber_right_02.png", getClass());
        images[RIGHT][1] = ImageLoader.getImage("boomber_right_03.png", getClass());
        images[RIGHT][2] = ImageLoader.getImage("boomber_right_04.png", getClass());
        images[RIGHT][3] = ImageLoader.getImage("boomber_right_05.png", getClass());
        images[RIGHT][4] = ImageLoader.getImage("boomber_right_06.png", getClass());

        images[UP][0] = ImageLoader.getImage("boomber_up_02.png", getClass());
        images[UP][1] = ImageLoader.getImage("boomber_up_03.png", getClass());
        images[UP][2] = ImageLoader.getImage("boomber_up_04.png", getClass());
        images[UP][3] = ImageLoader.getImage("boomber_up_05.png", getClass());
        images[UP][4] = ImageLoader.getImage("boomber_up_06.png", getClass());

        images[DOWN][0] = ImageLoader.getImage("boomber_down_02.png", getClass());
        images[DOWN][1] = ImageLoader.getImage("boomber_down_03.png", getClass());
        images[DOWN][2] = ImageLoader.getImage("boomber_down_04.png", getClass());
        images[DOWN][3] = ImageLoader.getImage("boomber_down_05.png", getClass());
        images[DOWN][4] = ImageLoader.getImage("boomber_down_06.png", getClass());
    }


    public void changeOrient(int newOrient) {
        this.orient = newOrient;
    }

    private long t;

    public void boom(ArrayList<Boom> arr) {
        long T = System.currentTimeMillis();
        if (T - t < 2300) {
            return;
        }
        t = T;
        try {
            int xB = x + images[orient][index].getWidth(null) / 2 ;
            int yB = y + images[orient][index].getHeight(null)/2 +10;
            Boom b = new Boom(xB, yB);
            arr.add(b);
            clip = SoundLoader.play("set_boom.wav");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public boolean checkDie(ArrayList<Boss> arr) {
//        for (Boss b : arr) {
//            Rectangle rect = b.getRect().intersection(getRect());
//            if (rect.isEmpty() == false) {
//                return true;
//            }
//        }
//        return false;
//    }
}
