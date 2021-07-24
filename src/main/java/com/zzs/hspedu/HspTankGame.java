package com.zzs.hspedu;

import javax.swing.*;
import java.util.Vector;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 15:25
 * @description：
 */
public class HspTankGame extends JFrame {
    private MyPanel mp;
    public static void main(String[] args) {
        new HspTankGame();
    }
    public HspTankGame() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp); // 增加键盘监听事件
        this.setSize(1000, 750); // 设置界面大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭终止
        this.setVisible(true); // 展示
    }

}
