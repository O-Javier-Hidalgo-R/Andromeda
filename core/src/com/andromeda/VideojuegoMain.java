package com.andromeda;

import com.andromeda.pantallas.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class VideojuegoMain extends Game {

	public PantallaBase pantallaInicio,
						pantallaCarga,
						pantallaMenu,
						pantallaJuego,
						pantallaDerrota,
						pantallaPuntaje;
	
	private AssetManager manager;
	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create() {
		iniManager();
		batch = new SpriteBatch();
		pantallaInicio = new PantallaInicio(this);
		pantallaCarga = new PantallaCarga(this);
		setScreen(pantallaInicio);
		this.setFont(new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false));
	}

	@Override
	public void dispose() {
		getManager().dispose();
		batch.dispose();
	}
	
	private void iniManager() {
		
		manager = new AssetManager();
		
		//solicita cargar las texturas
		manager.load("texturas/texturas.atlas", TextureAtlas.class);
		
		//solicita cargar los sonidos
		manager.load("sonidos/cancion.mp3", Sound.class);
		manager.load("sonidos/disparoAlien.wav", Sound.class);
		manager.load("sonidos/disparoJugador.wav", Sound.class);
		manager.load("sonidos/explosion.wav", Sound.class);
	}
	
	public void cargarPantallas() {
		
		pantallaJuego = new PantallaJuego(this);
		pantallaDerrota = new PantallaDerrota(this);
		//pantallaDerrota = new PantallaDerrota(this);
		//pantallaPuntaje = new PantallaPuntaje(this);
	}
	
	public AssetManager getManager() { return manager; }
	
	public SpriteBatch getBatch() { return batch; }

	public void setBatch(SpriteBatch batch) { this.batch = batch;}
	
	public TextureAtlas getAtlas() { return manager.get("texturas/texturas.atlas", TextureAtlas.class); }

	public BitmapFont getFont() {
		return font;
	}

	private void setFont(BitmapFont font) {
		this.font = font;
	}
}
