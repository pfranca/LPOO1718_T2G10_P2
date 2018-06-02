package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player implements Json.Serializable{

    /** The level. */
    private int level;

    /** The level stars. */
    private int[] levels = new int[5];

    /**
     * Instantiates a new player.
     */
    public Player()
    {
        this.level = 1;
        for(int i = 0; i < levels.length ; i++)
        {
            this.levels[i] = 0;
        }
    }

    /**
     * Gets the star level.
     *
     * @param i
     *            the i
     * @return the star at level i
     */
    public int getStarLevel(int i)
    {
        return levels[i-1];
    }

    /**
     * Sets the star level.
     *
     * @param i
     *            the level
     * @param s
     *            the number of stars
     */
    public void setStarLevel(int i, int s)
    {
        if(levels[i-1] < s)
            levels[i-1] = s;
    }

    /**
     * Sets the stars.
     *
     * @param array
     *            sets all the stars of all levels, used when loading data
     */
    public void setStars(@SuppressWarnings("rawtypes") Array array)
    {
        for(int i = 0; i < array.size; i++)
        {
            levels[i] = MathUtils.ceil((Float) array.get(i));
            System.out.println(levels[i]);
        }
    }

    /**
     * Gets the level.
     *
     * @return the last level the player completed
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Sets the level.
     *
     * @param level
     *           sets the last level the player completed
     */
    public void setLevel(int level)
    {
        this.level = level;
    }

    /**
     * Level passed.
     *
     * @param level2
     *            the level completed
     * @param timepassed
     *            how long it took to complete
     */
    public void levelPassed(int level2, long timepassed)
    {
        if(level2 >= level)
            level++;
        if(level > 5)
            level = 5;
        if(timepassed < (long) 12000)
            setStarLevel(level2,3);
        else if(timepassed < (long) 18000)
            setStarLevel(level2,2);
        else
            setStarLevel(level2,2);
    }

    /**
     * Loads the player data.
     *
     * @param string
     *            the data from the player
     */
    public void setPlayerFromString(String string)
    {
        this.level= Character.getNumericValue(string.charAt(0));
        for(int i = 1; i < string.length(); i++)
        {
            this.levels[i-1] = Character.getNumericValue(string.charAt(i));
        }
    }

    /**
     * @see com.badlogic.gdx.utils.Json.Serializable#write(com.badlogic.gdx.utils.Json)
     */
    @Override
    public void write(Json json) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(level));
        for(int i = 0; i < levels.length;i++)
        {
            stringBuilder.append(Integer.toString(levels[i]));
        }
        String player = json.toJson(stringBuilder.toString(), String.class);
        FileHandle f1 = Gdx.files.local("player.json");
        f1.writeString(player,false);

    }

    /**
     * @see com.badlogic.gdx.utils.Json.Serializable#read(com.badlogic.gdx.utils.Json, com.badlogic.gdx.utils.JsonValue)
     */
    @Override
    public void read(Json json, JsonValue jsonData) {
        // TODO Auto-generated method stub

    }


}
