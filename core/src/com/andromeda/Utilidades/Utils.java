/**
 * 
 */
package com.andromeda.Utilidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * Clase con utilidades usadas en el programa.
 * @author usuario
 *
 */
public final class Utils {

	public static void actPantalla(Color color) {
		Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	/*
	public Group Colmena1(float x, float y, int filas, int columnas,float espacio, float velocidad, float velocidadF, TextureAtlas atlas) {
			
			Group result = new Group();
		
			for (int i = 0; i < filas - 1; i++) {
				
				x=0;
				
				for (int j = 0; j < columnas - 1; j++) {
					
					addActor(new ActorAlien(lo, y, espacio, espacio, 0, 0.5F, atlas.findRegions("alienA")));
					x += espacio*2;
				}
				
				y += espacio * 2;
			}
			
			limitar();
		}
	}
	*/
}
