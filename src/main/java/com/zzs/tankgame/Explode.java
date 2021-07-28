package com.zzs.tankgame;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/28 20:08
 * @description：爆炸
 */
@Data
public class Explode {
    private int x;
    private int y;
    // 生命周期
    private int life = 9;
    private boolean isLive = false;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void liftDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
