package com.mygdx.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.elements.Ball;
import com.mygdx.game.Player;
import com.mygdx.game.TiltMazeGame;
import com.mygdx.levels.LevelMaze;
import com.badlogic.gdx.utils.TimeUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Play.
 */
public class Play extends AbstractScreen{

    /** The fps. */
    private final float FPS = 1/60f;

    /** The position. */
    private final int POSITION = 3;

    /** The velocity. */
    private final int VELOCITY = 8;

    /** The running case. */
    private final int RUNNING = 1;

    /** The won case. */
    private final int WON = 2;

    /** The lost case. */
    private final int LOST = 3;

    /** The level. */
    private int level;

    /** The ball. */
    private Ball ball;

    /** The table. */
    private Table table;

    /** The stage. */
    private Stage stage;

    /** The world. */
    private World world;

    /** The camera. */
    private OrthographicCamera camera;

    /** The sprite batch. */
    private SpriteBatch spriteBac;

    /** The sprite. */
    private Sprite sprite;

    /** The World Teeter. */
    private LevelMaze mLevel;

    /** The player. */
    private Player player;

    /** The bodies. */
    private Array<Body> bodies = new Array<Body>();

    /** The state. */
    private int state = 1;

    /** The time the game started. */
    private long timeinit;
    /** The timepassed since the beggining of the level. */
    private long timepassed;

    /** The song. */
    private Music musica;


    /**
     * Instantiates a new play.
     *
     * @param level
     *            the level
     * @param game
     *            the game
     */
    public Play(int level, TiltMazeGame game) {
        super(game);
        this.level = level;

    }

    /**
     * @see com.badlogic.gdx.Screen#show()
     */
    @Override
    public void show() {

        playGame();

    }

    /**
     * Creates all the game components
     */
    private void playGame() {
        timeinit = TimeUtils.millis();
        Json json = new Json();

        player = new Player();
        player.setPlayerFromString(json.fromJson(String.class, Gdx.files.local("player.json")));

        if(game.getSound())
        {
            musica = Gdx.audio.newMusic(Gdx.files.internal("sound/play.mp3"));
            musica.play();
            musica.setOnCompletionListener(new Music.OnCompletionListener() {

                @Override
                public void onCompletion(Music music) {
                    musica.play();

                }
            });
        }
        Gdx.input.setInputProcessor(new GestureDetector(new GestureListener(){
            @Override
            public boolean zoom(float initialDistance, float distance) {
                return false;
            }

            @Override
            public boolean touchDown(float x, float y, int pointer, int button) {
                return false;
            }

            @Override
            public boolean tap(float x, float y, int count, int button) {
                return false;
            }

            @Override
            public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
                                 Vector2 pointer1, Vector2 pointer2) {
                return false;
            }

            @Override
            public void pinchStop () {
            }

            @Override
            public boolean panStop(float x, float y, int pointer, int button) {
                return false;
            }

            @Override
            public boolean pan(float x, float y, float deltaX, float deltaY) {
                return false;
            }

            @Override
            public boolean longPress(float x, float y) {
                game.setScreen(new Level(game));
                return false;
            }

            @Override
            public boolean fling(float velocityX, float velocityY, int button) {
                game.setScreen(new MainMenu(game));
                return false;
            }

        }));

        table = new Table();
        stage = new Stage();
        stage.addActor(table);
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Texture txt = new Texture("img/wood_bg.jpg");
        sprite = new Sprite(txt);
        spriteBac = new SpriteBatch();
        world = new World(new Vector2(0,0),true);
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/100, Gdx.graphics.getHeight()/100);

        mLevel = new LevelMaze(world);
        mLevel.makeWorld();

        float weigth = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        float ratio = weigth/height;
        float ballSize = (float) (ratio/6);

        switch(level)
        {
            case 1:
                mLevel.makeWorld1();
                ball = new Ball(game, (float) -(weigth/2*0.8*0.01f), (float) -(height/2*0.7*0.01f),ballSize,world);
                ball.makeBody();
                break;
            case 2:
                mLevel.makeWorld2();
                ball = new Ball(game, (float) -(weigth/2*0.8*0.01f), (float) -(height/2*0.7*0.01f),ballSize,world);
                ball.makeBody();
                break;
            case 3:
                mLevel.makeWorld3();
                ball = new Ball(game, (float) -(weigth/2*0.8*0.01f), (float) -(height/2*0.7*0.01f),ballSize,world);
                ball.makeBody();
                break;
            case 4:
                mLevel.makeWorld4();
                ball = new Ball(game, (float) -(weigth/2*0.8*0.01f), (float) -(height/2*0.7*0.01f),ballSize,world);
                ball.makeBody();
                break;
            case 5:
                mLevel.makeWorld5();
                ball = new Ball(game, (float) -(weigth/2*0.8*0.01f), (float) -(height/2*0.7*0.01f),ballSize,world);
                ball.makeBody();
                break;
        }
    }


    /**
     * @see com.badlogic.gdx.Screen#render(float)
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        switch(state)
        {
            case RUNNING:
                camera.update();

                world.step(FPS, VELOCITY, POSITION);

                ball.update(delta);

                if(ball.getContHole() == 1)
                {
                    state = 3;
                }
                if(ball.getContHole() == 2)
                {
                    state = 2;
                }
                spriteBac.setProjectionMatrix(camera.combined);
                spriteBac.begin();

                sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
                sprite.setScale(0.01f);
                sprite.draw(spriteBac);

                world.getBodies(bodies);
                Body bod = null;
                for(Body body: bodies)
                {
                    if(body.getFixtureList().get(0).getUserData() != "b")
                    {
                        if(body.getUserData() instanceof Sprite)
                        {
                            Sprite sprit = (Sprite) body.getUserData();
                            sprit.setPosition(body.getPosition().x - sprit.getWidth()
                                    / 2, body.getPosition().y - sprit.getHeight() / 2);
                            sprit.draw(spriteBac);
                        }
                    }
                    else
                        bod = body;
                }
                if(bod.getUserData() instanceof Sprite)
                {
                    Sprite sprit = (Sprite) bod.getUserData();
                    sprit.setPosition(bod.getPosition().x - sprit.getWidth()
                            / 2, bod.getPosition().y - sprit.getHeight() / 2);
                    sprit.draw(spriteBac);
                }
                spriteBac.end();
                break;

            case WON:
                timepassed = TimeUtils.timeSinceMillis(timeinit);
                player.levelPassed(level, timepassed);
                player.write(new Json());
                game.setScreen(new Animator(game,player.getStarLevel(level),level));
                break;
            case LOST:
                game.setScreen(new Animator(game,4,level));
                break;
        }



    }


    /**
     * @see com.badlogic.gdx.Screen#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }


    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    /**
     * @see com.badlogic.gdx.Screen#hide()
     */
    @Override
    public void hide() {
        dispose();

    }


    @Override
    public void dispose() {
        spriteBac.dispose();
        stage.dispose();
        sprite.getTexture().dispose();
        world.dispose();
        if(game.getSound())
            musica.dispose();

    }

}
