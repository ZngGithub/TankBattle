package com.zzs.tankgame;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 15:20
 * @description：游戏绘图区
 */
@Data
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // 定义自己的坦克
    MyTank myTank = null;
    // 定义子弹
    Bullet bullet = null;
    private Vector<EnemyTank> enemyTanks = new Vector(); // 敌人坦克
    private int enemyNum = 3; // 默认三个敌人

    public MyPanel() {
        // 初始化坦克
        myTank = new MyTank(100, 100, 0, 6, 0);

        // 初始化敌方坦克
        for (int i = 0; i < enemyNum; i++) {
            EnemyTank enemyTank = new EnemyTank(i * 100, 0);
            // 初始化子弹 默认朝下
            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            enemyTank.bullets.add(bullet);
            new Thread(bullet).start();
            // 添加坦克
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形默认黑色
        // 画出已方坦克
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(), myTank.getType());

        // 画出所有敌人
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), enemyTank.getType());
            for (int i = 0; i < enemyTank.bullets.size(); i++) {
                Bullet bullet = enemyTank.bullets.get(i);
                if (bullet.isLive()) {
                    g.draw3DRect(bullet.getX(), bullet.getY(), 10, 10, false);
                }
            }
        }

        // 绘画子弹
        if (myTank.getBullet() != null && myTank.getBullet().isLive()) {
            g.setColor(Color.white);
//            g.fill3DRect(myTank.getBullet().getX(), myTank.getBullet().getY(), 10, 10, false);
            g.draw3DRect(myTank.getBullet().getX(), myTank.getBullet().getY(), 10, 10, false);
        }

    }


    /**
     * @param x         x坐标
     * @param y         y坐标
     * @param g         画笔
     * @param direction 方向
     * @param type      类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0: // 已方坦克
                g.setColor(Color.blue);
                break;
            case 1: // 敌人坦克
                g.setColor(Color.red);
                break;
        }

        switch (direction) {
            case 0: // 向上
                g.fill3DRect(x, y, 10, 60, false); // 画出坦克左边
                g.fill3DRect(x + 30, y, 10, 60, false); // 画出坦克右边
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 画出坦克中间
                g.fillOval(x + 10, y + 20, 20, 20); // 画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y); // 画出直线
                break;
            case 1: // 向右
                g.fill3DRect(x, y, 60, 10, false); // 画出坦克左边
                g.fill3DRect(x, y + 30, 60, 10, false); // 画出坦克右边
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 画出坦克中间
                g.fillOval(x + 20, y + 10, 20, 20); // 画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20); // 画出直线
                break;
            case 2: // 向下
                g.fill3DRect(x, y, 10, 60, false); // 画出坦克左边
                g.fill3DRect(x + 30, y, 10, 60, false); // 画出坦克右边
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 画出坦克中间
                g.fillOval(x + 10, y + 20, 20, 20); // 画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60); // 画出直线
                break;
            case 3: // 向左
                g.fill3DRect(x, y, 60, 10, false); // 画出坦克左边
                g.fill3DRect(x, y+ 30, 60, 10, false); // 画出坦克右边
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 画出坦克中间
                g.fillOval(x + 20, y + 10, 20, 20); // 画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20); // 画出直线
                break;
            default:
                System.out.println("暂时不处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 处理键盘映射
    @Override
    public void keyPressed(KeyEvent e) {
        // WSAD 进行坦克方向处理, 处理坐标
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            myTank.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            for (int i = 0; i < 100; i++) {
                // 发射子弹
                myTank.shotEnemyTank();
            }

        }
        // 进行重新绘画
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 原则重绘子弹
            this.repaint();
        }
    }
}
