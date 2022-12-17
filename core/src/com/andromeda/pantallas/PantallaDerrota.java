package com.andromeda.pantallas;

import com.andromeda.VideojuegoMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class PantallaDerrota extends PantallaBase { // Pantalla que su utilidad es mostrar el GameOver. 
	private AtlasRegion texturaFondo;
	private int contador; // Para que no se pueda pulsar desde el principio.
	
	public PantallaDerrota(VideojuegoMain main) {
		super(main);
	}
	
	@Override
	public void show() {
		texturaFondo = main.getAtlas().findRegion("fondoD");
		contador = 100;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyPressed(Keys.ENTER) && contador == 0)
			main.setScreen(main.pantallaJuego);  // Te devuelve al juego
		else if(contador > 0)
			contador--;
		
		batch.begin();
		batch.draw(texturaFondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
}

