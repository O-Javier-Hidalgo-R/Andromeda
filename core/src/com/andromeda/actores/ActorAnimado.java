/**
 * 
 */
package com.andromeda.actores;

import com.andromeda.Utilidades.Const;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

/**
 * Clase abastracta que vincula el tipo de dato actor con una animacion loop y lo muetra al estar dentro de un stage.
 * @author O. Javier Hidalgo R.
 *
 */
public abstract class ActorAnimado extends Actor {
	
	/**
	 * Arreglo de imagenes empaquetadas en un .atlas 
	 */
	private Animation<TextureRegion> animation;
	
	/**
	 * Parametro que relaciona un timer (delta) con la clase para mostrar la animacion.
	 */
	private float stateTime;
	
	/**
	 *	Velocidad de movimiento vertical y horizontal que tambien contiene el sentido (signo del flotante).
	 */
	private float velocidad;
	
	private Rectangle rectangle;
	
	/**
	 * Constructor parametrizado de la clase.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 * @param frameDuration
	 * @param frames
	 */
	public ActorAnimado(float x, float y, float width, float heigth, float velocidad, float frameDuration, Array<AtlasRegion> frames) {
		
		setPosition(x, y);
		setSize(width, heigth);
		setAnimation(new Animation<TextureRegion>(frameDuration, frames, PlayMode.LOOP));
		this.velocidad = velocidad;
		this.rectangle = new Rectangle(x, y, width, heigth);
	}
	
	/**
	 * @return el stateTime.
	 */
	private float getStateTime() { 
		
		return stateTime; 
	}

	/**
	 * cambia el valor de stateTime por parametro.
	 * @param stateTime
	 */
	private void setStateTime(float stateTime) { 
		
		this.stateTime = stateTime; 
	}
	
	/**
	 * 
	 * @return
	 */
	public Animation<TextureRegion> getAnimation() { 
		
		return animation; 
	}

	/**
	 * Cambia los valores de la animacion por parametro 
	 * @param animation
	 */
	public void setAnimation(Animation<TextureRegion> animation) { 
		
		this.animation = animation; 
	}

	/**
	 * 
	 */
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		batch.draw(getAnimation().getKeyFrame(getStateTime()), getX(), getY(), getWidth(), getHeight());
	}
		
	/**
	 * 
	 */
	@Override
	public void act(float delta) { 
		
		setStateTime(getStateTime() + delta);
		rectangle.x = getX();
		rectangle.y = getY();
	}
	
	/**
	 * Cambia la posicion horizontalmente del actor animado en funcion de timer (delta).
	 * Usa el sentido de la variable de velocidad.
	 * @param delta
	 */
	public void moverHorizontal(float delta) { 
		
		setX(getX() + delta * velocidad); 
	}
	
	/**
	 * Cambia la posicion verticalmente del actor animado en funcion de timer (delta).
	 * Usa el sentido de la variable de velocidad.
	 * @param delta
	 */
	public void moverVerticalmente(float delta) { 
		
		setY(getY() + delta * velocidad); 
	}
	
	/**
	 * Valida si el actor animado esta en pantalla.
	 * @return
	 */
	public boolean enPantalla() {
		
			   //no paso el limite "x" izquierdo
		return getX() >= 0 && 
			   //no paso el limite "x" derecho
			   getRight() <= Const.WIDTH && 
			   //no paso el limite "y" inferior
			   getY() >= 0 && 
			   //no ppaso el limite "y" superior
			   getY() <= Const.HEIGHT;
	}

	/**
	 * Obtiene la velocidad de la clase.
	 * @return
	 */
	public float getVelocidad() {
		return velocidad;
	}

	/**
	 * Cambia el valor de la velocidad y el sentido por 
	 * parametro.
	 * @param velocidad
	 */
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
	public Rectangle getBoundRectangle() {
		return rectangle;
	}
}
