package com.andromeda.actores;

import com.andromeda.Utilidades.Const;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;


/**
 * Actor que representara las balas dentro del juego.
 * @author O. Javier Hidalgo R.
 *
 */
public class ActorBala extends ActorAnimado {
	
	/**
	 * Sonido que se reproducira cuando se este disparando.
	 */
	private Sound sonidoDisparo;
	
	/**
	 * Constructor parametrizado.
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 * @param velocidad
	 * @param sonidoDisparo
	 * @param frameDuration
	 * @param frames
	 */
	public ActorBala(float x, float y, float width, float heigth, float velocidad, Sound sonidoDisparo,float frameDuration,
			Array<AtlasRegion> frames) {
		
		super(x, y, width, heigth, velocidad, frameDuration, frames);
		this.sonidoDisparo = sonidoDisparo;
	}

	/**
	 * 
	 */
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		if(enPantalla()) {
			moverVerticalmente(delta);
		}
	}

	/**
	 * 
	 */
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	}
	
	/**
	 * Coloca la bala en el lanzador asociado para su disparo.
	 * @param Lanzador
	 */
	public void colocar(Actor Lanzador) {
		
		if(!enPantalla()) {
			setHeight(Lanzador.getHeight());
			setX(Lanzador.getX() + (Lanzador.getWidth() - getWidth())/2);
			setY(Lanzador.getY());
			sonidoDisparo.play();
		}
	}
	
	public void colocar(float x, float y) {
	
		if(!enPantalla()) {
			setX(x);
			setY(y);
			sonidoDisparo.play();
		}
	}

	/**
	 * Lleva fuera del escenario la bala.
	 */
	public void desaparecer() {
		// TODO Auto-generated method stub
		setY(Const.HEIGHT+1);
	}
}
