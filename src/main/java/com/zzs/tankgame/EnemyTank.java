package com.zzs.tankgame;

import java.util.List;
import java.util.Vector;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 17:26
 * @description：敌人坦克
 */
public class EnemyTank extends Tank implements Runnable{
    public Vector<Bullet> bullets = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y, 2, 6, 1);
    }



    // 自由移动
    @Override
    public void run() {
        while (true) {
            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < (750-60)) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setDirection((int)(Math.random() * 4));
            if (!isLife) {
                break;
            }
        }
    }
}
