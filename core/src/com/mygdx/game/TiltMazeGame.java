package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.views.IntroMenu;

public class TiltMazeGame extends Game {

	IntroMenu menu;

	public AssetManager manager = new AssetManager();

	/** If the game should vibrate or not. */
	private boolean vibrate = true;

	/** If the game should play sound or not. */
	private boolean sound = true;

	/**
	 * @see com.badlogic.gdx.Game#create()
	 */
	@Override
	public void create () {

		setScreen(new IntroMenu(this));
	}

	/**
	 * @see com.badlogic.gdx.Game#render()
	 */
	@Override
	public void render () {

		super.render();
	}
	public void resume(){

	}

	/**
	 * @see com.badlogic.gdx.Game#dispose()
	 */
	@Override
	public void dispose () {

		super.dispose();
	}



	/** @see ApplicationListener#pause() */
	public void pause (){

	}


	/**
	 * @see com.badlogic.gdx.Game#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	/**
	 * @see com.badlogic.gdx.Game#setScreen(com.badlogic.gdx.Screen)
	 */
	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

	/**
	 * @see com.badlogic.gdx.Game#getScreen()
	 */
	@Override
	public Screen getScreen() {
		return super.getScreen();
	}

	/**
	 * Checks if vibration is on.
	 *
	 * @return true if vibration is on false otherwise
	 */
	public boolean getVibrate() {
		return vibrate;
	}

	/**
	 * Checks if sound is on.
	 *
	 * @return true if sound is on false otherwise
	 */
	public boolean getSound()
	{
		return sound;
	}

	/**
	 * Sets the vibrate.
	 *
	 * @param vibrate the new vibrate
	 */
	public void setVibrate(boolean vibrate) {
		this.vibrate = vibrate;
	}

	/**
	 * Sets the sound.
	 *
	 * @param sound the new sound
	 */
	public void setSound(boolean sound)
	{
		this.sound = sound;
	}
}
