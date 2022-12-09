package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ActBala extends ActorBase {

    private float velocidad;

    public ActBala(Sprite sprite, float x, float y, float ancho, float alto, float velocidad) {
        super(sprite, x, y, ancho, alto);
        this.velocidad = velocidad;
    }

    public void mover(float delta){
        if(enPantalla()){
            setY(getY() + delta * velocidad);
        }
    }

    public boolean enPantalla() {
        return getY() >= 0 && getY() <= Gdx.graphics.getHeight();
    }

}
