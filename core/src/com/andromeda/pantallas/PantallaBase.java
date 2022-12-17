/**
 * 
 */
package com.andromeda.pantallas;

import com.andromeda.VideojuegoMain;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Clase abstracta usada como base para crear las pantallas.
 * @author O. Javier Hidalgo R.
 *
 */
public abstract class PantallaBase implements Screen {
	/**
	 * parametro que relaciona la clase principal con la pantalla.
	 */
	protected VideojuegoMain main;
	/**
	 * lote relacionado con la clase principal usada para el renderizado.
	 */
	protected SpriteBatch batch;
	
	/**
	 * Constructor parametrizado
	 * @param main clase principal a relacionar.
	 */
	public PantallaBase(VideojuegoMain main) {
		this.main = main;
		this.batch = main.getBatch();
	}

	/**
	 * 
	 */
	@Override
	public void show() {
	}
	
	/**
	 * 
	 */
	@Override
	public void render(float delta) {
	}

	/**
	 * 
	 */
	@Override
	public void resize(int width, int height) {
	}

	/**
	 * 
	 */
	@Override
	public void pause() {

	}

	/**
	 * 
	 */
	@Override
	public void resume() {

	}

	/**
	 * 
	 */
	@Override
	public void hide() {

	}

	/**
	 * 
	 */
	@Override
	public void dispose() {

	}

}
