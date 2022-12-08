package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActAlien extends ActorBase {

    private ActBala bala;

    public ActAlien(Texture textura, Float Velocidad, float x, float y, float ancho, float alto) {
        super(textura, Velocidad, x, y, ancho, alto);
        Texture texturaBala;
        texturaBala = new Texture("bala.png");
        setX(getX() - ancho/2);
        setY(getY() - alto);
        bala = new ActBala(texturaBala, 500f, -100,-100, ancho * 0.3f, alto * 2, this);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(getTextura(), getX(), getY(), getWidth(), getHeight());
    }
}
