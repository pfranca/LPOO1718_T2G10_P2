package com.mygdx.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;


/**
 * The Class Wall.
 */
public class Wall extends Element
{

    /** The world. */
    private World world;

    /** The wall. */
    private Body wall;

    /**
     * Instantiates a new wall.
     *
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @param width
     *            the width
     * @param height
     *            the height
     * @param world
     *            the world
     */
    public Wall(float x, float y, float width, float height, World world)
    {
        super(x,y,width, height);
        this.world = world;
    }

    /**
     * Creates the wall body
     */
    public void makeBody()
    {
        Texture text;
        text = new Texture("img/wall.jpg");

        Sprite wallSprite;
        wallSprite = new Sprite(text);
        wallSprite.setSize(bounds.getWidth(),bounds.getHeight());
        wallSprite.setOrigin(bounds.getWidth()/2, bounds.getHeight()/2);

        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyType.StaticBody;
        bodydef.position.set(position.x,position.y);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(bounds.width/2, bounds.height/2);

        FixtureDef def = new FixtureDef();
        def.shape = shape;
        def.friction = 0.5f;
        def.restitution = 0;
        wall = world.createBody(bodydef);
        wall.createFixture(def);
        wall.getFixtureList().get(0).setUserData("w");
        wall.setUserData(wallSprite);

        shape.dispose();
    }
}

