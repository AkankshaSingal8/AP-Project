package com.mygdx.game;

import java.lang.Math;
public class Attack {
    private int impactOfWeapon;
    public static int calcDistanceBwTanks(int t1x, int t1y, int t2x, int t2y){
        int a= t2x - t1x;
        int b = t2y - t1y;
        int sqa = (int) Math.pow(a, 2);
        int sqb = (int) Math.pow(b, 2);
        int res = sqa + sqb;
        int val = (int) Math.pow(res, 0.5);
        return val;
    }

}

