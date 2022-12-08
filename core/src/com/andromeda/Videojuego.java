package com.andromeda;

import com.andromeda.pantallas.PantallaInicio;
import com.andromeda.pantallas.PantallaJuego;
import com.badlogic.gdx.Game;

public class Videojuego extends Game {

	public PantallaInicio pantallaInicio;
	public PantallaJuego pantallaJuego;

	@Override
	public void create(){
		pantallaInicio = new PantallaInicio(this);
		pantallaJuego = new PantallaJuego(this);

		setScreen(pantallaInicio);
	}
}
