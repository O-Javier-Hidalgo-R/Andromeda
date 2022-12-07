package com.andromeda.pantallas;

import com.andromeda.Controlador;
import com.andromeda.Videojuego;
import com.andromeda.actores.ActAlien;
import com.andromeda.actores.ActBala;
import com.andromeda.actores.ActJugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaJuego extends PantallaBase{

    private ActJugador jugador;
    private ActBala balaJugador;
    private ActAlien alien;
    private Texture jugadorTexture;
    private Texture alienTexture;
    private Stage stage;

    public PantallaJuego(Videojuego juego) {
        super(juego);
        jugadorTexture = new Texture("jugador.png");
        alienTexture = new Texture("alien.png");
        jugador = new ActJugador(jugadorTexture);
        alien = new ActAlien(alienTexture);
        balaJugador = new ActBala(jugador, 1000);
        stage = new Stage();
    }

    @Override
    public void show() {
        stage.setDebugAll(true);
        stage.addActor(jugador);
        stage.addActor(alien);
        stage.addActor(balaJugador);
        jugador.setPosition(Gdx.graphics.getWidth()/2 - jugador.getWidth()/2, 0);
        alien.setPosition(Gdx.graphics.getWidth()/2 - jugador.getWidth()/2, Gdx.graphics.getHeight() - alien.getHeight());
    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0/255f,0/255f,128/255f,255/255f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        jugadorTexture.dispose();
        jugador.clear();
        balaJugador.clear();
    }
}
