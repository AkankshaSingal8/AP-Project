package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LostMenu implements Screen { // lost screen
    private final TankStar game;
    private Texture backgroundImg3, hill;
    private Texture tank1, tank2, health;
    private Texture nav1, fire, nav2, weaponb, pauseb;
    private Texture lmenu;
    Button restartButton, mainMenuButton;
    protected final Stage stage;
    protected Skin mySkin;
    private int row_height = Gdx.graphics.getWidth() / 12;
    private int col_width = Gdx.graphics.getWidth() / 12;


    public LostMenu(final TankStar game){
        this.game = game;
        backgroundImg3 = new Texture("bg.png");
        tank1 = new Texture("tank1.png");
        tank2 = new Texture("tank2.png");
        fire = new Texture("fire.png");
        weaponb = new Texture("weaponb.png");
        pauseb = new Texture("pauseb1.png");
        lmenu = new Texture("lmenu.png");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage); // makes buttons clickable
        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        restartButton = new TextButton("RESTART",mySkin,"small");
        restartButton.setSize(col_width*3,row_height);
        restartButton.setPosition(Gdx.graphics.getWidth()/2 - restartButton.getWidth()/2,Gdx.graphics.getHeight()/2 - restartButton.getHeight()/2 );
        restartButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Player1ChooseTank(game,new NewGame()));
                dispose();
            }
        });
        stage.addActor(restartButton);
        mainMenuButton = new TextButton("MAIN MENU",mySkin,"small");
        mainMenuButton.setSize(col_width*3,row_height);
        mainMenuButton.setPosition(Gdx.graphics.getWidth()/2 - mainMenuButton.getWidth()/2,Gdx.graphics.getHeight()/2 - mainMenuButton.getHeight()/2 -150);
        mainMenuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
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
        game.batch.draw(pauseb,1150, 650);

        // end of page3 stuff

        game.batch.setColor(1,1,1,1F);
        game.batch.draw(lmenu,Gdx.graphics.getWidth()/2 - lmenu.getWidth()/2,Gdx.graphics.getHeight()/2 - lmenu.getHeight()/2);

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

    }
}
