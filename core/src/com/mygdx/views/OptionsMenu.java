package com.mygdx.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.TiltMazeGame;

// TODO: Auto-generated Javadoc
/**
 * The Class OptionsMenu.
 */
public class OptionsMenu extends AbstractScreen {

    /** The stage. */
    private Stage stage;

    /** The skin. */
    private Skin skin;

    /** The table. */
    private Table table;

    /** The splash. */
    private Sprite splash;

    /** The sprite batch. */
    private SpriteBatch spriteBac;

    /** The heading. */
    private Label heading;

    /** The Back button. */
    private TextButton button;

    /** The Reset Button. */
    private TextButton buttonr;

    /** The vibrate option. */
    private CheckBox vibrate;

    /** The sound option. */
    private CheckBox sound;

    /**
     * Instantiates a new options menu.
     *
     * @param game
     *            the game
     */
    public OptionsMenu(TiltMazeGame game) {
        super(game);

    }

    /**
     * @see com.badlogic.gdx.Screen#show()
     */
    @Override
    public void show() {
        stage = new Stage();

        skin = game.manager.get("ui/uiskin.json",Skin.class);
        table = new Table(skin);
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

        vibrate = new CheckBox("Vibrate", skin);
        vibrate.setChecked(game.getVibrate());

        vibrate.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                if(event.getListenerActor() == vibrate)
                {
                    game.setVibrate(!game.getVibrate());
                }
            }
        });

        sound = new CheckBox("Sound", skin);
        sound.setChecked(game.getSound());

        sound.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                if(event.getListenerActor() == sound)
                {
                    game.setSound(!game.getSound());
                }
            }
        });


        buttonr = new TextButton("Reset", skin);
        buttonr.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                Gdx.files.local("player.json").delete();
            }
        });

        button = new TextButton("BACK", skin);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(new MainMenu(game));
            }
        });

        heading = new Label("OPTIONS", skin, "big");
        table.right();
        table.pad(Gdx.graphics.getHeight()/5);
        table.add(heading);
        table.row();
        table.getCell(heading).spaceBottom(Gdx.graphics.getHeight()/5);
        table.add(vibrate);
        table.getCell(vibrate).spaceBottom(Gdx.graphics.getHeight()/15);
        table.row();
        table.add(sound);
        table.getCell(sound).spaceBottom(Gdx.graphics.getHeight()/15);
        table.row();
        table.add(buttonr);
        table.getCell(buttonr).spaceBottom(Gdx.graphics.getHeight()/8);
        table.row();
        table.add(button);

        spriteBac = new SpriteBatch();
        Texture stxt = new Texture("img/mainMenu.png");

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
    }



}
