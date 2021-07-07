package com.company.tank;

import java.awt.*;

public class Tank {
    // 横坐标
    int x;
    // 纵坐标
    int y;
    Dir dir;
    private boolean moving = false;
    private static final int SPEED = 5;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics graphicsg) {
        Color c = graphicsg.getColor();
        graphicsg.setColor(Color.YELLOW);
        graphicsg.fillRect(x, y, 50, 50);
        graphicsg.setColor(c);
        move(moving);
    }

    public void move(boolean moving) {
        System.out.println(dir);
        if (moving) {
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
