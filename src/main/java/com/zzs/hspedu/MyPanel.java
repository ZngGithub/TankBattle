package com.zzs.hspedu;

import javax.swing.*;
import java.awt.*;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 15:20
 * @description：游戏绘图区
 */
public class MyPanel extends JPanel {
    // 定义自己的坦克
    private MyTank myTank = null;

    public MyPanel() {
        myTank = new MyTank(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形默认黑色

        // 画出一个坦克--方法
        drawTank(myTank.getX(), myTank.getY(), g, 0, 0);
        drawTank(myTank.getX() + 60, myTank.getY(), g, 0, 1);

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
                g.setColor(Color.cyan);
                break;
            case 1: // 敌人坦克
                g.setColor(Color.yellow);
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
            default:
                System.out.println("暂时不处理");
        }
    }
}
