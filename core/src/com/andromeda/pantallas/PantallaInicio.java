package com.andromeda.pantallas;

import com.andromeda.Videojuego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PantallaInicio extends PantallaBase{

    private Texture textura;
    private Stage escenario;

    public PantallaInicio(Videojuego juego) {
        super(juego);
        textura = new Texture("pantallaInicio.png");
    }

    @Override
    public void show() {
        escenario = new Stage();
        Image image = new Image(textura);
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        image.setPosition(0,0);
        escenario.addActor(image);
    }

    @Override
    public void hide() {
        escenario.dispose();
    }

    @Override
    public void dispose() {
        textura.dispose();
        escenario.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0/255f,0/255f,0/255f,255/255f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        escenario.draw();
    }


}
