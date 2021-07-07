package com.company.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private static int WIDTH = 30, HEIGHT = 30;
    private int x, y;

    private TankFrame tankFrame;
    private boolean live = true;

    private Dir dir;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics graphicsg) {
        if(!this.live){
            tankFrame.bulletList.remove(this);
        }
        Color color = graphicsg.getColor();
        graphicsg.setColor(Color.red);
        graphicsg.fillOval(x, y, WIDTH, HEIGHT);
        graphicsg.setColor(color);
        move();
    }

    private void move() {
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
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
