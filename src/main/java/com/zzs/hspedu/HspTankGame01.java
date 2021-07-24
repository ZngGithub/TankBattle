package com.zzs.hspedu;

import javax.swing.*;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 15:25
 * @description：
 */
public class HspTankGame01 extends JFrame {
    private MyPanel mp;
    public static void main(String[] args) {
        new HspTankGame01();
    }
    public HspTankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
