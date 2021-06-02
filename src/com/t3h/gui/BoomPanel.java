package com.t3h.gui;

import com.t3h.model.Character;
import com.t3h.model.GameManager;
import com.t3h.utils.ImageLoader;
import com.t3h.utils.SoundLoader;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BoomPanel extends JPanel implements KeyListener, Runnable {
    private Image imgBackground = ImageLoader.getImage("back_ground_01.png", getClass());
    private GameManager manager = new GameManager();
    private boolean[] flags = new boolean[256];
    private Clip clip;

    public BoomPanel() {
        manager.initGame();
        setFocusable(true);
        addKeyListener(this);

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(imgBackground, 0, 0, null);
        manager.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        flags[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        flags[e.getKeyCode()] = false;
    }

    private void checkSoundMove() {
        if (flags[KeyEvent.VK_LEFT] || flags[KeyEvent.VK_RIGHT] || flags[KeyEvent.VK_UP] || flags[KeyEvent.VK_DOWN]) {
            if (clip == null) {
                clip = SoundLoader.play("move.wav");
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } else {
            if (clip != null) {
                clip.stop();
                clip = null;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            if (flags[KeyEvent.VK_LEFT]) {
                manager.playerMove(Character.LEFT);
            } else if (flags[KeyEvent.VK_RIGHT]) {
                manager.playerMove(Character.RIGHT);
            } else if (flags[KeyEvent.VK_UP]) {
                manager.playerMove(Character.UP);
            } else if (flags[KeyEvent.VK_DOWN]) {
                manager.playerMove(Character.DOWN);
            }
            if (flags[KeyEvent.VK_SPACE]) {
                manager.fireBoom();
            }

            checkSoundMove();

            boolean isDie = manager.AI();
            if (isDie) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to play again", "Game over",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    manager.initGame();
                    flags = new boolean[256];
                } else {
                    MenuFrame frame = new MenuFrame();  //mở lại menu nếu chọn NO
                    frame.setVisible(true);
                    SwingUtilities.getWindowAncestor(this).dispose();
                    return;
                }
            }
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
