package com.andromeda.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ActorBase extends Actor {

    protected Texture textura;
    protected Float Velocidad;

    public ActorBase(Texture textura, Float Velocidad, float x, float y, float ancho, float alto){
        this.textura = textura;
        this.Velocidad = Velocidad;
        setSize(ancho, alto);
        setPosition(x, y);
    }


    public void setTextura(Texture textura) {
        this.textura = textura;
    }

    public Texture getTextura() {
        return textura;
    }

    public Float getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(Float velocidad) {
        Velocidad = velocidad;
    }

}
