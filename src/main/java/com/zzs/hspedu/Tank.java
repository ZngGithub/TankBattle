package com.zzs.hspedu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/7/24 15:16
 * @description：公共坦克坐标
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int moveNum;
    private int type;

    public void moveUp() {
        this.y -= moveNum;
    }

    public void moveRight() {
        this.x += moveNum;
    }

    public void moveDown() {
        this.y += moveNum;
    }

    public void moveLeft() {
        this.x -= moveNum;
    }
}
