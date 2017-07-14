package com.codenjoy.life;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public interface Cell {

    boolean isAlive();

    void init(boolean alive);

    void born(boolean alive);
}
