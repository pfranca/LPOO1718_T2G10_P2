package com.mygdx.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.TiltMazeGame;

/**
 * The Class Animator.
 */
public class Animator extends AbstractScreen{

    /** The number of different frames per animation. */
    private static final int FRAME_COLS = 6;

    /** The stars the user receiver. */
    private int stars;

    /** The star animation. */
    private Animation<TextureRegion> starAnimation;

    /** The star sheet. */
    private Texture starSheet;

    /** The star frames. */
    private TextureRegion[] starFrames;

    /** The sprite bactch. */
    private SpriteBatch spriteBac;

    /** The current frame. */
    private TextureRegion currentFrame;

    /** The background. */
    private TextureRegion  fundo;

    /** The level the user was in. */
    private int level;


    /** The initial time the animating started. */
    float stateTime;

    /**
     * Instantiates a new animator.
     *
     * @param game the game
     * @param stars the stars received
     * @param level the level was in
     */
    public Animator(TiltMazeGame game, int stars,int level) {
        super(game);
        this.stars=stars;
        this.level = level;
    }

    /**
     * @see com.badlogic.gdx.Screen#show()
     */
    @Override
    public void show() {
        if(stars != 4)
        {
            starSheet = new Texture (Gdx.files.internal("ui/animation.png"));
            TextureRegion[][] tmp = TextureRegion.split(starSheet, 31, 31);
            starFrames = new TextureRegion[FRAME_COLS];
            for(int i = 0; i < FRAME_COLS;i++)
            {
                starFrames[i] = tmp[0][i];
            }
            starAnimation = new Animation(0.3f,starFrames);
            starAnimation.setPlayMode(Animation.PlayMode.LOOP);
            spriteBac = new SpriteBatch();
            stateTime = Gdx.graphics.getDeltaTime();
            Texture fundo1 = new Texture(Gdx.files.internal("img/win.png"));
            tmp = TextureRegion.split( fundo1, fundo1.getWidth(), fundo1.getHeight());
            fundo = tmp[0][0];
        }
        else
        {


            starFrames = new TextureRegion[1];
            starSheet = new Texture (Gdx.files.internal("img/loss.png"));
            starAnimation = new Animation(0.3f,starFrames);
            starAnimation.setPlayMode(Animation.PlayMode.LOOP);
            spriteBac = new SpriteBatch();
            stateTime = Gdx.graphics.getDeltaTime();
            Texture fundo1 = new Texture(Gdx.files.internal("img/loss.png"));
            TextureRegion[][] tmp = TextureRegion.split(fundo1, fundo1.getWidth(), fundo1.getHeight());
            fundo = tmp[0][0];
        }
    }

    /**
     * @see com.badlogic.gdx.Screen#render(float)
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stateTime+= delta;
        currentFrame = starAnimation.getKeyFrame(stateTime, true);
        int w1, h1;
        w1 = Gdx.graphics.getWidth()/5;
        h1 = Gdx.graphics.getHeight()/3;
        switch(stars)
        {
            case 1:
                spriteBac.begin();
                spriteBac.draw(fundo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                spriteBac.draw(currentFrame, w1 *2, h1*2, currentFrame.getRegionWidth()*10,currentFrame.getRegionHeight()*10);
                spriteBac.end();
                break;
            case 2:
                spriteBac.begin();
                spriteBac.draw(fundo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                spriteBac.draw(currentFrame, w1, h1,currentFrame.getRegionWidth()*10,currentFrame.getRegionHeight()*10);
                spriteBac.draw(currentFrame, w1*3, h1, currentFrame.getRegionWidth()*10,currentFrame.getRegionHeight()*10);
                spriteBac.end();
                break;
            case 3:
                spriteBac.begin();
                spriteBac.draw(fundo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                spriteBac.draw(currentFrame, w1, h1,currentFrame.getRegionWidth()*10,currentFrame.getRegionHeight()*10);
                spriteBac.draw(currentFrame, w1 *2, h1*1.5f, currentFrame.getRegionWidth()*10,currentFrame.getRegionHeight()*10);
                spriteBac.draw(currentFrame, w1 *3, h1, currentFrame.getRegionWidth()*10,currentFrame.getRegionHeight()*10);

                spriteBac.end();
                break;
            case 4:
                spriteBac.begin();
                spriteBac.draw(fundo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                spriteBac.end();
        }




        if(Gdx.input.isTouched())
        {
            game.setScreen(new Level(game));
        }

    }

    /**
     * @see com.badlogic.gdx.Screen#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    /**
     * @see com.badlogic.gdx.Screen#hide()
     */
    @Override
    public void hide() {
        dispose();

    }

    /**
     * @see com.badlogic.gdx.Screen#dispose()
     */
    @Override
    public void dispose() {
        spriteBac.dispose();

    }

}