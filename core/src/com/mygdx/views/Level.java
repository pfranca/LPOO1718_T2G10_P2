package com.mygdx.views;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Player;
import com.mygdx.game.TiltMazeGame;

// TODO: Auto-generated Javadoc
/**
 * The Class Level.
 */
public class Level extends AbstractScreen  {

    /** The stage. */
    private Stage stage;

    /** The skin. */
    private Skin skin;

    /** The table. */
    private Table table;

    /** The splash. */
    private Sprite splash;

    /** The sprite bactch. */
    private SpriteBatch spriteBac;

    /** The button. */
    private TextButton button;

    /** The player. */
    private Player player;

    /** The Song. */
    private Music musica;


    /**
     * Instantiates a new level.
     *
     * @param game
     *            the game
     */
    public Level(TiltMazeGame game) {
        super(game);
    }

    /**
     * @see com.badlogic.gdx.Screen#show()
     */
    @Override
    public void show() {
        Json json = new Json();
        player = new Player();
        if(!Gdx.files.local("player.json").exists())
        {
            player.write(json);
        }
        player.setPlayerFromString(json.fromJson(String.class, Gdx.files.local("player.json")));

        if(game.getSound())
        {musica = Gdx.audio.newMusic(Gdx.files.internal("sound/m1.mp3"));
            musica.play();

            musica.setOnCompletionListener(new Music.OnCompletionListener() {

                @Override
                public void onCompletion(Music music) {
                    musica.play();

                }
            });
        }
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        skin = game.manager.get("ui/uiskin.json",Skin.class);

        table = new Table(skin);
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for(int i = 1; i < 6; i++)
        {
            final int level = i;
            String leve;

            if(player.getLevel() >= i)
            {
                leve = Integer.toString(i);
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append("n");
                stringbuilder.append(player.getStarLevel(i));
                stringbuilder.append("star");
                String buttonS = stringbuilder.toString();
                button = new TextButton(leve, skin, buttonS); //buttonS style, 3rd argument
                button.addListener(new ClickListener()
                {
                    @Override
                    public void clicked(InputEvent event, float x, float y)
                    {
                        game.setScreen(new Play(level, game));
                    }
                });
            }
            else
            {
                leve = "?";
                button = new TextButton(leve,skin);
                button.setDisabled(true);
            }
            table.add(button).spaceRight(15).width(Gdx.graphics.getWidth()/6).height(Gdx.graphics.getWidth()/5);
        }

        button = new TextButton("Main Menu", skin);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(new MainMenu(game));
            }
        });

        table.row();
        table.add(button).spaceRight(15).spaceTop(100).width(Gdx.graphics.getWidth()/6).height(Gdx.graphics.getWidth()/20);

        stage.addActor(table);

        spriteBac = new SpriteBatch();
        Texture stxt = new Texture("img/wood_bg.jpg");
        splash = new Sprite(stxt);
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


    }

    /**
     * @see com.badlogic.gdx.Screen#render(float)
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBac.begin();
        splash.draw(spriteBac);
        spriteBac.end();


        stage.act(delta);
        stage.draw();

    }

    /**
     * @see com.badlogic.gdx.Screen#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        table.invalidateHierarchy();
    }


    @Override
    public void pause() {


    }


    @Override
    public void resume() {


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
        stage.dispose();
        if(game.getSound())
            musica.dispose();

    }

}
