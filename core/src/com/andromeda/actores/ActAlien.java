package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActAlien extends Actor {

    private Texture texture;
    private float velocidad = 200;

    public ActAlien(Texture texture){
        this.texture = texture;
        setSize(Gdx.graphics.getWidth()/16, Gdx.graphics.getHeight()/16);
    }

    public void moverDerecha(float delta){
        if (getX() + getWidth() < Gdx.graphics.getWidth())
            setX(getX() + delta * velocidad);
        else
            setX(Gdx.graphics.getWidth()-getWidth());
    }

    public void moverIzquierda(float delta){
        if (getX() > 0)
            setX(getX() - delta * velocidad);
        else
            setX(0);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}
