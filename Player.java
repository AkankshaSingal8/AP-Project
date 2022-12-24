package com.mygdx.game;

public class Player {
    private Tank myTank;
    private int FuelPerTurn;

    public Player(int fuel){
        this.FuelPerTurn = fuel;
    }

    public void setfuel(int fuel) {
        this.FuelPerTurn = fuel;
    }

    public void setTank(Tank t){
        myTank = t;
    }


    public void upgradeweapon(Weapon w){
        myTank.upgradeCurrentWeapon(w);
    }

    public void moveTank(){

    }
    public void setAngle(int angle){
        myTank.setAngle(angle);
    }
    public void fireShot(){

    }


    public void setPower(int power){
        myTank.setPower(power);
    }
    public Tank getTank(){
        return this.myTank;

    }
    public int getFuel(){
        return this.FuelPerTurn;
    }
}

