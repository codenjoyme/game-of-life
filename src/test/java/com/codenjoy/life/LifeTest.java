package com.codenjoy.life;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public class LifeTest {

    @Test
    public void shouldEmptyField_whenNoLife() {
        // given
        Life life = new Life(
                "...." +
                "...." +
                "...." +
                "....");

        // when
        life.tick();

        // then
        assertEquals(
                "...." +
                "...." +
                "...." +
                "...."
                , life.toString());
    }

    @Test
    public void shouldDie_whenAlone() {
        // given
        Life life = new Life(
                "..." +
                ".+." +
                "...");

        // when
        life.tick();

        // then
        assertEquals(
                "..." +
                "..." +
                "..."
                , life.toString());
    }

    @Test
    public void shouldDie_whenOneNeighbour() {
        // given
        Life life = new Life(
                "..." +
                ".++" +
                "...");

        // when
        life.tick();

        // then
        assertEquals(
                "..." +
                "..." +
                "..."
                , life.toString());
    }

    @Test
    public void shouldStillAlive_whenTwoNeighbours() {
        // given
        Life life = new Life(
                "..." +
                ".++" +
                "..+");

        // when
        life.tick();

        // then
        assertEquals(
                "..." +
                ".++" +
                "..+"
                , life.toString());
    }
}