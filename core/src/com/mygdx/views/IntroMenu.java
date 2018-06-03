package com.mygdx.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.TiltMazeGame;


public class IntroMenu extends AbstractScreen{


    private Sprite splash;

    private SpriteBatch spriteB;


    /**
     * Instantiates a new Screen
     *
     * @param game the game
     *
     */
    public IntroMenu(TiltMazeGame game)
    {
        super(game);

    }

    /**
     * @see com.badlogic.gdx.Screen#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        splash.setSize(width, height);

    }

    /**
     * @see com.badlogic.gdx.Screen#dispose()
     */
    @Override
    public void hide (){
        dispose();
    }

    /**
     * @see com.badlogic.gdx.Screen
     */
    @Override
    public void render (float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteB.begin();
        splash.draw(spriteB);
        spriteB.end();
        if (game.manager.update()) { // Load some, will return true if done loading
            if(Gdx.input.isTouched())
                game.setScreen(new MainMenu(game));
        }


    }

    /**
     * @see com.badlogic.gdx.Screen#show()
     */
    @Override
    public void show() {
        spriteB = new SpriteBatch();
        Texture stxt = new Texture("img/firstMneu.png");
        splash = new Sprite(stxt);
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
        game.manager.load("ui/uiskin.json", Skin.class);
        game.manager.load("sound/menus.mp3", Music.class);
        game.manager.load("sound/play.mp3", Music.class);



    }


    /**
     * @see com.badlogic.gdx.Screen#dispose()
     */
    @Override
    public void dispose() {
        spriteB.dispose();
        splash.getTexture().dispose();

    }


}
