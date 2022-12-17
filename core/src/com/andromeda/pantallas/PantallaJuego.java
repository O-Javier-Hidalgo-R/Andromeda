/**
 * 
 */
package com.andromeda.pantallas;

import com.andromeda.VideojuegoMain;
import com.andromeda.Utilidades.*;
import com.andromeda.actores.ActorAJugador;
import com.andromeda.actores.ActorBala;
import com.andromeda.actores.Colmena;
import com.andromeda.controlador.Controlador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Clase heredada de pantallaBase en la que se ejecuta el videojuego.
 * @author O. Javier Hidalgo R.
 *
 */
public class PantallaJuego extends PantallaBase {
	
	private Stage stage;
	private ActorAJugador jugador;
	private ActorBala balaJugador;
	private AtlasRegion fondo;
	private Controlador controlador;
	private Colmena aliens;
	private ActorBala balaAlien;
	private int alienRandom;
	private boolean derrota;
	private AtlasRegion vida;
	private int marcadorDePuntos;

	/**
	 * Constructor heredado.
	 * @param main clase principal.
	 */
	public PantallaJuego(VideojuegoMain main) {
		super(main);
	}
	
	@Override
	public void show() {
		
		//Paso el control al input procesor
		controlador = new Controlador(this);
		Gdx.input.setInputProcessor(controlador);
		
		inicializaActores();
		
		agregarActoresEscenario();
	}
	

	@Override
	public void render(float delta) {

		Utils.actPantalla(Color.BLACK);

		batch.begin();
		batch.draw(fondo, 0, 0, Const.WIDTH, Const.HEIGHT);
		batch.draw(vida, 0, 0, 128, 32);
		main.getFont().draw(batch, "PUNTAJE: " + Integer.toString(marcadorDePuntos), Const.WIDTH / 2, 30);
		batch.end();

		stage.act();

		operacionesDelEscenario();

		stage.draw();
	}

	@Override
	public void dispose() {
		
		stage.dispose();
		
	}
	
	@Override
	public void hide() {
		stage.dispose();
		Gdx.input.setInputProcessor(null);
	}
	
	private void inicializaActores() {
		
		this.derrota = false;

		this.marcadorDePuntos = 0;

		//Creo el escenario principal
		stage = new Stage();
		stage.setDebugAll(true);
				
		//Coloco la textura del fondo desde el administrador de archivos
		fondo = main.getManager().get("texturas/texturas.atlas", TextureAtlas.class).findRegion("fondo");
				
		//Inicializo el actor del jugador con un constructor parametrizado
		setJugador(new ActorAJugador((Const.WIDTH - 32)/2F, 50F, 32F, 32F, 250F, 0.2F, main.getAtlas().findRegions("player")));

		//Inicializo el actor de la bala con un constructor parametrizado
		setBalaJugador(new ActorBala(Const.WIDTH, Const.HEIGHT, 8F, 32F, 300F, main.getManager().get("sonidos/disparoJugador.wav", Sound.class), 0.5F,main.getAtlas().findRegions("balaJugador")));
				
		//Inicializa el actor que se usara para la bala de los aliesn
		balaAlien = new ActorBala(Const.WIDTH, Const.HEIGHT, 8F, 32F, -300F, main.getManager().get("sonidos/disparoAlien.wav", Sound.class), 0.5F,main.getAtlas().findRegions("balaAlien"));
		
		//Inicializa los aliens
		aliens = new Colmena(64, 200, 4, 10, 32, 100, 10, main.getAtlas());

		//Inicializa la textura de la vidas
		vida = main.getAtlas().findRegion("vidaA");
	}

	private void agregarActoresEscenario() {
		
		stage.addActor(getBalaJugador());
		stage.addActor(getJugador());
		stage.addActor(balaAlien);
		stage.addActor(aliens);
	}
	
	private void operacionesDelEscenario() {
	
		actualizarVidas();

		comprobarFinJuego();

		alienRandomDispara();
		
		aliensGanan();
		
		condicionesPorcadaAlien();
		
		verificaNuevaColmena();
	}

	private void actualizarVidas() {
		// TODO Auto-generated method stub
		vida = main.getAtlas().findRegion("vidaA");
		if(jugador.getVidas() == 2) vida = main.getAtlas().findRegion("vidaB");
		else if(jugador.getVidas() == 1) vida = main.getAtlas().findRegion("vidaC");
	}

	private void comprobarFinJuego() {
		// TODO Auto-generated method stub
		if (this.derrota) {

			main.setScreen(main.pantallaDerrota);
		}
	}

	private void verificaNuevaColmena() {
		
		if(aliens.getChildren().isEmpty()) {
			
			aliens.remove();
			aliens = new Colmena(64, 200, 4, 10, 32, 100, 10, main.getAtlas());
			stage.addActor(aliens);
		}
	}

	private void condicionesPorcadaAlien() {
		
		float xm = Const.WIDTH;
		float ym = Const.HEIGHT;
		float xM = 0;
		
		for (Actor alien : aliens.getChildren()) {
			
			Rectangle alienRectangle = new Rectangle(alien.getX() + aliens.getX(), alien.getY() + aliens.getY(), alien.getWidth(), alien.getHeight());
			
			if (xm > alien.getX()) xm = alien.getX();
			if (ym > alien.getY()) ym = alien.getY();
			if (xM < alien.getRight()) xM = alien.getRight();
			
			if (alienRectangle.overlaps(getBalaJugador().getBoundRectangle())){
				
				alien.remove();
				getBalaJugador().desaparecer();
				main.getManager().get("sonidos/explosion.wav", Sound.class).play();
				marcadorDePuntos += 10;
			}
			
			if (alienRectangle.overlaps(getJugador().getBoundRectangle())){
				
				//si alguno de los aliens chocaron con el jugador
				this.derrota = true;
			}
			
		}
		
		aliens.setLimiteIzquierdo(xm);
		aliens.setLimiteInferior(ym);
		aliens.setLimiteDerecho(xM);;
	}

	private void aliensGanan() {
		
		if(aliens.getY() < 0 - aliens.getLimiteInferior()) this.derrota = true;
		
		if(balaAlien.getBoundRectangle().overlaps(getJugador().getBoundRectangle())) { 
			
			balaAlien.desaparecer();
			main.getManager().get("sonidos/explosion.wav", Sound.class).play(); 
			getJugador().descontarVida();
			if(getJugador().muerto()) this.derrota = true;
		}
	}

	private void alienRandomDispara() {
		
		alienRandom = (int)(Math.random() * aliens.getChildren().size);
		
		Actor alien1 = aliens.getChild(alienRandom);
			
		balaAlien.colocar(alien1.getX() + alien1.getWidth()/2 + aliens.getX(), alien1.getY() + aliens.getY());
	}

	/**
	 * Permite mostrar el jugador.
	 * @return the jugador controlado por el usuario.
	 */
	public ActorAJugador getJugador() {
		return jugador;
	}

	/**
	 * Permite cambiar el jugador por parametros.
	 * @param jugador the jugador to set
	 */
	private void setJugador(ActorAJugador jugador) {
		this.jugador = jugador;
	}

	/**
	 * muestra la bala del jugador
	 * @return the balaJugador
	 */
	public ActorBala getBalaJugador() {
		return balaJugador;
	}

	/**
	 * permite cambiar los valores de la bala por parametro
	 * @param balaJugador the balaJugador to set
	 */
	private void setBalaJugador(ActorBala balaJugador) {
		this.balaJugador = balaJugador;
	}
}
