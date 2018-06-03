package com.mygdx.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;


/**
 * The Class Hole.
 */
public class Hole extends Element
{

    /** The world. */
    private World world;

    /** The radius. */
    private float r;

    /** The Hole type. */
    private int HoleType;

    /** The hole. */
    private Body hole;

    /**
     * Instantiates a new hole.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param r the r coordinate
     * @param world the world
     * @param holeType the hole type
     */
    public Hole(float x, float y, float r, World world, int holeType)
    {
        super(x,y,r,r);
        this.world = world;
        this.r = r;
        this.HoleType = holeType;
    }

    /**
     * Makes the hole Body
     */
    public void makeBody()
    {
        Texture text = null;
        switch(HoleType)
        {
            case 0:
                text = new Texture("img/hole.png");
                break;
            case 1:
                text = new Texture("img/whole.png");
                break;
        }

        Sprite holeSprite = new Sprite(text);
        holeSprite.setSize(r*9, r*9);
        holeSprite.setOrigin(r/2,r/2);
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyType.StaticBody;
        bodydef.position.set(position.x,position.y);

        CircleShape circle = new CircleShape();
        circle.setRadius(r);
        FixtureDef def = new FixtureDef();
        def.shape = circle;
        def.isSensor = true;  //Detects collision but doesn't interact

        hole = world.createBody(bodydef);
        hole.createFixture(def);

        switch (HoleType)
        {
            case 0:
                hole.getFixtureList().get(0).setUserData("h");
                break;
            case 1:
                hole.getFixtureList().get(0).setUserData("wh");
                break;
        }
        hole.setUserData(holeSprite);
        circle.dispose();
    }
}
