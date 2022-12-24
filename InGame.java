package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class InGame implements Screen { // game page
    private final TankStar game;
    private Texture backgroundImg3, hill;
    private Texture tank1, tank2, health;
    private Texture nav1, fire, nav2, weaponb, pauseb;
    World world;
    private Body tank1body, tank2body, hillbody;
    private int tank1x, tank1y, tank2x, tank2y, healthTank1 , healthTank2 ; // current health of tanks
    private Button health1Button, health2Button, pauseButton;
    private Tank tank1obj, tank2obj;
    protected final Stage stage;
    protected Skin mySkin;
    private int row_height = Gdx.graphics.getWidth() / 12;
    private int col_width = Gdx.graphics.getWidth() / 12;
    private ArrayList<Bullets> bullets1 = new ArrayList<Bullets>();
    private ArrayList<Bullets> bulletsToRemove1 = new ArrayList<Bullets>();
    private ArrayList<Bullets> bullets2 = new ArrayList<Bullets>();
    private ArrayList<Bullets> bulletsToRemove2 = new ArrayList<Bullets>();

    public InGame(final TankStar game, final int healthTank1,final int healthTank2) {
        this.game = game;
        backgroundImg3 = new Texture("bg.png");
        this.healthTank1 = healthTank1;this.healthTank2 = healthTank2;
        tank1 = new Texture("tank1.png");
        tank2 = new Texture("tank2.png");
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
        pauseButton = new TextButton("PAUSE",mySkin,"small");
        pauseButton.setSize(col_width*2,row_height);
        pauseButton.setPosition(Gdx.graphics.getWidth()/2 - pauseButton.getWidth()/2 + 550,Gdx.graphics.getHeight()/2 - pauseButton.getHeight()/2 +320);
        pauseButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PauseMenu(game,healthTank1,healthTank2));
                dispose();
            }
        });
        stage.addActor(pauseButton);
        fire = new Texture("fire.png");
        weaponb = new Texture("weaponb.png");
//        pauseb = new Texture("pauseb1.png");
        tank1x = 200;
        tank1y = 260;
        tank2x = 1000;
        tank2y = 250;
    }

    public int getTank1x() {
        return tank1x;
    }

    public int getTank1y() {
        return tank1y;
    }

    public int getTank2x() {
        return tank2x;
    }

    public int getTank2y() {
        return tank2y;
    }

    public int getHealthTank1() {
        return healthTank1;
    }

    public int getHealthTank2() {
        return healthTank2;
    }


    @Override
    public void show(){

    }


    @Override
    public void render(float delta){
        game.batch.begin();
        game.batch.setColor(1,1,1,1F); // makes elements opaque(normal convention)
        game.batch.draw(backgroundImg3,0,0);
//        game.batch.draw(hill,0,0, 1400,Gdx.graphics.getHeight()/2);
        game.batch.draw(tank1,tank1x,tank1y,200,200);
        ///////////////////
//        Vector3 touchPos = tank1body.getPosition().sub();
        ///////////////////
        game.batch.draw(tank2,tank2x,tank2y,200,200);
        game.batch.draw(fire,600,-250);
        game.batch.draw(weaponb,300,-250);


        game.batch.setColor(1,1,1,0.5F); // makes elements transparent

        game.batch.setColor(1,1,1,1F);

        // tank 1
        // moving bullets
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            bullets1.add(new Bullets(tank1x+100,1));
        }

        // update bullets --> removes bullets if they go out of screen
        for (Bullets bullet : bullets1) {
            bullet.update1(delta);
            if (bullet.remove) {
                bulletsToRemove1.add(bullet);
            }
        }
        bullets1.removeAll(bulletsToRemove1);

        // tank 2
        // moving bullets
        if(Gdx.input.isKeyPressed(Input.Keys.B)){
            bullets2.add(new Bullets(tank2x+100,2));
        }

        // update bullets --> removes bullets if they go out of screen
        for (Bullets bullet : bullets2) {
            bullet.update2(delta);
            if (bullet.remove) {
                bulletsToRemove2.add(bullet);
            }
        }
        bullets2.removeAll(bulletsToRemove2);

        // tank1
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tank1x -= 1;
            game.batch.draw(tank1,tank1x,tank1y,200,200);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tank1x += 1;
            game.batch.draw(tank1,tank1x,tank1y,200,200);
        }
        // tank2
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tank2x -= 1;
            game.batch.draw(tank2,tank2x,tank2y,200,200);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tank2x += 1;
            game.batch.draw(tank2,tank2x,tank2y,200,200);
        }


        if (healthTank1 == 0 || healthTank2 == 0){
            game.setScreen(new LostMenu(game));
            dispose();
        }

        // draw bullets
        for (Bullets bullet : bullets1) {
            bullet.render(game.batch);
        }

        for (Bullets bullet : bullets2) {
            bullet.render(game.batch);
        }

        game.batch.end();
        stage.act();
        stage.draw();
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

    }
}
