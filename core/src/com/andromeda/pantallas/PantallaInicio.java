package com.andromeda.pantallas;

import com.andromeda.controladores.ControlIni;
import com.andromeda.Videojuego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PantallaInicio extends PantallaBase{

    private Texture textura;
    private Stage escenario;
    private ControlIni controlIni;
    /*
    private Skin skin;
    private TextButton botonInicio;
     */

    public PantallaInicio(final Videojuego videojuego) {
        super(videojuego);

        textura = new Texture("pantallaInicio.png");
        escenario = new Stage();
        Image image = new Image(textura);
        controlIni = new ControlIni(videojuego);
        /*
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        botonInicio = new TextButton("Iniciar", skin);
        botonInicio.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                videojuego.setScreen(videojuego.pantallaJuego);
            }
        });
         */

        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        image.setPosition(0,0);
        escenario.addActor(image);

        /*
        botonInicio.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getWidth()/16);
        botonInicio.setPosition(Gdx.graphics.getWidth()/2 - botonInicio.getWidth()/2, 0);
        escenario.addActor(botonInicio);
         */
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controlIni);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
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

        escenario.act();
        escenario.draw();
    }
}
