package com.andromeda;

import com.andromeda.pantallas.PantallaInicio;
import com.andromeda.pantallas.PantallaJuego;
import com.badlogic.gdx.Game;

public class Videojuego extends Game {
	@Override
	public void create(){
		setScreen(new PantallaJuego(this));
	}
}
