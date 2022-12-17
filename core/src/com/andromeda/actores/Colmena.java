/**
 * 
 */
package com.andromeda.actores;

import com.andromeda.Utilidades.Const;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Clase que genera el conjunto de aliens en el videojuego.
 * @author O. Javier Hidalgo R.
 *
 */
public class Colmena extends Group{

	/**
	 * Velocidad que tendra el conjunto de aliens (colmena).
	 */
	private float velocidad;

	/**
	 * Limite izquierdo hasta el que puede llegar la colmena.
	 */
	private float limiteIzquierdo;

	/**
	 * Limite derecho hasta el que puede llegar la colmena.
	 */
	
	private float LimiteDerecho;
	
	/**
	 * variable que permite saber hasta donde llegan los aliens por abajo.
	 */
	private float limiteInferior;
	
	/**
	 * parametro que establece en que valor va a caer la colmena cada que llegue a un limite lateral.
	 */
	private float valorCaida;
	
	/**
	 * Constructor parametrizado.
	 * @param x0
	 * @param y0
	 * @param filas
	 * @param columnas
	 * @param espacio
	 * @param velocidad
	 * @param atlas
	 */
	public Colmena(int x0, int y0, int filas, int columnas, int espacio, float velocidad, float valorCaida,TextureAtlas atlas) {
		
		// TODO Auto-generated constructor stub
		this.setVelocidad(velocidad);
		this.setValorCaida(valorCaida);
		
		int x = 0;
		int y = 0;
		
		setTouchable(Touchable.childrenOnly);
		setSize(espacio*(columnas * 2 - 1), espacio*(filas * 2 - 1));
		
		for (int i = 0; i < filas; i++) {
			
			x=0;
			
			for (int j = 0; j < columnas; j++) {
				
				addActor(new ActorAlien(x, y, espacio, espacio, 0, 0.5F, atlas.findRegions("alien" + Const.TIPO_ALIEN[i])));
				x += espacio*2;
			}
			
			y += espacio * 2;
		}
		
		setPosition(x0, y0);
	}
	
	/**
	 * 
	 */
	@Override
	public void act(float delta) {
		
		// TODO Auto-generated method stub
		super.act(delta);
		
		if (llegoLimite()) {
			
			setVelocidad(-1 * getVelocidad());
			setY(getY() - getValorCaida());
		}
		
		setX(getX() + getVelocidad() * delta);
	}

	/**
	 * Valida si la colmena choco un limite.
	 * @return
	 */
	private boolean llegoLimite() {
		// TODO Auto-generated method stub
		if(getX() < 0 - getLimiteIzquierdo() || getX() + getLimiteDerecho() > Const.WIDTH) return true;
		return false;
	}

	/**
	 * @return the velocidad
	 */
	public float getVelocidad() {
		return velocidad;
	}

	/**
	 * @param velocidad the velocidad to set
	 */
	private void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * @return the limiteIzquierdo
	 */
	public float getLimiteIzquierdo() {
		return limiteIzquierdo;
	}

	/**
	 * @param limiteIzquierdo the limiteIzquierdo to set
	 */
	public void setLimiteIzquierdo(float limiteIzquierdo) {
		this.limiteIzquierdo = limiteIzquierdo;
	}

	/**
	 * @return the limiteDerecho
	 */
	public float getLimiteDerecho() {
		return LimiteDerecho;
	}

	/**
	 * @param limiteDerecho the limiteDerecho to set
	 */
	public void setLimiteDerecho(float limiteDerecho) {
		LimiteDerecho = limiteDerecho;
	}

	/**
	 * @return the limiteInferior
	 */
	public float getLimiteInferior() {
		return limiteInferior;
	}

	/**
	 * @param limiteInferior the limiteInferior to set
	 */
	public void setLimiteInferior(float limiteInferior) {
		this.limiteInferior = limiteInferior;
	}

	/**
	 * @return the valorCaida
	 */
	public float getValorCaida() {
		return valorCaida;
	}

	/**
	 * @param valorCaida the valorCaida to set
	 */
	public void setValorCaida(float valorCaida) {
		this.valorCaida = valorCaida;
	}
	
	
}
