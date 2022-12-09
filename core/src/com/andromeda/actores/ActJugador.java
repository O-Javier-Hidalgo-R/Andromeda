package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ActJugador extends ActorBase {

    private float velocidad;
    private ActBala bala;

    public ActJugador(Sprite sprite, float x, float y, float ancho, float alto, float velocidad, ActBala bala) {
        super(sprite, x, y, ancho, alto);
        this.velocidad = velocidad;
        this.bala = bala;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getVelocidad(){
        return this.velocidad;
    }

    @Override
    public void act(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.A)||Gdx.input.isKeyPressed(Input.Keys.LEFT)) moverIzquierda(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moverDerecha(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && !bala.enPantalla()) bala.setPosition(getX() + getWidth()/2 - bala.getWidth()/2, getY());
        bala.mover(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        bala.draw(batch, parentAlpha);
    }

    private boolean pasoLimiteIzquierdo() {
        return getX() <= 5;
    }

    public void moverIzquierda(float delta) {
        if (!pasoLimiteIzquierdo())
            setX(getX() - delta * velocidad);
    }

    private boolean pasoLimiteDerecho() {
        return getX() + getWidth() > Gdx.graphics.getWidth() -5;
    }

    public void moverDerecha(float delta) {
        if (!pasoLimiteDerecho())
            setX(getX() + delta * velocidad);
    }

    public ActBala getBala() {
        return bala;
    }

    public void setBala(ActBala bala) {
        this.bala = bala;
    }
}
