package com.zzs.tankgame;

import java.util.List;
import java.util.Vector;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 17:26
 * @description：敌人坦克
 */
public class EnemyTank extends MyTank {

    public Vector<Bullet> bullets = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y, 2, 6, 1);
    }
}
