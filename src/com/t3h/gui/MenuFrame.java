package com.t3h.gui;

import javax.swing.*;

public class MenuFrame extends JFrame {
    public MenuFrame(){
        setSize(780,676);
        setTitle("menu");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MenuPanel panel = new MenuPanel();
        add(panel);
    }
}
