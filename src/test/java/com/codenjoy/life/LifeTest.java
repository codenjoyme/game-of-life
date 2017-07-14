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
        Life life = new Life(4);

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
}