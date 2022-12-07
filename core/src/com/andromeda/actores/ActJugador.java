package com.andromeda.actores;

import com.andromeda.Controlador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ActJugador extends Actor {

    private Texture jugadorTexture;
    private float velocidad = 300;

    public ActJugador(Texture jugadorTexture){
        this.jugadorTexture = jugadorTexture;
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
    public void act(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) moverIzquierda(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moverDerecha(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(jugadorTexture, getX(), getY(), getWidth(), getHeight());
    }
}
