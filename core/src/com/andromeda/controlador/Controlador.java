/**
 * 
 */
package com.andromeda.controlador;

import com.andromeda.pantallas.PantallaJuego;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

/**
 * @author usuario
 *
 */
public class Controlador extends InputAdapter {
	
	public PantallaJuego juego;
	
	public Controlador(PantallaJuego juego) {
		this.juego = juego;
	}

    @Override
    public boolean keyDown(int keycode) {
        
    	switch (keycode)
	    {
		case Keys.LEFT:
			juego.getJugador().moverIzquierda(true);;
			break;
		case Keys.RIGHT:
			juego.getJugador().moverDerecha(true);;
			break;
		case Keys.SPACE:
			juego.getBalaJugador().colocar(juego.getJugador());
			break;
	    }
	    return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        
    	switch (keycode)
	    {
		case Keys.LEFT:
			juego.getJugador().moverIzquierda(false);
			break;
		case Keys.RIGHT:
			juego.getJugador().moverDerecha(false);
			break;
	    }
	    return true;
    }
}
