package com.company.tank;

import java.awt.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
