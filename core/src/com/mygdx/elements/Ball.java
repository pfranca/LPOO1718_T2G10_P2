package com.mygdx.elements;

import com.mygdx.game.TiltMazeGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

// TODO: Auto-generated Javadoc
/**
 * The Class Ball.
 */
public class Ball extends DynamicObject implements ContactListener {

    /** The world. */
    private World world;

    /** The Radius. */
    private float r;

    /** The Game. */
    private TiltMazeGame jogo;

    /** The ball. */
    private Body ball;

    /** The hole contact Identifier. */
    private int contHole = 0;


    /**
     * Instantiates a new ball.
     *
     * @param game
     *            the game
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @param r
     *            the radius
     * @param world
     *            the world
     */
    public Ball(TiltMazeGame game, float x, float y, float r, World world)
    {
        super(x,y,r,r);
        this.jogo = game;
        this.world = world;
        this.r = r;


        world.setContactListener(this);
    }


    /**
     * Creates the ball.
     */
    public void makeBody()
    {
        Sprite ballSp = new Sprite(new Texture("img/sphere.png"));
        ballSp.setSize(r*2, r*2);
        ballSp.setOrigin(r/2, r/2);

        BodyDef bodydf = new BodyDef();
        bodydf.type = BodyType.DynamicBody;
        bodydf.position.set(position.x, position.y);

        CircleShape circle = new CircleShape();
        circle.setRadius(r);

        FixtureDef def = new FixtureDef();
        def.shape = circle;
        def.density = 1.8f;
        def.friction = 0.8f;
        def.restitution = 0.15f;


        ball = world.createBody(bodydf);
        ball.createFixture(def);
        ball.getFixtureList().get(0).setUserData("b");
        ball.setUserData(ballSp);
        circle.dispose();


    }

    /**
     * Update.
     *
     * @param deltaTime
     *            the time that passed
     */
    public void update(float deltaTime)
    {
        float acY = Gdx.input.getAccelerometerY();
        float acX = Gdx.input.getAccelerometerX();
        ball.applyForceToCenter(r*5*acY, r*5*-acX, true);

        velocity.add(acY*deltaTime, -acX*deltaTime);

        position.add(velocity.x * deltaTime, velocity.y* deltaTime);

        bounds.x = position.x -bounds.width/2;
        bounds.y = position.y - bounds.height/2;

    }


    /**
     * @see com.badlogic.gdx.physics.box2d.ContactListener#beginContact(com.badlogic.gdx.physics.box2d.Contact)
     */
    @Override
    public void beginContact(Contact contact) {
        if(contact.getFixtureA().getUserData() != null &&
                contact.getFixtureB().getUserData().equals("b") &&
                contact.getFixtureA().getUserData().equals("h")) {
            contHole = 1;
            System.out.println("contactH");
        }
        //contact with the winning hole
        if(contact.getFixtureA().getUserData() != null &&
                contact.getFixtureB().getUserData().equals("b") &&
                contact.getFixtureA().getUserData().equals("wh")) {
            contHole = 2;
            System.out.println("contactWH");
        }
        //contact with a wall
        if(contact.getFixtureA().getUserData() != null &&
                contact.getFixtureB().getUserData().equals("b") &&
                contact.getFixtureA().getUserData().equals("w")) {
            if(jogo.getVibrate())
                Gdx.input.vibrate(100);
        }

    }


    /**
     * @see com.badlogic.gdx.physics.box2d.ContactListener#endContact(com.badlogic.gdx.physics.box2d.Contact)
     */
    @Override
    public void endContact(Contact contact) {

    }


    /**
     * @see com.badlogic.gdx.physics.box2d.ContactListener#preSolve(com.badlogic.gdx.physics.box2d.Contact, com.badlogic.gdx.physics.box2d.Manifold)
     */
    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }


    /** *
     * @see com.badlogic.gdx.physics.box2d.ContactListener#postSolve(com.badlogic.gdx.physics.box2d.Contact, com.badlogic.gdx.physics.box2d.ContactImpulse)
     */
    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }


    /**
     * Gets the hole contact identifier. 0 = no contact, 1 = losing hole, 2 = winning hole
     *
     * @return the contact hole
     */
    public int getContHole() {
        return contHole;
    }


    /**
     * Sets the contact hole.
     *
     * @param i
     *            the new contact hole
     */
    public void setContHole(int i) {
        this.contHole = i;

    }


}
