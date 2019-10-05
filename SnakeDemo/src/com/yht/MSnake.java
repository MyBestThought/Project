package com.yht;

import javax.swing.*;
import java.awt.*;

public class MSnake {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(10, 10, 1200, 720);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new MPanel());
        jFrame.setVisible(true);
        jFrame.setTitle("贪吃蛇游戏");
    }
}
