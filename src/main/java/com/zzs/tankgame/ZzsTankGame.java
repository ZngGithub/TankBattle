package com.zzs.tankgame;

import javax.swing.*;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 15:25
 * @description：
 */
public class ZzsTankGame extends JFrame {
    private MyPanel mp;
    public static void main(String[] args) {
        new ZzsTankGame();
    }

    public ZzsTankGame() {
        mp = new MyPanel();
        Thread thread = new Thread(mp); // 子弹重绘线程
        thread.start();
        this.add(mp);
        this.addKeyListener(mp); // 增加键盘监听事件
        this.setSize(1000, 750); // 设置界面大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭终止
        this.setVisible(true); // 展示
    }

}
