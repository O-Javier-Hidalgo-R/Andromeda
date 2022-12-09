package com.andromeda.actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class ActAlien extends ActorBase {

    private boolean vivo;
    private Vector2 posicionInicial;

    public ActAlien(Sprite sprite, float x, float y, float ancho, float alto) {
        super(sprite, x, y, ancho, alto);
        vivo = true;
        posicionInicial = new Vector2(x, y);
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(isVivo()){
            super.draw(batch, parentAlpha);
        }
    }

    public Vector2 getPosicionInicial() {
        return posicionInicial;
    }

    public void setPosicionInicial(Vector2 posicionInicial) {
        this.posicionInicial = posicionInicial;
    }
}