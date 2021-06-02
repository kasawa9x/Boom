package com.t3h.model;

import com.t3h.gui.BoomFrame;
import com.t3h.utils.SoundLoader;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<Map> arrMap;
    private ArrayList<Boom> arrBoom;
    private Clip clip;

    public void initGame() {
        arrMap = MapManager.readMap("map2.txt");
        clip = SoundLoader.play("sound_game.wav");
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        player = new Player(BoomFrame.W_FRAME - 180, BoomFrame.H_FRAME - 225, 1);
        arrBoss = new ArrayList<>();
        generateBoss();

        arrBoom = new ArrayList<>();
    }

    private void generateBoss() {
        Boss boss = new Boss(100, 120);
        arrBoss.add(boss);
        Boss boss1 = new Boss(BoomFrame.W_FRAME / 2 - 40, 115);
        arrBoss.add(boss1);
        Boss boss2 = new Boss(BoomFrame.W_FRAME - 185, 120);
        arrBoss.add(boss2);
        Boss boss3 = new Boss(130, 585);
        arrBoss.add(boss3);
        Boss boss4 = new Boss(100, BoomFrame.H_FRAME / 2 - 115);
        arrBoss.add(boss4);
    }

    public void draw(Graphics2D g2d) {
        for (Map m : arrMap) {
            m.draw(g2d);
        }
        drawBoom(g2d, arrBoom);
        player.draw(g2d);
        for (Boss b : arrBoss) {
            b.draw(g2d);
        }
    }

    private void drawBoom(Graphics2D g2d, ArrayList<Boom> arr) {
        for (Boom b : arr) {
            b.draw(g2d);
        }
    }

    public void fireBoom() {
        player.boom(arrBoom);
    }

    public void playerMove(int newOrient) {
        player.changeOrient(newOrient);
        player.move(arrMap);
    }

    private void checkBoomToMap(ArrayList<Boom> arr) {
        for (int i = arrMap.size() - 1; i >= 0; i--) {
            int bit = arrMap.get(i).getBit();
            if (bit == 2 || bit == 3 || bit == 5 || bit == 7) {
                continue;
            }
            for (Boom b : arr) {
                if (b.checkRect(arrMap.get(i).getRect()) == false && b.getIndex() == 10) {  //boom vs map
                    if (bit == 1 || bit == 4) {
                        arrMap.remove(i);
                        return;
                    }
                }
            }
        }
    }

    private boolean bossContact(ArrayList<Boss> arr) { //playerDie = true
        for (Boss b : arr) {
            Rectangle rect = b.getRect().intersection(player.getRect());
            if (rect.isEmpty() == false) {
                clip.stop();
                clip = SoundLoader.play("die.wav");
                return true;
            }
        }
        return false;
    }

    public boolean AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).generateOrient();
            arrBoss.get(i).move(arrMap);
            checkBoomToMap(arrBoom);

            for (Boom b : arrBoom) {
                if (b.checkRect(arrBoss.get(i).getRect()) == false && b.getIndex() == 10) { //boom vs boss
                    arrBoss.remove(i);
                    break;
                }
            }
            if (arrBoss.size() <= 1) {
                generateBoss();
            }
            for (Boom b : arrBoom) {
                if (b.checkRect(player.getRect()) == false && b.getIndex() == 10) {  //boom vs player
                    clip.close();
                    clip = SoundLoader.play("die.wav");
                    return true;
                }
            }
        }
        return bossContact(arrBoss); //player vs boss
    }
}
