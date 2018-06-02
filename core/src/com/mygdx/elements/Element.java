package com.mygdx.elements;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


/**
 * The Class Element.
 */
public class Element {

    /** The position. */
    public final Vector2 position;

    /** The bounds. */
    public final Rectangle bounds;

    /**
     * Instantiates a new element.
     *
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @param width
     *            the width
     * @param height
     *            the height
     */
    public Element(float x, float y, float width, float height)
    {
        position = new Vector2(x,y);
        bounds = new Rectangle(x-width/2, y-height/2, width, height);
    }
}
