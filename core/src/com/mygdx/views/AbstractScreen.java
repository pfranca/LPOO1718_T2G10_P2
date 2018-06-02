package com.mygdx.views;

import com.mygdx.game.TiltMazeGame;

import com.badlogic.gdx.Screen;

// TODO: Auto-generated Javadoc
/**
 * The Class Abstract.
 */
public abstract class AbstractScreen implements Screen {

    /** The game. */
    protected TiltMazeGame game;


    /**
     * Instantiates a new abstract.
     *
     * @param game
     *            the game
     */
    public AbstractScreen(TiltMazeGame game)
    {
        this.game = game;
    }


    /**
     * @see com.badlogic.gdx.Screen#pause()
     */
    @Override
    public void pause() {


    }

    /**
     * @see com.badlogic.gdx.Screen#resume()
     */
    @Override
    public void resume() {


    }



    /**
     * @see com.badlogic.gdx.Screen#dispose()
     */
    @Override
    public void dispose() {

    }


}
