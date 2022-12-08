package com.andromeda.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class ActJugador extends ActorBase {

    private ActBala bala;

    public ActJugador(Texture textura, Float Velocidad, float x, float y, float ancho, float alto) {
        super(textura, Velocidad, x, y, ancho, alto);
        Texture texturaBala;
        texturaBala = new Texture("bala.png");
        setX(getX() - ancho/2);
        bala = new ActBala(texturaBala, 500f, -100,-100, ancho * 0.3f, alto * 2, this);
    }

    public void moverDerecha(float delta){
        if (getX() + getWidth() < Gdx.graphics.getWidth())
            setX(getX() + delta * getVelocidad());
        else
            setX(Gdx.graphics.getWidth()-getWidth());
    }

    public void moverIzquierda(float delta){
        if (getX() > 0)
            setX(getX() - delta * getVelocidad());
        else
            setX(0);
    }

    public void setBala(ActBala bala){
        this.bala = bala;
    }

    public ActBala getBala(){
        return bala;
    }

    @Override
    public void act(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) moverIzquierda(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moverDerecha(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(getTextura(), getX(), getY(), getWidth(), getHeight());
    }
}
