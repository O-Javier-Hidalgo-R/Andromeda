package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ActBala extends ActorBase {

    private static final short limiteSuperior = (short) Gdx.graphics.getHeight();

    public ActBala(Sprite sprite, float x, float y, float ancho, float alto, short velocidad) {
        super(sprite, x, y, ancho, alto, velocidad);
    }

    @Override
    public void act(float delta) {
        mover(delta);
    }

    public void desaparecer(){
        setY(limiteSuperior + 1);
    }

    public void mover(float delta){
        if(enPantalla()){
            setY(getY() + delta * getVelocidad());
        }
    }

    public boolean enPantalla() {
        return getY() + getWidth() > 0 && getY() < limiteSuperior;
    }

    public boolean impacto(ActorBase victima){
        return this.sprite.getBoundingRectangle().overlaps(victima.sprite.getBoundingRectangle());
    }
}
