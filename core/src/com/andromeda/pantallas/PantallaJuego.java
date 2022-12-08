package com.andromeda.pantallas;

import com.andromeda.Videojuego;
import com.andromeda.actores.ActAlien;
import com.andromeda.actores.ActJugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Arrays;

public class PantallaJuego extends PantallaBase{

    private ActJugador jugador;
    private ActAlien aliens[];
    private Stage stage;
    
    int columnasAlines = 11;
    int numHeightAliens = 5;
    int spacingAliens = 40;

    final float ANCHO = Gdx.graphics.getWidth();
    final float LARGO = Gdx.graphics.getHeight();

    public PantallaJuego(final Videojuego juego) {
        super(juego);
        stage = new Stage();
        jugador = new ActJugador(new Texture("jugador.png"), 300f, ANCHO/2,
                0, ANCHO * 0.05f, LARGO * 0.05f);
        aliens = new ActAlien[columnasAlines * numHeightAliens];
    }

    @Override
    public void show() {
        stage.setDebugAll(true);
        stage.addActor(jugador);
        stage.addActor(jugador.getBala());
        int i = 0;
        for (int y = 0; y < numHeightAliens; y++){
            for (int x = 0; x < columnasAlines; x++){
                Vector2 position = new Vector2(x*spacingAliens, y*spacingAliens);
                position.x += Gdx.graphics.getWidth()/2;
                position.y += Gdx.graphics.getHeight();
                position.x -= (columnasAlines /2) * spacingAliens;
                position.y -= (numHeightAliens) * spacingAliens;
                aliens[i] = new ActAlien(new Texture("alien.png"),100f, position.x, position.y, ANCHO * 0.05f, LARGO * 0.05f);
                stage.addActor(aliens[i]);
                i++;
            }
        }
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
        jugador.clear();
        Arrays.fill(aliens, null);
    }
}
