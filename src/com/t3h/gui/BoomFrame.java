package com.t3h.gui;

import javax.swing.*;

public class BoomFrame extends JFrame {
    public static final int W_FRAME = 794;
    public static final int H_FRAME = 820;

    public BoomFrame() {
        setTitle("Boom");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BoomPanel panel = new BoomPanel();
        add(panel);
    }
}
