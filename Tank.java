package com.mygdx.game;

import java.util.ArrayList;

public class Tank {
    private String Name;
    private ArrayList<Weapon> weapons;
    private Weapon current_weapon;
    private int Health;
    private int Angle;
    private int Fuel;
    private int Power;
    private int Direction;
    private Collision rect;
    InGame inGame;

    public Tank(){
        this.Name = "Tank";
        this.Health = 10;
        this.Angle = 0;
        this.Fuel = 100;
        this.Power = 0;
        this.Direction = 0;
        this.weapons = new ArrayList<Weapon>();
        this.current_weapon = new Weapon();
    }
    public void move(){

    }
    public void fire(){

    }
    public void setHealth(int health){
        this.Health = health;
    }

    public int getHealth(){
        return this.Health;
    }
    public void setAngle(int angle){
        this.Angle = angle;
    }
    public int getAngle(){
        return this.Angle;
    }
    public void upgradeCurrentWeapon(Weapon newWeapon){
        this.current_weapon = newWeapon;
    }
    public Weapon getCurrentWeapon(){
        return this.current_weapon;
    }
    public ArrayList<Weapon> getAvailableWeapons(){
        return this.weapons;
    }
    public void setFuel(int fuel){
        this.Fuel = fuel;
    }
    public int getFuel(){
        return this.Fuel;
    }
    public void setPower(int hp){
        this.Power = hp;
    }
    public int getPower(){
        return this.Power;
    }
    public void setDirection(int dir){
        this.Direction = dir;
    }

    public int getDirection(){
        return this.Direction;
    }

    public Tank checkSelectedTank(){
        return this;
    }



}

