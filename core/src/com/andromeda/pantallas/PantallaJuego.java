package com.andromeda.pantallas;

import com.andromeda.Videojuego;
import com.andromeda.actores.ActAlien;
import com.andromeda.actores.ActBala;
import com.andromeda.actores.ActJugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaJuego extends PantallaBase{

    private static final TextureAtlas atlas = new TextureAtlas("spritesJuego.atlas");
    private static final float TAMAÑO_DEFAULT = 32;
    private static final float MAXIMO_ALIENS_FILA = 8;
    private static final float DISTANCIA = 100; // Distancia en el eje x donde se van colocando los aliens.
    private static final float ALTURA = Gdx.graphics.getHeight() - 50; // Distancia en el eje y donde empiezan los aliens.
    private static final float MARGEN_IZQUIERDO = 0; // Limite de los aliens a la izquierda.
    private static final float MARGEN_DERECHO = Gdx.graphics.getWidth()+40; // Limite de los aliens a la derecha.
    private static final short VELOCIDAD_DEFAULT = 400;

    private ActJugador jugador;
    private ActBala balaJugador;
    private Stage escenario;
    private Group groupAliens;

    public PantallaJuego(Videojuego videojuego) {
        super(videojuego);
    }

    @Override
    public void show() {
        jugador = new ActJugador(atlas.createSprite("jugador"),  Gdx.graphics.getWidth()/2 - 16,0,TAMAÑO_DEFAULT,TAMAÑO_DEFAULT, VELOCIDAD_DEFAULT);
        balaJugador = new ActBala(atlas.createSprite("balajugador"), 0, Gdx.graphics.getHeight(), TAMAÑO_DEFAULT/4, TAMAÑO_DEFAULT, (short) (VELOCIDAD_DEFAULT*2));
        groupAliens = new Group();
        escenario = new Stage();
        crearAliens();
        escenario.addActor(groupAliens);
        escenario.addActor(jugador);
        escenario.addActor(balaJugador);
    }

    private void crearAliens() {
        float altura = ALTURA;

        posicionarAliens(escenario, atlas.createSprite("alienA1"), altura);
        altura = recalcularAltura(altura);

        posicionarAliens(escenario, atlas.createSprite("alienB1"), altura);
        altura = recalcularAltura(altura);

        posicionarAliens(escenario, atlas.createSprite("alienC1"), altura);
        altura = recalcularAltura(altura);

        posicionarAliens(escenario, atlas.createSprite("alienD1"), altura);

    }

    private float recalcularAltura(float altura) {
        return altura - TAMAÑO_DEFAULT -5;
    }

    private void posicionarAliens(Stage stage, Sprite sprite, float altura) {
        float distancia = DISTANCIA;
        float limiteDerecha = MARGEN_DERECHO - ((TAMAÑO_DEFAULT + 5) * MAXIMO_ALIENS_FILA);
        float limiteIzquierda = MARGEN_IZQUIERDO;
        for(int i = 0; i < MAXIMO_ALIENS_FILA ; i++) {
            groupAliens.addActor(new ActAlien(sprite, distancia, altura, TAMAÑO_DEFAULT, TAMAÑO_DEFAULT,limiteIzquierda, limiteDerecha, (short) (VELOCIDAD_DEFAULT/2)));
            distancia = distancia + TAMAÑO_DEFAULT + 5;
            limiteDerecha = limiteDerecha + TAMAÑO_DEFAULT + 5;
            limiteIzquierda = limiteIzquierda + TAMAÑO_DEFAULT + 5;
        }
    }

    @Override
    public void hide() {
        escenario.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0/255f,0/255f,0/255f,255/255f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        escenario.act();

        //TRASLADAR AL CONTROLADOR
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) dispararPlayer();

        comprobarImpactosBalas();

        comprobarFinJuego();
        comprobarFinJuego1();

        compobarGanador();

        escenario.draw();
    }

    private void comprobarFinJuego1() {
        boolean touchable = false;
        Actor impactado = groupAliens.hit(jugador.getX(), jugador.getY() + jugador.getHeight(), touchable);
        if(impactado != null){
            jugador.remove();
        }
    }

    private void compobarGanador() {
        if(groupAliens.getChildren().isEmpty()){
            //COLOCAR PANTALLA DE GANADOR
            System.out.println("USTED GANA");
        }
    }

    private void comprobarFinJuego() {
        for (Actor alien: groupAliens.getChildren()) {
            if(alien.getY() < 0){
                //COLOCAR PANTALLA DE PERDEDOR (OPCION DE VOLVER A INTENTAR)
                System.out.println("GAME OVER");
            }
        }
    }

    public void dispararPlayer() {
        if (!balaJugador.enPantalla()){
            balaJugador.setY(jugador.getY());
            balaJugador.setX(jugador.getX() + (jugador.getWidth()/2 - balaJugador.getWidth()/2));
        }
    }

    private void comprobarImpactosBalas(){
        boolean touchable = false;
        Actor alienImpactado = groupAliens.hit(balaJugador.getX(), balaJugador.getY(), touchable);
        if(alienImpactado != null){
            alienImpactado.remove();
            balaJugador.desaparecer();
        }
    }

    @Override
    public void dispose() {
        jugador.clear();
        escenario.dispose();
        groupAliens.clear();
        balaJugador.clear();
    }

}
