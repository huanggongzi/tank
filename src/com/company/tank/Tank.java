package com.company.tank;

import java.awt.*;

public class Tank {
    int x;
    int y;
    Dir dir;
    private int SPEED;

    public Tank(int x, int y, Dir dir, int SPEED) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.SPEED = SPEED;
    }

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

    public void setMainTankDir(boolean bL, boolean bR, boolean bU, boolean bD) {
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