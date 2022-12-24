package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SavedGames implements Screen{  // saved games
    private final TankStar game;
    private Texture backgroundImg1, headingb;
    private Texture saved;
    protected final Stage stage;
    protected Skin mySkin;
    Button savedGame1, savedGame2, savedGame3, backButton;
    private int row_height = Gdx.graphics.getWidth() / 12;
    private int col_width = Gdx.graphics.getWidth() / 12;


    public SavedGames(final TankStar game){
        this.game = game;
        backgroundImg1 = new Texture("menu.png");
        headingb = new Texture("tankstars.png");
        saved = new Texture("savedgames.png");
        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        savedGame1 = new TextButton("GAME 1",mySkin,"small");
        savedGame1.setSize(col_width*4,row_height);
        savedGame1.setPosition(Gdx.graphics.getWidth()/2 - savedGame1.getWidth()/2,Gdx.graphics.getHeight()/2 - savedGame1.getHeight()/2 + 30);
        stage.addActor(savedGame1);
        savedGame2 = new TextButton("GAME 2",mySkin,"small");
        savedGame2.setSize(col_width*4,row_height);
        savedGame2.setPosition(Gdx.graphics.getWidth()/2 - savedGame2.getWidth()/2,Gdx.graphics.getHeight()/2 - savedGame2.getHeight()/2 - 120);
        stage.addActor(savedGame2);
        savedGame3 = new TextButton("GAME 3",mySkin,"small");
        savedGame3.setSize(col_width*4,row_height);
        savedGame3.setPosition(Gdx.graphics.getWidth()/2 - savedGame3.getWidth()/2,Gdx.graphics.getHeight()/2 - savedGame3.getHeight()/2 - 280);
        stage.addActor(savedGame3);
    }

    @Override
    public void show(){

    }

    @Override
    public void render(float delta){
        game.batch.begin();
        game.batch.draw(backgroundImg1, 0, 0);
        game.batch.draw(headingb, Gdx.graphics.getWidth()/2  -headingb.getWidth()/2,610);
        game.batch.draw(saved,Gdx.graphics.getWidth()/2  -saved.getWidth()/2,150);
//        game.batch.draw(game1,Gdx.graphics.getWidth()/2  -game1.getWidth()/2,40);
//        game.batch.draw(game2,Gdx.graphics.getWidth()/2  -game2.getWidth()/2,-70);
//        game.batch.draw(game3,Gdx.graphics.getWidth()/2  -game3.getWidth()/2,-180);
//        game.batch.draw(game4,Gdx.graphics.getWidth()/2  -game4.getWidth()/2,-290);
        game.batch.end();
        stage.act();
        stage.draw();

        if (Gdx.input.isKeyPressed(Input.Keys.T)){
            game.setScreen(new WeaponMenu(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }
    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}


