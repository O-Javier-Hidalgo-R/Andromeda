package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActBala extends Actor {

    private float velocidad;
    private Actor disparador;
    private Texture textura = new Texture("bala.png");

    public ActBala(Actor disparador, float velocidad){
        setSize(Gdx.graphics.getWidth()/256, Gdx.graphics.getHeight()/16);
        this.disparador = disparador;
        this.velocidad = velocidad;
        setY(Gdx.graphics.getHeight()+100);
    }

    @Override
    public void act(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)&&!estaDisparando()){
            prepara();
        }else{
            mover(delta);
        }
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

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY(), getWidth(), getHeight());
    }

    private void mover(float delta){
        setY(getY() + delta * velocidad);
    }
}
