package com.company.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 200, Dir.DOWN, 10);
    Tank otherTank = new Tank(100, 100, Dir.DOWN, 10);

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
        myTank.paint(graphicsg);
        otherTank.paint(graphicsg);
    }

    /**
     * 接受键盘的
     */
    class MyKsyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        // 键盘按下发生的方法
        @Override
        public void keyPressed(KeyEvent e) {
            // 键的代码
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                default:
                    break;
            }
            myTank.setMainTankDir(bL, bR, bU, bD);
            otherTank.setMainTankDir(bL, bR, bU, bD);
            // 默认调用paint方法
            // repaint();
        }

        // 键盘抬起来发生的操作
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                default:
                    break;
            }
            myTank.setMainTankDir(bL, bR, bU, bD);
            otherTank.setMainTankDir(bL, bR, bU, bD);
        }
    }
}
