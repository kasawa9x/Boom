package com.t3h.gui;

import com.t3h.utils.ImageLoader;
import com.t3h.utils.SoundLoader;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {
    private MenuButton btnStart, btnExit;
    private Image bg = ImageLoader.getImage("back_ground_menu.png", getClass());
    private Clip clip;

    public MenuPanel() {
        setLayout(null);
        initComponents();
        clip = SoundLoader.play("background.wav");
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(bg, 0, 0, 780, 676, null);
    }

    private void initComponents() {

        btnStart = new MenuButton("menu_start.PNG", "menu_start_copy.PNG");
        int x = (780 - btnStart.getWidth()) / 2;
        btnStart.setLocation(x - 150, 450);
        add(btnStart);
        btnStart.addActionListener(this);

        btnExit = new MenuButton("menu_exit.PNG", "menu_exit_copy.PNG");
        btnExit.setLocation(x + 150, 450);
        add(btnExit);
        btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnStart)) {
            clip.close();
            clip = SoundLoader.play("click.wav");
            clip =SoundLoader.play("start.wav");
            BoomFrame frame = new BoomFrame();
            frame.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();

        } else {
            clip = SoundLoader.play("click.wav");
//            clip = SoundLoader.play("bye_bye.wav");
            System.exit(0);
        }
    }
}
