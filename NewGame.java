package com.mygdx.game;

import java.io.Serializable;

public class NewGame implements Serializable {
    private String Name;
    private Player Player1;
    private Player Player2;
    private Player Winner;
    private Player currentPlayer;

    public NewGame(){

    }

    public void setPlayer1Tank(int option){
        Tank t;
        if (option == 1){
            t = new BlazerTank();
        }
        else if (option == 2){
            t = new FrostTank();
        }
        else{
            t = new AbramsTank();
        }
        Player1.setTank(t);
    }
    public void setPlayer2Tank(int option){
        Tank t;
        if (option == 1){
            t = new BlazerTank();
        }
        else if (option == 2){
            t = new FrostTank();
        }
        else{
            t = new AbramsTank();
        }
        Player2.setTank(t);
    }

    public Player getPlayer1(){
        return this.Player1;
    }
    public Player getPlayer2(){
        return this.Player2;
    }

}

