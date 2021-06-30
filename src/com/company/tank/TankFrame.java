package com.company.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200;
    int y = 200;

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKsyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics graphicsg) {
        graphicsg.fillRect(x, y, 50, 50);
        x = x + 10;
        // y = y + 100;
    }

    class MyKsyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            x = x + 200;
            // 默认调用paint方法
            // repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("2");
        }
    }
}
