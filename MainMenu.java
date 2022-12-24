package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class MainMenu implements Screen { // main menu
    private final TankStar game;
    private Texture backgroundImg1;
    private Texture headingb;
    protected final Stage stage;
    protected Skin mySkin;
    Button resumeButton, newGameButton, exitButton;
    private int row_height = Gdx.graphics.getWidth() / 12;
    private int col_width = Gdx.graphics.getWidth() / 12;


    public MainMenu(final TankStar game) {
        this.game = game;
        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        backgroundImg1 = new Texture("menu.png");
        headingb = new Texture("tankstars.png");
        // doing stage stuff
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        // making buttons
        resumeButton = new TextButton("RESUME",mySkin,"small");
        resumeButton.setSize(col_width*4,row_height);
        resumeButton.setPosition(Gdx.graphics.getWidth()/2 - resumeButton.getWidth()/2,Gdx.graphics.getHeight()/2 - resumeButton.getHeight()/2);
        resumeButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SavedGames(game));
                dispose();
            }
        });
        stage.addActor(resumeButton);
        newGameButton  = new TextButton("NEW GAME",mySkin,"small");
        newGameButton.setSize(col_width*4,row_height);
        newGameButton.setPosition(Gdx.graphics.getWidth()/2 - newGameButton.getWidth()/2,Gdx.graphics.getHeight()/2 - newGameButton.getHeight()/2 + 150);


        newGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                NewGame newGame = new NewGame();
                game.setScreen(new Player1ChooseTank(game,newGame));
                dispose();
            }
        });

        stage.addActor(newGameButton);

        exitButton = new TextButton("EXIT",mySkin,"small");
        exitButton.setSize(col_width*4,row_height);
        exitButton.setPosition(Gdx.graphics.getWidth()/2 - exitButton.getWidth()/2,Gdx.graphics.getHeight()/2 - exitButton.getHeight()/2 - 150);
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                dispose();
            }
        });
        stage.addActor(exitButton);

    }

    @Override
    public void show(){

    }

    @Override
    public void render(float delta){
        game.batch.begin();
        game.batch.draw(backgroundImg1, 0, 0);
        game.batch.draw(headingb, Gdx.graphics.getWidth()/2  -headingb.getWidth()/2,600);
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
        backgroundImg1.dispose();
    }

    public static int add(int a, int b){
        return a+b;
    }
}

