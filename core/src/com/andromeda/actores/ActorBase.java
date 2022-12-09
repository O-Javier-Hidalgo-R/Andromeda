package com.andromeda.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ActorBase extends Actor {

    protected Sprite sprite;

    public ActorBase(Sprite sprite, float x, float y, float ancho, float alto){
        setPosition(x, y);
        setSize(ancho, alto);
        sprite.setSize(ancho, alto);
        sprite.setPosition(x, y);
        this.sprite = new Sprite(sprite);
    }

    public Sprite getSprite(){
        return sprite;
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //super.draw(batch, parentAlpha);
        sprite.setPosition(getX(), getY());
        sprite.draw(batch);
    }
}
