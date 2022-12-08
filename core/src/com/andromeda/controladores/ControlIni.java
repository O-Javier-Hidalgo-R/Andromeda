package com.andromeda.controladores;

import com.andromeda.Videojuego;
import com.badlogic.gdx.InputAdapter;

public class ControlIni extends InputAdapter {

    private Videojuego videojuego;

    public ControlIni(Videojuego videojuego){
        this.videojuego = videojuego;
    }

    @Override
    public boolean keyDown(int keycode) {
        videojuego.setScreen(videojuego.pantallaJuego);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        videojuego.setScreen(videojuego.pantallaJuego);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
