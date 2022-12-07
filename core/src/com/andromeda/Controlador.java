package com.andromeda;

import com.andromeda.actores.ActJugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class Controlador extends InputAdapter {
    public boolean presionandoIzq;
    public boolean presionandoDer;
    /**
     * Evento que se dispara cuando pulsamos una tecla
     * @param keycode
     * @return
     */
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.A || keycode == Input.Keys.LEFT){
            presionandoIzq = true;
        }
        if(keycode == Input.Keys.D || keycode == Input.Keys.RIGHT){
            presionandoDer = true;
        }
        return false;
    }

    /**
     * Evento qe se dispara cuando dejamos de pulsar una tecla
     * @param keycode
     * @return
     */
    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.A || keycode == Input.Keys.LEFT){
            presionandoIzq = false;
        }
        if(keycode == Input.Keys.D || keycode == Input.Keys.RIGHT){
            presionandoDer = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
