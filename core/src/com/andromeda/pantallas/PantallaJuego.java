package com.andromeda.pantallas;

import com.andromeda.Videojuego;
import com.andromeda.actores.ActAlien;
import com.andromeda.actores.ActBala;
import com.andromeda.actores.ActJugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaJuego extends PantallaBase{

    static TextureAtlas atlas = new TextureAtlas("spritesJuego.atlas");

    private ActJugador jugador;
    private ActAlien aliens[];
    private Stage escenario;

    public int filaAliens = 5;
    public int columnasAliens = 10;
    public int espacioAliens = 50;
    Vector2 desplazamientoAliens = Vector2.Zero;
    int sentidoAliens = 1;
    float speedAlien = 100;
    private int minX_aliens;
    private int minY_aliens;
    private int MaxX_aliens;
    private int MaxY_aliens;
    private int amountAliveAliens= 1;

    public PantallaJuego(Videojuego videojuego) {
        super(videojuego);
        ActBala bala = new ActBala(atlas.createSprite("balajugador"), -100, -100, 4f, 32f, 1000);
        jugador = new ActJugador(atlas.createSprite("jugador"),0f, 0f, 32f, 32f, 450f, bala);
        escenario = new Stage();
        escenario.setDebugAll(true);

        aliens = new ActAlien[filaAliens * columnasAliens];
        int i = 0;

        //creo a los aliens en un vector
        for (int y = 0; y < filaAliens; y++){
            for (int x = 0; x < columnasAliens; x++){
                Vector2 position = new Vector2(x* espacioAliens, y* espacioAliens);
                position.x += Gdx.graphics.getWidth()/2;
                position.y += Gdx.graphics.getHeight();
                position.x -= (columnasAliens /2) * espacioAliens;
                position.y -= (filaAliens) * espacioAliens;
                aliens[i] = new ActAlien(atlas.createSprite("alienA1"), position.x, position.y, 32,32);
                escenario.addActor(aliens[i]);
                i++;
            }
        }
    }

    @Override
    public void show() {
        escenario.addActor(jugador);
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

        //COMPROBAMOS LOS IMPACTOS DE BALA PLAYER - ALIENS
        for (int i = 0; i<aliens.length; i++){
            if (aliens[i].isVivo()){
                Rectangle rectangle1 = new Rectangle(jugador.getBala().getSprite().getBoundingRectangle());
                Rectangle rectangle2 = new Rectangle(aliens[i].getSprite().getBoundingRectangle());
                if (rectangle1.overlaps(rectangle2)){
                    jugador.getBala().setY(-100);
                    aliens[i].setVivo(false);
                    break;
                }
            }
        }

        //COMPROBAMOS LA FORMACION
        minX_aliens = 10000;
        minY_aliens = 10000;
        MaxX_aliens = 0;
        MaxY_aliens = 0;
        amountAliveAliens = 0;

        for (int i = 0; i < aliens.length; i++){
            if (aliens[i].isVivo()){
                int indexX = i % columnasAliens;
                int indexY = i / columnasAliens;
                if(indexX > MaxX_aliens) MaxX_aliens = indexX;
                if(indexX < minX_aliens) minX_aliens = indexX;
                if(indexY > MaxY_aliens) MaxY_aliens = indexY;
                if(indexY < minY_aliens) minY_aliens = indexY;
                amountAliveAliens++;
            }
        }

        if (amountAliveAliens == 0){
            System.out.println("USTED GANA");
        }

        desplazamientoAliens.x += sentidoAliens *delta*speedAlien;
        //MOVIMIENTO A LOS LATERALES
        for (int i = 0; i < aliens.length; i++){
            Vector2 vector2 = new Vector2(aliens[i].getPosicionInicial().x + desplazamientoAliens.x, aliens[i].getPosicionInicial().y + desplazamientoAliens.y);
            aliens[i].setPosition(vector2.x, vector2.y);
            if (aliens[i].isVivo()){
                if (aliens[i].getSprite().getBoundingRectangle().overlaps(jugador.getSprite().getBoundingRectangle())){
                    Gdx.app.exit();
                }
            }
        }

        //MOVIMIENTO HACIA ABAJO
        if (aliens[MaxX_aliens].getX() >= Gdx.graphics.getWidth()){
            sentidoAliens = -1;
            //BAJA CUANDO LLEGA AL LIMITE
            desplazamientoAliens.y -= aliens[0].getHeight()*aliens[0].getScaleY()*0.25f;
            //ACELERAN CADA QUE BAJAN
            speedAlien+=5;
        }
        if (aliens[minX_aliens].getX() <= 0){
            sentidoAliens = 1;
            //BAJA CUANDO LLEGA AL LIMITE
            desplazamientoAliens.y -= aliens[0].getHeight()*aliens[0].getSprite().getScaleY()*0.25f;
            //ACELERAN CADA QUE BAJAN
            speedAlien+=5;
        }

        //COMPRUEBA SI UN ALIEN LLEGO ABAJO
        if (aliens[minY_aliens].getY() <= 0){
            Gdx.app.exit();
        }

        escenario.draw();
    }

    @Override
    public void dispose() {
        jugador.clear();
        escenario.dispose();
    }

}
