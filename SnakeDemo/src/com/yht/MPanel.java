package com.yht;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MPanel extends JPanel implements KeyListener, ActionListener {

    //开始按钮
    JButton startButton = new JButton();
    //暂停按钮
    JButton pauseButton = new JButton();
    //结束按钮
    JButton endButton = new JButton();
    //文本信息
    JLabel label = new JLabel();

    //加载资源
    ImageIcon title = new ImageIcon("resources/title.png");
    ImageIcon up = new ImageIcon("resources/up.png");
    ImageIcon down = new ImageIcon("resources/down.png");
    ImageIcon left = new ImageIcon("resources/left.png");
    ImageIcon right = new ImageIcon("resources/right.png");
    ImageIcon body = new ImageIcon("resources/body.png");
    ImageIcon food = new ImageIcon("resources/food.png");
    ImageIcon show = new ImageIcon("resources/1.jpg");
    ImageIcon titleRight = new ImageIcon("resources/2.gif");

    //蛇的长度
    int len = 0;
    //分数
    int score = 0;

    //坐标
    int[] snakeBodyX = new int[750];
    int[] snakeBodyY = new int[750];

    //方向
    String direction = "R";
    //游戏开始
    boolean isStarted = false;
    //是否已死
    boolean isDeaded = false;

    //定时器
    Timer timer = new Timer(400, this);

    //食物的坐标
    int foodX = 0;
    int foodY = 0;
    //随机数
    Random random = new Random();

    public MPanel() {
        initSnake();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    /**
     * 初始化：蛇的长度；蛇的位置；食物的位置；方向；分数
     */
    private void initSnake(){
        len = 3;
        snakeBodyX[0] = 100;
        snakeBodyY[0] = 100;
        snakeBodyX[1] = 75;
        snakeBodyY[1] = 100;
        snakeBodyX[2] = 50;
        snakeBodyY[2] = 100;

        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);

        direction= "R";

        score = 0;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.GREEN);//设置背景颜色为白色
        title.paintIcon(this, g, 25, 11);//设置标题位置
        g.fillRect(25, 75, 850, 600);//窗口大小
        g.setColor(Color.BLACK);//窗口颜色
        g.setFont(new Font("Ms Song", Font.BOLD, 20));//字体
        g.drawString("当前分数为: " + (isDeaded ? 0 : score), 950, 75);//分数
        titleRight.paintIcon(this, g, 750, 11);
        startButtonOperation();
        pauseButtonOperation();
        endButtonOperation();

        if(isStarted){
            show = new ImageIcon("resources/3.png");
        }
        if(isDeaded){
            show = new ImageIcon("resources/4.gif");
        }
        show.paintIcon(this, g, 900, 475);
        //根据方向，设置蛇头的起始位置
        setHeaderPosition(g);

        //蛇的身体
        for (int i = 1; i < len; i++) {
            body.paintIcon(this, g, snakeBodyX[i], snakeBodyY[i]);
        }

        //食物
        food.paintIcon(this, g, foodX, foodY);

        gameStart(g);
        gameOver(g);
        //操作提示
        opertionTips(g);



    }

    private void opertionTips(Graphics g) {
        g.setColor(Color.RED);//窗口颜色
        g.setFont(new Font("Ms Song", Font.BOLD, 12));//字体
        g.drawString("帮助：", 875, 325);//分数
        g.drawString("1，使用键盘的上下左右箭头控制蛇的运动", 875, 350);//分数
        g.drawString("2，点击开始按钮或按下空格键开始游戏", 875, 375);//分数
        g.drawString("3，点击暂停按钮暂停游戏", 875, 400);//分数
        g.drawString("4，游戏开始后按下空格键暂停，再次按下继续游戏", 875, 425);//分数
        g.drawString("5，点击结束按钮退出游戏", 875, 450);//分数
    }

    private void setHeaderPosition(Graphics g) {
        if(direction.equals("U")){
            up.paintIcon(this, g, snakeBodyX[0], snakeBodyY[0]);
        }else if(direction.equals("D")){
            down.paintIcon(this, g, snakeBodyX[0], snakeBodyY[0]);
        }else if(direction.equals("L")){
            left.paintIcon(this, g, snakeBodyX[0], snakeBodyY[0]);
        }else if(direction.equals("R")){
            right.paintIcon(this, g, snakeBodyX[0], snakeBodyY[0]);
        }
    }

    private void gameStart(Graphics g) {
        //游戏如果没开始，显示提示信息--按下空格即开始
        if(isStarted == false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ms Song", Font.BOLD, 40));
            g.drawString("Press space to start……", 240, 480);
        }
    }

    private void gameOver(Graphics g) {
        //判断是否死亡，显示提示信息--按下空格重新开始
        if(isDeaded){
            g.setColor(Color.RED);
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString("You are deaded : Press space to restart……", 120, 480);
            if(FileOperation.file.exists()){
                String str = FileOperation.readScore().split("：")[1];
                int readScore = Integer.parseInt(str);
                if(readScore < score){
                    FileOperation.writeMessage("历史最高分数为：" + score);
                }
            }else{
                try {
                    FileOperation.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileOperation.writeMessage("历史最高分数为：" + score);
            }


        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //获取按键信息
        int keyCode = e.getKeyCode();
        //如果空格键按下，表明游戏开始
        if(keyCode == KeyEvent.VK_SPACE){
            //如果已死，重新开始；
            if(isDeaded){
                isDeaded = false;
                initSnake();
            }else{
                isStarted = !isStarted;
            }

            repaint();
        }

        //通过箭头的上下左右判断蛇的方向
        if(keyCode == KeyEvent.VK_LEFT){
            direction = "L";
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            direction = "R";
        }
        if(keyCode == KeyEvent.VK_UP){
            direction = "U";
        }
        if(keyCode == KeyEvent.VK_DOWN){
            direction = "D";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏开始，并且没死，游戏继续
        if(isStarted && !isDeaded){
            //初始蛇头方向为右，向右前进
            for (int i = len-1; i > 0; i--) {
                snakeBodyX[i] = snakeBodyX[i-1];
                snakeBodyY[i] = snakeBodyY[i-1];
            }
            //判断蛇的位置
            if(direction.equals("R")){
                snakeBodyX[0] = snakeBodyX[0] + 25;
                if(snakeBodyX[0] > 850){
                    snakeBodyX[0] = 25;
                }
            }

            if(direction.equals("L")){
                snakeBodyX[0] = snakeBodyX[0] - 25;
                if(snakeBodyX[0] < 25){
                    snakeBodyX[0] = 850;
                }
            }

            if(direction.equals("U")){
                snakeBodyY[0] = snakeBodyY[0] - 25;
                if(snakeBodyY[0] < 75){
                    snakeBodyY[0] = 650;
                }
            }

            if(direction.equals("D")){
                snakeBodyY[0] = snakeBodyY[0] + 25;
                if(snakeBodyY[0] > 650){
                    snakeBodyY[0] = 75;
                }
            }
            //如果吃掉食物，长度加一；分数加20，并且随机生成食物
            if(snakeBodyX[0] == foodX && snakeBodyY[0] == foodY){
                len++;
                score += 15;

                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);
            }

            speed();

            //如果蛇头和蛇身相碰；表明死亡
            for (int i = 1; i < len; i++) {
                if(snakeBodyX[0] == snakeBodyX[i] && snakeBodyY[0] == snakeBodyY[i]){
                    isDeaded = true;
                    timer.setDelay(400);
                }
            }

            repaint();
        }

        timer.start();
    }

    /**
     * 控制蛇的速度
     */
    private void speed() {
        if(score > 100 && score <= 200){
            timer.setDelay(300);
        }
        if(score > 200 && score <= 500){
            timer.setDelay(200);
        }
        if(score > 500 && score <= 1000){
            timer.setDelay(100);
        }
        if(score > 1000){
            timer.setDelay(80);
        }

    }

    /**
     * 开始按钮
     *
     */
    private void startButtonOperation() {
        startButton.setText("开始");
        startButton.setBounds(950, 150, 150,50);
        this.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStarted = true;
                isDeaded = false;

            }
        });


        String str = FileOperation.readScore().split("：")[1];
        int maxScore = Integer.parseInt(str);
        if(maxScore < score){
            maxScore = score;
        }

        if(!FileOperation.file.exists()){
            label.setText("历史最高分 : " + 0);
        }else{
            label.setText("历史最高分 : " + maxScore);
        }

        label.setSize(100, 50);
        label.setFont(new Font("Ms Song", Font.BOLD, 20));
        label.setBounds(950, 100, 200,50);
        this.add(label);
    }

    private void pauseButtonOperation() {
        pauseButton.setText("暂停");
        pauseButton.setBounds(950, 200, 150, 50);
        this.add(pauseButton);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStarted = !isStarted;
            }
        });
    }

    private void endButtonOperation(){
        endButton.setText("结束");
        endButton.setBounds(950, 250, 150, 50);
        this.add(endButton);
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }




}
