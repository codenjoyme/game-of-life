package com.codenjoy.life;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public class LifeSimplicityTest extends LifeTest {
    @Override
    Life getLife(String field) {
        return new LifeSimplicity(field);
    }
}
