package com.t3h.gui;

import com.t3h.utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {
    private Image imNone;
    private Image imSelect;

    public MenuButton(String none,String select) {
        imNone = ImageLoader.getImage(none,getClass());
        imSelect =ImageLoader.getImage(select,getClass());
        setSize(imNone.getWidth(null),imNone.getHeight(null));
        setIcon(new ImageIcon(imNone));
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setIcon(new ImageIcon(imSelect));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setIcon(new ImageIcon(imNone));
    }
}
