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
import com.mygdx.game.TiltMazeGame;

public class MainMenu extends AbstractScreen{

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

    /** The button exit. */
    private TextButton buttonPlay, buttonOpt, buttonExit;

    /** The song. */
    private Music musica;

    /**
     * Instantiates a new Screen
     *
     * @param game the game
     *
     */
    public MainMenu(TiltMazeGame game)
    {
        super(game);

    }

    /**
     * @see com.badlogic.gdx.Screen#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        table.invalidateHierarchy();

    }

    /**
     * @see com.badlogic.gdx.Screen#hide()
     */
    @Override
    public void hide (){
        dispose();
    }

    /**
     * @see com.badlogic.gdx.Screen#render(float delta)
     */
    @Override
    public void render (float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBac.begin();
        splash.draw(spriteBac);
        spriteBac.end();

        stage.act(delta);
        stage.draw();


    }

    /**
     * @see com.badlogic.gdx.Screen#show()
     */
    @Override
    public void show() {
        if(game.getSound())
        {

            musica = Gdx.audio.newMusic(Gdx.files.internal("sound/menus.mp3"));
            musica.play();

            musica.setOnCompletionListener(new Music.OnCompletionListener() {

                @Override
                public void onCompletion(Music music) {
                    musica.play();

                }
            });
        }
        skin = game.manager.get("ui/uiskin.json",Skin.class);
        table = new Table();
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage = new Stage();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);


        buttonPlay = new TextButton("Play", skin);
        buttonPlay.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(new Level(game));
            }
        });

        buttonOpt = new TextButton("Options", skin);
        buttonOpt.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(new OptionsMenu(game));
            }
        });

        buttonExit = new TextButton("Exit" , skin);
        buttonExit.addListener(new ClickListener()
                               {
                                   @Override
                                   public void clicked(InputEvent event, float x, float y)
                                   {
                                       Gdx.app.exit();
                                   }
                               }
        );

        table.right();
        table.row();
        table.add(buttonPlay).size(Gdx.graphics.getWidth()/(7/2), Gdx.graphics.getHeight()/10);
        table.getCell(buttonPlay).spaceBottom(Gdx.graphics.getHeight()/40);
        table.row();
        table.add(buttonOpt).size(Gdx.graphics.getWidth()/(7/2), Gdx.graphics.getHeight()/10);
        table.getCell(buttonOpt).spaceBottom(Gdx.graphics.getHeight()/40);
        table.row();
        table.add(buttonExit).size(Gdx.graphics.getWidth()/(7/2), Gdx.graphics.getHeight()/10);
        table.getCell(buttonExit).spaceBottom(Gdx.graphics.getHeight()/10);
        table.pad(Gdx.graphics.getHeight()/25);

        spriteBac = new SpriteBatch();
        Texture stxt = new Texture("img/mainMenu.png");
        splash = new Sprite(stxt);
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }



    /**
     * @see com.badlogic.gdx.Screen#dispose()
     */
    @Override
    public void dispose() {
        spriteBac.dispose();
        splash.getTexture().dispose();
        stage.dispose();
        if(game.getSound())
            musica.dispose();

    }
}
