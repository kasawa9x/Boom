package com.t3h.model;

import com.t3h.utils.ImageLoader;

import java.awt.*;
import java.util.Random;

public class Boss extends Character {
    private Random rd = new Random();

    public Boss(int x, int y) {
        super(x, y, DOWN);
        images = new Image[4][4];
        images[LEFT][0] = ImageLoader.getImage("boss_left_01.png", getClass());
        images[LEFT][1] = ImageLoader.getImage("boss_left_02.png", getClass());
        images[LEFT][2] = ImageLoader.getImage("boss_left_03.png", getClass());
        images[LEFT][3] = ImageLoader.getImage("boss_left_04.png", getClass());

        images[RIGHT][0] = ImageLoader.getImage("boss_right_01.PNG", getClass());
        images[RIGHT][1] = ImageLoader.getImage("boss_right_02.PNG", getClass());
        images[RIGHT][2] = ImageLoader.getImage("boss_right_03.png", getClass());
        images[RIGHT][3] = ImageLoader.getImage("boss_right_04.png", getClass());

        images[UP][0] = ImageLoader.getImage("boss_up_01.PNG", getClass());
        images[UP][1] = ImageLoader.getImage("boss_up_02.PNG", getClass());
        images[UP][2] = ImageLoader.getImage("boss_up_03.PNG", getClass());
        images[UP][3] = ImageLoader.getImage("boss_up_04.PNG", getClass());

        images[DOWN][0] = ImageLoader.getImage("boss_down_01.PNG",getClass());
        images[DOWN][1] = ImageLoader.getImage("boss_down_02.PNG",getClass());
        images[DOWN][2] = ImageLoader.getImage("boss_down_03.PNG",getClass());
        images[DOWN][3] = ImageLoader.getImage("boss_down_04.PNG",getClass());

    }

    public void generateOrient() {
        int percent = rd.nextInt(101);
        if (percent <= 95) {
            return;
        }
        int newOrient = rd.nextInt(4);
        orient = newOrient;
    }
}
