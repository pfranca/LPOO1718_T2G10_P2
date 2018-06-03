package com.mygdx.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elements.Ball;
import com.mygdx.elements.Hole;
import com.mygdx.elements.Wall;

// TODO: Auto-generated Javadoc
/**
 * The Class WorldTeeter.
 */
public class LevelMaze
{


    /** The world. */
    private World world;

    /** The hole. */
    private Hole hole;

    /** The ball. */
    public Ball ball;

    /** The wall. */
    private Wall wall;

    /**
     * Instantiates a new world teeter.
     *
     * @param world
     *            the world
     */
    public LevelMaze(World world)
    {
        this.world = world;
    }

    /**
     * Make world.
     */
    public void makeWorld()
    {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float ratio = w /  h;
        float ballSize = (float) (ratio/6);

        // creating the frame

        //upper
        wall = new Wall(0, -ballSize + (h / 2) * 0.0094f, w * 0.01f, ballSize*2 , world);
        wall.makeBody();

        //lower
        wall = new Wall(0, ballSize + (-h / 2) * 0.0094f, w * 0.01f, ballSize*2, world);
        wall.makeBody();

        //left
        wall = new Wall(ballSize + (-w/2)*0.0099f,0,ballSize*2,h*0.01f,world);
        wall.makeBody();

        //right
        wall = new Wall(-ballSize + (+w/2)*0.0099f,0,ballSize*2,h*0.01f,world);
        wall.makeBody();

    }

    /**
     * Make world1.
     */
    public void makeWorld1() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float ratio = w /  h;
        float ballSize = (float) (ratio/6);

        ////L///

        hole = new Hole( (-w/2 * 0.49f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.49f * 0.015f),  -(h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.49f * 0.015f),  -(h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.49f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.49f * 0.015f),   (h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.49f * 0.015f),   (h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.49f * 0.015f),   (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.43f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.37f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.31f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();


        ///P///

        hole = new Hole( (-w/2 * 0.23f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.23f * 0.015f),  -(h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.23f * 0.015f),  -(h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.23f * 0.015f),  -(h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.23f * 0.015f),  (h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.23f * 0.015f),  (h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.23f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.17f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.11f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.05f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.17f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.11f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.05f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.05f * 0.015f),  (h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (-w/2 * 0.05f * 0.015f),  (h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        ///O///


        hole = new Hole( (w/2 * 0.051f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  (h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  (h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  -(h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.05f * 0.015f),  -(h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.11f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.11f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.17f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.17f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.23f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.23f * 0.015f),  (h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.23f * 0.015f),  (h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.23f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.23f * 0.015f),  -(h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.23f * 0.015f),  -(h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.23f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        ///o///

        hole = new Hole( (w/2 * 0.33f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  (h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  (h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  -(h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.33f * 0.015f),  -(h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.39f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.39f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.45f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.45f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.51f * 0.015f),  (h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.51f * 0.015f),  (h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.51f * 0.015f),  (h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.51f * 0.015f),  (h/2 * 0.0f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.51f * 0.015f),  -(h/2 * 0.1f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.51f * 0.015f),  -(h/2 * 0.2f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.51f * 0.015f),  -(h/2 * 0.3f * 0.015f), ballSize / 4, world, 0);
        hole.makeBody();


        hole = new Hole( (w/2 * 0.85f * 0.01f),  (h/2 * 0.7f * 0.01f), ballSize / 4, world, 1);
        hole.makeBody();
    }


    /**
     * Make world2.
     */
    public void makeWorld2() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float ratio = w /  h;
        float ballSize = (float) (ratio/6);

        hole = new Hole(0, -(h/2.7f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole(0,(h/2.7f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole(0, (h/6.75f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole(0,-(h/6.75f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();


        hole = new Hole((float) ((-w/3)) * 0.01f,
                (float) ((h/2.7f)) * 0.01f, ballSize / 4, world, 1);
        hole.makeBody();




        //draw walls


        wall = new Wall(-w/4 * 0.01f, (float) (h / 4
                * 0.01f), (float) (w -200) * 0.01f,
                h / 25 * 0.01f, world);
        wall.makeBody();

        wall = new Wall(w/4 * 0.01f, (float) 0, (float) (w -200) * 0.01f,
                h / 25 * 0.01f, world);
        wall.makeBody();

        wall = new Wall(-w/4 * 0.01f, (float) (-h / 4
                * 0.01f), (float) (w -200) * 0.01f,
                h / 25 * 0.01f, world);
        wall.makeBody();

    }


    /**
     * Make world3.
     */
    public void makeWorld3() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float ratio = w /  h;
        float ballSize = (ratio/6);

        wall = new Wall(-w/3f * 0.01f,  -(h / 6.7f * 0.01f), ballSize*2,  (w * 0.55f) * 0.01f, world);
        wall.makeBody();

        wall = new Wall(w/3f * 0.01f,  -(h / 6.7f * 0.01f), ballSize*2,  (w * 0.55f) * 0.01f, world);
        wall.makeBody();

        wall = new Wall(0, (h / 6.7f* 0.01f), ballSize*2, (float) (w * 0.55f) * 0.01f, world);
        wall.makeBody();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        hole = new Hole( -(w/2 * 0.17f * 0.01f),  -(h/2 * 0.03f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.28f * 0.01f),  -(h/2 * 0.2f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.33f * 0.01f),  -(h/2 * 0.7f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();


        hole = new Hole( -(w/2 * 0.53f * 0.01f),  (h/2 * 0.75f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.80f * 0.01f),  (h/2 * 0.33f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.86f * 0.01f),  -(h/2 * 0.44f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();




        hole = new Hole( (w/2 * 0.16f * 0.01f),  -(h/2 * 0.22f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.2f * 0.01f),  -(h/2 * 0.75f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.43f * 0.01f),  -(h/2 * 0.75f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.47f * 0.01f),  (h/2 * 0.35f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.55f * 0.01f),  (h/2 * 0.70f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.8f * 0.01f),  (h/2 * 0.43f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();


        ///////////////////////////////////////////////////////////////////////////////////////////////////

        hole = new Hole( (w/2 * 0.8f * 0.01f),  -(h/2 * 0.8f * 0.009f), ballSize / 4, world, 1);
        hole.makeBody();

    }

    /**
     * Make world4.
     */
    public void makeWorld4() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float ratio = w /  h;
        float ballSize = (ratio/5);

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  -(h/2 * 0.01f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  -(h/2 * 0.14f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  -(h/2 * 0.28f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  -(h/2 * 0.42f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  (h/2 * 0.42f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  (h/2 * 0.28f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.2f * 0.01f),  (h/2 * 0.14f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.1f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.1f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( 0,  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( 0,  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.1f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.1f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.2f* 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.2f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.0f * 0.01f),  -(h/2 * 0.2f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( 0,  (h/2 * 0.2f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();


        hole = new Hole( (w/2 * 0.3f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.3f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.4f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.4f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.5f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.5f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.5f * 0.01f),  (h/2 * 0.01f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();


        hole = new Hole( (w/2 * 0.6f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.6f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.7f * 0.01f),  (h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.7f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.7f * 0.01f),  -(h/2 * 0.56f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.7f * 0.01f),  -(h/2 * 0.42f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.7f * 0.01f),  -(h/2 * 0.28f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.7f * 0.01f),  (h/2 * 0.42f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( (w/2 * 0.7f * 0.01f),  (h/2 * 0.28f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();


        hole = new Hole( 0 ,  -(h/2 * 0.01f * 0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -(w/2 * 0.1f * 0.01f),  -(h/2 * 0.01f * 0.01f), ballSize / 4, world, 1);
        hole.makeBody();

    }

    /**
     * Make world5.
     */
    public void makeWorld5() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float ratio = w /  h;
        float ballSize = (float) (ratio/5);

        wall = new Wall(-w/2 * 0.6f * 0.01f,  -(h *0.4f * 0.01f), ballSize*2,  (w * 0.8f) * 0.01f, world);
        wall.makeBody();

        wall = new Wall(0,(h*0.245f*0.01f),(w*0.6f * 0.01f),ballSize*2, world);
        wall.makeBody();

        wall = new Wall(w/2 * 0.6f * 0.01f,  -(h *0.0f * 0.01f), ballSize*2,  (h * 0.53f) * 0.01f, world);
        wall.makeBody();

        wall = new Wall(w*0.1f*0.01f,(-h*0.245f*0.01f),(w*0.4f * 0.01f),ballSize*2, world);
        wall.makeBody();

        wall = new Wall(w*0.05f*0.01f,(h*0.075f*0.01f),(w*0.3f * 0.01f),ballSize*2, world);
        wall.makeBody();

        wall = new Wall(-w*0.088f*0.01f,(-h*0.085f*0.01f),ballSize*2,h*0.34f*0.01f, world);
        wall.makeBody();

        hole = new Hole( -w*0.04f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 1);
        hole.makeBody();


        hole = new Hole( -w/2*0.3f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.4f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.75f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.83f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.75f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.83f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.3f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.4f*0.01f,  (-h*0.085f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();


        hole = new Hole( -w/2*0.3f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.4f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.75f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.83f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.75f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.83f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.3f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.4f*0.01f,  (h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();



        hole = new Hole( -w/2*0.3f*0.01f,  (-h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.4f*0.01f,  (-h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();



        hole = new Hole( w/2*0.75f*0.01f,  (-h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.83f*0.01f,  (-h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.3f*0.01f,  (-h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.4f*0.01f,  (-h/2*0.75f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();



        hole = new Hole( w/2*0.3f*0.01f,  (h/2*0.35f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( w/2*0.4f*0.01f,  (h/2*0.35f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.3f*0.01f,  (h/2*0.35f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

        hole = new Hole( -w/2*0.4f*0.01f,  (h/2*0.35f*0.01f), ballSize / 4, world, 0);
        hole.makeBody();

    }
}
