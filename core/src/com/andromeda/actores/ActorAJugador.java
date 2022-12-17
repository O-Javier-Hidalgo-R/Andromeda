/**
 * 
 */
package com.andromeda.actores;

import com.andromeda.Utilidades.Const;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Actor que representa al jugador en el juego.
 * 
 * @author O. Javier Hidalgo R.
 *
 */
public class ActorAJugador extends ActorAnimado {
	
	/**
	 * Variable que permite sostener el movimiento.
	 */
	private boolean moviendo;
	
	/**
	 * Vidas restantes del jugador.
	 */
	private int vidas;
	
	/**
	 * Constructor parametrizado.
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 * @param velocidad
	 * @param frameDuration
	 * @param frames
	 */
	public ActorAJugador(float x, float y, float width, float heigth, float velocidad, float frameDuration,
			Array<AtlasRegion> frames) {
		
		super(x, y, width, heigth, velocidad, frameDuration, frames);
		// TODO Auto-generated constructor stub
		this.vidas = 3;
	}
	
	/**
	 * 
	 */
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		if(moviendo) {
			
			trasladarAdentro();
			
			moverHorizontal(delta);
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
	 * Traslada la nave dentro de los limites de la pantalla cuando sale fuera de estos.
	 */
	private void trasladarAdentro() {
		
		// TODO Auto-generated method stub
		if (getVelocidad() < 0 && getX() < 0) {
			
			setX(0);
			
		}else if(getVelocidad() > 0 && getX() + getWidth() > Const.WIDTH) {
			
			setX(Const.WIDTH - getWidth());
			
		}
	}

	/**
	 * Cambia la bandera de movimiento y cambia el sentido para que avance a la izquierda.
	 * @param b
	 */
	public void moverIzquierda(boolean b) {
		
		// TODO Auto-generated method stub
		moviendo = b;
		if(getVelocidad() > 0) setVelocidad(-1 * getVelocidad());
	}
	
	/**
	 * Cambia la bandera de movimiento y cambia el sentido para que avance a la Derecha.
	 * @param b
	 */
	public void moverDerecha(boolean b) {
		
		// TODO Auto-generated method stub
		moviendo = b;
		if(getVelocidad() < 0) setVelocidad(-1 * getVelocidad());
	}
	
	public void descontarVida() {
		vidas = getVidas() - 1;
	}
	
	public boolean muerto() {
		if (getVidas() == 0) return true;
		return false;
	}

	/**
	 * @return the vidas
	 */
	public int getVidas() {
		return vidas;
	}
}
