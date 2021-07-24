package com.zzs.tankgame;

import lombok.Data;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 18:10
 * @description：子弹
 */
@Data
public class Bullet implements Runnable{
    private int x;
    private int y;
    private int direction;
    private int speed = 50;
    private boolean isLive = true; //是否存活

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        // 子弹的速度
        while (true) {
            try {
                Thread.sleep(50); // 休眠50ms, 避免子弹一下走完
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            switch (direction) {
                case 0: // 向上
                    y -= speed;
                    break;
                case 1: // 向右
                    x += speed;
                    break;
                case 2: // 向下
                    y += speed;
                    break;
                case 3: // 向左
                    x -= speed;
                    break;
            }
            System.out.println("子弹x="+ x + "\n" + "y=" + y);
            // 到达边界退出循环
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;
                break;
            }
        }
        if (!isLive) {
            System.out.println("子弹绘画退出");
        }
    }
}
