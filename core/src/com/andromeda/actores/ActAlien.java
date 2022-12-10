package com.andromeda.actores;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class ActAlien extends ActorBase {

    //private final float DES_SPEED = 300; //Se usa si se quiere una caida mas constante

    private byte movimiento;
    private short margenIzquierdo;
    private short margenDerecho;
    private short velocidad;

    public ActAlien(Sprite sprite, float x, float y, float ancho, float alto, float margenIzquierdo, float margenDerecho, short velocidad) {
        super(sprite, x, y, ancho, alto, velocidad);
        movimiento = 1;
        this.margenIzquierdo = (short) margenIzquierdo;
        this.margenDerecho = (short) margenDerecho;
        this.velocidad = (short) velocidad;
    }

    @Override
    public void act(float delta) {
        moverEnX(delta);
        if(tocoUnLimite()){
            cambiarSentido();
            moverEnY(delta);
            acelerar();
        }
    }

    private void acelerar() {
        velocidad += 10;
    }

    private void moverEnY(float delta) {
        setY(getY() - velocidad * delta);
    }

    private void cambiarSentido() {
        movimiento *= -1;
    }

    private boolean tocoUnLimite() {
        return getX() + getWidth() > margenDerecho || getX() < margenIzquierdo;
    }

    private void moverEnX(float delta) {
        setX(getX() + movimiento * velocidad * delta);
    }

}