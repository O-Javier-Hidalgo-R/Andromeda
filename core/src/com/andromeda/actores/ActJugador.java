package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ActJugador extends ActorBase {

    private static final short LIMITE_DERECHO = (short) Gdx.graphics.getWidth();
    private static final byte MARGEN_ERROR = 5;
    private int vidas = 1;
    //EFECTO DE SONIDO DISPARO EXPLOSION

    public ActJugador(Sprite sprite, float x, float y, float ancho, float alto, short velocidad) {
        super(sprite, x, y, ancho, alto, velocidad);
    }

    @Override
    public void act(float delta) {
        //TRASLADAR A UN CONTROLADOR
        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) moverIzquierda(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moverDerecha(delta);
    }

    private boolean dentroLimiteIzquierdo() {
        return getX() > MARGEN_ERROR;
    }

    private boolean dentroLimiteDerecho() {
        return getX() + getWidth() < LIMITE_DERECHO - MARGEN_ERROR;
    }

    public void moverIzquierda(float delta) {
        if (dentroLimiteIzquierdo())
            setX(getX() - delta * velocidad);
    }

    public void moverDerecha(float delta) {
        if (dentroLimiteDerecho())
            setX(getX() + delta * velocidad);
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public boolean isDead(){
        return vidas == 0;
    }
}
