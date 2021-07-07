package com.company.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    private static int WIDTH = 30, HEIGHT = 30;
    private int x, y;

    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics graphicsg) {
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
    }
}
