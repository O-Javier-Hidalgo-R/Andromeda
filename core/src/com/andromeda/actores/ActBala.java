package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActBala extends ActorBase {

    private Actor disparador;
    private boolean impacto;

    public ActBala(Texture textura, Float Velocidad,float x, float y, float ancho, float alto, Actor disparador) {
        super(textura, Velocidad, x, y, ancho, alto);
        this.disparador = disparador;
        this.impacto = false;
    }

    private void prepara() {
        setX(disparador.getX() + disparador.getWidth()/2 - getWidth()/2);
        setY(disparador.getY() + disparador.getHeight()/2 - getHeight()/2);
    }

    private boolean estaDisparando() {
        if(getY() < Gdx.graphics.getHeight() && getY() > 0){
            return true;
        }
        return false;
    }

    private void mover(float delta){
        setY(getY() + delta * getVelocidad());
    }

    @Override
    public void act(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !estaDisparando())
            prepara();
        mover(delta);
        if(estaDisparando()) mover(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY(), getWidth(), getHeight());
    }
}
