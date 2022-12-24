package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bullets {
    public static final int BULLET_SPEED = 400;
    public static final int defaultY = 350; // need to change this as y is constant
    private static Texture bulletTexture ;
    float x,y;
    public boolean remove = false;
    private Collision rect;
    public Bullets(float x, int val){
        this.x = x;
        this.y = defaultY;
        if (bulletTexture == null){
            if (val == 1){
                bulletTexture = new Texture("bullet.png");
            }
            else if (val == 2){
                bulletTexture = new Texture("ultaBullet.png");
            }

        }
        this.rect = new Collision(x,y,bulletTexture.getWidth(),bulletTexture.getHeight());
    }

    public void update1(float delta){
        x += BULLET_SPEED * delta;
        if (x > Gdx.graphics.getWidth()){
            remove = true;
        }
        rect.move(x,y);
    }

    public void update2(float delta){
        x -= BULLET_SPEED * delta;
        if (x <0){
            remove = true;
        }
        rect.move(x,y);
    }

    public void render(SpriteBatch batch){
        batch.draw(bulletTexture,x,y);
    }

    public Collision getCollisionRect(){
        return rect;
    }
}
