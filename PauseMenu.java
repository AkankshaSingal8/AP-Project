package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PauseMenu implements Screen{ // pause page
    private final TankStar game;
    private Texture backgroundImg3, hill;
    private Texture tank1, tank2, health;
    private Texture nav1, fire, nav2, weaponb;
    private Texture pauseOption, pauseb;
    private int healthTank1, healthTank2; // current health of tanks
    protected final Stage stage;
    protected Skin mySkin;
    private int row_height = Gdx.graphics.getWidth() / 12;
    private int col_width = Gdx.graphics.getWidth() / 12;
    Button health1Button, health2Button, saveButton, resumeButton, mainMenuButton;

    public PauseMenu(final TankStar game, final int healthTank1, final int healthTank2){
        this.game = game;
        backgroundImg3 = new Texture("bg.png");
        tank1 = new Texture("tank1.png");
        tank2 = new Texture("tank2.png");
        fire = new Texture("fire.png");
        weaponb = new Texture("weaponb.png");
        pauseOption = new Texture("poption.png");
        this.healthTank1 = healthTank1;
        this.healthTank2 = healthTank2;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage); // makes buttons clickable
        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        health1Button = new TextButton(healthTank1+""+"\n"+ "HealthOf1",mySkin,"small");
        health1Button.setSize(col_width*2,row_height);
        health1Button.setPosition(Gdx.graphics.getWidth()/2 - health1Button.getWidth()/2 - 500,Gdx.graphics.getHeight()/2 - health1Button.getHeight()/2 -250);
        stage.addActor(health1Button);
        health2Button = new TextButton(healthTank2+""+"\n"+ "HealthOf2",mySkin,"small");
        health2Button.setSize(col_width*2,row_height);
        health2Button.setPosition(Gdx.graphics.getWidth()/2 - health2Button.getWidth()/2 + 500,Gdx.graphics.getHeight()/2 - health2Button.getHeight()/2 -250);
        stage.addActor(health2Button);
        saveButton = new TextButton("SAVE",mySkin,"small");
        saveButton.setSize(col_width*2,row_height);
        saveButton.setPosition(Gdx.graphics.getWidth()/2 - saveButton.getWidth()/2 ,Gdx.graphics.getHeight()/2 - saveButton.getHeight()/2 + 170);
        stage.addActor(saveButton);
        resumeButton = new TextButton("RESUME",mySkin,"small");
        resumeButton.setSize(col_width*2,row_height);
        resumeButton.setPosition(Gdx.graphics.getWidth()/2 - resumeButton.getWidth()/2 ,Gdx.graphics.getHeight()/2 - resumeButton.getHeight()/2 +45);
        resumeButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new InGame(game,healthTank1,healthTank2));
                dispose();
            }
        });
        stage.addActor(resumeButton);
        mainMenuButton = new TextButton("MAIN MENU",mySkin,"small");
        mainMenuButton.setSize(col_width*2,row_height);
        mainMenuButton.setPosition(Gdx.graphics.getWidth()/2 - mainMenuButton.getWidth()/2 ,Gdx.graphics.getHeight()/2 - mainMenuButton.getHeight()/2 -80);
        mainMenuButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
                dispose();
            }
        });
        stage.addActor(mainMenuButton);
    }

    @Override
    public void show(){

    }

    @Override
    public void render(float delta){
        game.batch.begin();
        game.batch.setColor(0.5F,0.5F,0.5F,1F);
        // page3 stuff
//        game.batch.setColor(1,1,1,1F); // makes elements opaque(normal convention)
        game.batch.draw(backgroundImg3,0,0);
        game.batch.draw(tank1,200,260,200,200);
        game.batch.draw(tank2,1000,250,200,200);
        game.batch.draw(fire,600,-250);
        game.batch.draw(weaponb,300,-250);
//        game.batch.setColor(1,1,1,0.5F); // makes elements transparent
//        game.batch.setColor(1,1,1,1F); // can cause problem
        // end of page3 stuff

        game.batch.setColor(1,1,1,1F);
        game.batch.draw(pauseOption,Gdx.graphics.getWidth()/2 - pauseOption.getWidth()/2,250);

        game.batch.end();
        stage.act();
        stage.draw();

        if (Gdx.input.isKeyPressed(Input.Keys.R)){
            game.setScreen(new SavedGames(game));
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
        stage.dispose();
        mySkin.dispose();

    }

}
