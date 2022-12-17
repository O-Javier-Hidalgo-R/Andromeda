/**
 * 
 */
package com.andromeda.pantallas;
import com.andromeda.Utilidades.*;

import org.w3c.dom.Text;

import com.andromeda.VideojuegoMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * @author O. Javier Hidalgo R.
 *
 */
public class PantallaCarga extends PantallaBase {
	
	/**
	 * @param main
	 */
	Texture texture;
	
	public PantallaCarga(VideojuegoMain main) {
		super(main);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void show() {
		
		texture = new Texture("pantallaCarga.png");
	}
	
	@Override
	public void render(float delta) {
		
		Utils.actPantalla(Color.BLACK);
		
		if(main.getManager().update()) { // Si han cargado todas las imagenes
			main.cargarPantallas();
			//cambiar por el menu cuando este listo
			main.setScreen(main.pantallaJuego);
		}
		
		batch.begin();
			batch.draw(texture, 0, 0, Const.WIDTH, Const.HEIGHT);
		batch.end();
	}
	
	@Override
	public void dispose() {
		texture.dispose();
	}
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		super.hide();
		texture.dispose();
	}
}
