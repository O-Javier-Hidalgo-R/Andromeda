/**
 * 
 */
package com.andromeda.actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Actor usado para representar a los aliens en el programa.
 * @author usuario
 *
 */
public class ActorAlien extends ActorAnimado {
	
	private boolean Alive;

	public ActorAlien(float x, float y, float width, float heigth, int velocidad, float frameDuration,
			Array<AtlasRegion> frames) {
		super(x, y, width, heigth, velocidad, frameDuration, frames);
		// TODO Auto-generated constructor stub
		setAlive(true);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return Alive;
	}

	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		Alive = alive;
	}

}
