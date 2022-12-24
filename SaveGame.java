package com.mygdx.game;

import java.io.*;
import java.util.ArrayList;

public class SaveGame {
    private static ArrayList<NewGame> saved_games;
    public SaveGame(){
        saved_games = new ArrayList<NewGame>();
    }
    public static void saveandexit(NewGame game_object) throws IOException {

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("out.txt"));
            out.writeObject(game_object);
        }
        finally {
            if (out != null) {
                out.close();
            }
        }
        saved_games.add(game_object);

    }
    public static NewGame loadsavedgame() throws IOException,ClassNotFoundException{
        ObjectInputStream in = null;
        NewGame s1;
        try {
            in = new ObjectInputStream (new FileInputStream("out.txt"));
            s1 = (NewGame) in.readObject();
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
        return s1;

    }

}

