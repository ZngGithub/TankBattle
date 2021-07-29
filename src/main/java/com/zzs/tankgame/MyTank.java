package com.zzs.tankgame;

import lombok.Data;

import java.util.List;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 15:17
 * @description：自己的坦克
 */
@Data
public class MyTank extends Tank{
    public Bullet bullet;

    public MyTank(int x, int y, int direction, int moveNum, int type) {
        super(x, y, direction, moveNum, type);
    }

    public void shotEnemyTank() {
        switch (getDirection()) {
            case 0: // 向上
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1: // 向右
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2: // 向下
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3: // 向左
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }
        // 启动射击线程
        new Thread(bullet).start();
    }
}
