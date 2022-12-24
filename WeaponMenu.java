package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class WeaponMenu implements Screen{ // weapons menu
    private final TankStar game;
    private Texture backgroundImg3, hill;
    private Texture tank1, tank2, health;
    private Texture nav1, fire, nav2, weaponb;
    private Texture weaponmenu, pauseb;

    public WeaponMenu(final TankStar game){
        this.game = game;
        backgroundImg3 = new Texture("s2.png");
        hill = new Texture("hill.png");
        tank1 = new Texture("tank1.png");
        tank2 = new Texture("tank2.png");
        health = new Texture("health.png");
        nav1 = new Texture("nav1.png");
        fire = new Texture("fire.png");
        nav2 = new Texture("nav2.png");
        weaponb = new Texture("weaponb.png");
        weaponmenu = new Texture("woption.png");
        pauseb = new Texture("pauseb1.png");
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
        game.batch.draw(hill,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch.draw(tank1,350,420,200,200);
        game.batch.draw(tank2,570,415,200,200);
        game.batch.draw(health,Gdx.graphics.getWidth()/2 - health.getWidth()/2,650);
        game.batch.draw(fire,600,-250);
        game.batch.draw(weaponb,300,-250);
        game.batch.draw(pauseb,1150, 650);

//        game.batch.setColor(1,1,1,0.5F); // makes elements transparent
        game.batch.draw(nav1,70,35,300,150);
        game.batch.draw(nav2,1000,0,400,200);

//        game.batch.setColor(1,1,1,1F); // can cause problem
        // end of page3 stuff

        game.batch.setColor(1,1,1,1F);
        game.batch.draw(weaponmenu,Gdx.graphics.getWidth()/2 - weaponmenu.getWidth()/2,250);

        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.Y)){
            game.setScreen(new LostMenu(game));
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
