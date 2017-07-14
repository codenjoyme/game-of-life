package com.codenjoy.life;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public abstract class LifeTest {

    abstract Life getLife(String field);

    @Test
    public void shouldEmptyField_whenNoLife() {
        // given
        Life life = getLife(
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
        Life life = getLife(
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
        Life life = getLife(
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
    public void shouldStillAlive_whenTwoNeighbours_andBorn_whenThree() {
        // given
        Life life = getLife(
                "..." +
                ".++" +
                "..+");

        // when
        life.tick();

        // then
        assertEquals(
                "..." +
                ".++" +
                ".++"
                , life.toString());
    }

    @Test
    public void shouldDie_whenMoteThanThreeNeighbours() {
        // given
        Life life = getLife(
                ".+." +
                "+++" +
                ".+.");

        // when
        life.tick();

        // then
        assertEquals(
                "+++" +
                "+.+" +
                "+++"
                , life.toString());
    }

    @Test
    public void shouldCaseI() {
        // given
        Life life = getLife(
                ".+." +
                ".+." +
                ".+.");

        // when
        life.tick();

        // then
        assertEquals(
                "..." +
                "+++" +
                "..."
                , life.toString());

        // when
        life.tick();

        // then
        assertEquals(
                ".+." +
                ".+." +
                ".+."
                , life.toString());
    }

    @Test
    public void shouldCaseO() {
        // given
        Life life = getLife(
                ".+.." +
                "+.+." +
                "+.+." +
                ".+..");

        // when
        life.tick();

        // then
        assertEquals(
                ".+.." +
                "+.+." +
                "+.+." +
                ".+..",
                life.toString());
    }

    @Test
    public void shouldCaseShip() {
        // given
        Life life = getLife(
                "+.+..." +
                ".++..." +
                ".+...." +
                "......" +
                "......" +
                "......");

        // when
        life.tick();

        // then
        assertEquals(
                "..+..." +
                "+.+..." +
                ".++..." +
                "......" +
                "......" +
                "......",
                life.toString());

        // when
        life.tick();

        // then
        assertEquals(
                ".+...." +
                "..++.." +
                ".++..." +
                "......" +
                "......" +
                "......",
                life.toString());

        // when
        life.tick();

        // then
        assertEquals(
                "..+..." +
                "...+.." +
                ".+++.." +
                "......" +
                "......" +
                "......",
                life.toString());

        // when
        life.tick();

        // then
        assertEquals(
                "......" +
                ".+.+.." +
                "..++.." +
                "..+..." +
                "......" +
                "......",
                life.toString());
    }
}