package com.company.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

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

        switch (dir) {
            case LEFT:
                x = x - SPEED;
                break;
            case RIGHT:
                x = x + SPEED;
                break;
            case UP:
                y = y - SPEED;
                break;
            case DOWN:
                y = y + SPEED;
                break;
        }
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
            setMainTankDir();
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
            setMainTankDir();
        }

        public void setMainTankDir() {
            if (bL) {
                dir = Dir.LEFT;
            }
            if (bR) {
                dir = Dir.RIGHT;
            }
            if (bU) {
                dir = Dir.UP;
            }
            if (bD) {
                dir = Dir.DOWN;
            }
        }
    }
}
