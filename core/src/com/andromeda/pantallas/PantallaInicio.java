/**
 * 
 */
package com.andromeda.pantallas;

import com.andromeda.Utilidades.*;

import java.awt.font.ImageGraphicAttribute;

import com.andromeda.VideojuegoMain;
import com.andromeda.Utilidades.Utils;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AddAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

/**
 * @author O. Javier Hidalgo R.
 *
 */
public class PantallaInicio extends PantallaBase {
	
	Texture img;
	Stage stage;
	
	public PantallaInicio(VideojuegoMain main) {
		super(main);
		// TODO Auto-generated constructor stub
	}
 
	@Override
    public void show() {
        img = new Texture("pantallaInicial.png");
        
        img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        
        Image image = new Image(img);
        
        //ajusta el tamaño del padre
        image.setFillParent(true);
        
        //escala la imagen en Y
        image.setScaling(Scaling.fillY);
        
        stage = new Stage();
        
        stage.addActor(image);
        
        stage.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(0.7F), Actions.delay(0.5F), Actions.fadeOut(0.5F), Actions.run(new Runnable() {
			
			@Override
			public void run() {
				main.setScreen(main.pantallaCarga);
			}
		})));
    }

    @Override
    public void render(float delta) {
        Utils.actPantalla(Color.WHITE);

        stage.act();
        
        stage.draw();
    }

    @Override
    public void hide() {
    	stage.dispose();
    }
    
    @Override
    public void dispose() {
        img.dispose();
        stage.dispose();
    }
}
