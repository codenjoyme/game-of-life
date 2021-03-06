package com.codenjoy.life;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 *
 * Every method has maximum 4 lines of code in it’s body
 */
public class LifeSimplicity implements Life {
    public static final char ALIVE = '+';
    public static final char EMPTY = '.';

    private XY xy;
    private Field field;
    private int size;

    public LifeSimplicity(String stringField) {
        size = (int)Math.sqrt(stringField.length());
        xy = new XY(size);
        field = new Field(size);
        parseString(stringField);
    }

    private void parseString(String string) {
        for (int l = 0; l < string.length(); l++)
            field.cell(xy.getX(l), xy.getY(l)).init(string.charAt(l) == ALIVE);
    }

    @Override
    public void tick() {
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                nextGeneration(field.cell(x, y), countNeighbours(x, y));
        field.replace();
    }

    private void nextGeneration(Cell cell, int count) {
        if (cell.isAlive())
            cell.born(count >= 2 && count <= 3);
        else
            cell.born(count == 3);
    }

    private int countNeighbours(int x, int y) {
        int result = 0;
        for (int xx = -1; xx <= 1; xx++)
            for (int yy = -1; yy <= 1; yy++)
                if ((xx != 0 || yy != 0) && isAlive(x + xx, y + yy))
                    result++;
        return result;
    }

    private boolean isAlive(int x, int y) {
        if (ifOutOf(x) || ifOutOf(y))
            return false;
        return field.cell(x, y).isAlive();
    }

    private boolean ifOutOf(int a) {
        return a < 0 || a >= size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int l = 0; l < size*size; l++)
            result.append(isAlive(l) ? ALIVE : EMPTY);
        return result.toString();
    }

    private boolean isAlive(int length) {
        return field.cell(xy.getX(length), xy.getY(length)).isAlive();
    }
}
