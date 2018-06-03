package com.mygdx.elements;

import com.badlogic.gdx.math.Vector2;


/**
 * The Class DynamicObject.
 */
public class DynamicObject extends Element
{

    /** The velocity. */
    public final Vector2 velocity;

    /** The acceleration. */
    public final Vector2 acceleration;

    /**
     * Instantiates a new dynamic object.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width
     * @param height the height
     */
    public DynamicObject(float x, float y, float width, float height)
    {
        super(x,y,width, height);
        velocity = new Vector2();
        acceleration = new Vector2();
    }
}